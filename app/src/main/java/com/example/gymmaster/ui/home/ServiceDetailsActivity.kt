package com.example.gymmaster.ui.home

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class ServiceDetailsActivity : AppCompatActivity() {

    private lateinit var service: Service
    private lateinit var serviceTitle: TextView
    private lateinit var serviceDescription: TextView
    private lateinit var serviceImage: ImageView
    private lateinit var offersRecyclerView: RecyclerView
    private lateinit var offersAdapter: OffersAdapter
    private lateinit var bookButton: Button
    private lateinit var selectedDate: Calendar

    private val db = FirebaseFirestore.getInstance()
    private val offers = mutableListOf<Offer>()
    private var selectedOffer: Offer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_details)

        // Get the service passed from HomeFragment
        service = intent.getSerializableExtra("service") as Service

        // Initialize views
        serviceTitle = findViewById(R.id.serviceTitle)
        serviceDescription = findViewById(R.id.serviceDescription)
        serviceImage = findViewById(R.id.serviceImage)
        offersRecyclerView = findViewById(R.id.offersRecyclerView)
        bookButton = findViewById(R.id.bookButton)

        // Set service content
        serviceTitle.text = service.title
        serviceDescription.text = service.description
        Glide.with(this)
            .load(service.images.firstOrNull())
            .into(serviceImage)

        // Setup offers RecyclerView
        setupOffersRecyclerView()

        // Load offers
        loadOffers()

        // Setup book button
        bookButton.setOnClickListener {
            if (selectedOffer != null) {
                showDatePicker()
            } else {
                Toast.makeText(this, "Please select an offer first", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupOffersRecyclerView() {
        offersAdapter = OffersAdapter(offers) { offer ->
            selectedOffer = offer
            offersAdapter.setSelectedOffer(offer)
        }

        offersRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        offersRecyclerView.adapter = offersAdapter
    }

    private fun loadOffers() {
        db.collection("Gym")
            .document("gym1")
            .collection("services")
            .document(service.id)
            .collection("offers")
            .get()
            .addOnSuccessListener { snapshot ->
                offers.clear()
                for (doc in snapshot) {
                    val offer = doc.toObject(Offer::class.java).copy(
                        id = doc.id,
                        details = doc.getString("details") ?: "",
                        persons = doc.getLong("persons")?.toInt() ?: 1
                    )
                        offers.add(offer)
                    }
                offersAdapter.notifyDataSetChanged()
            }
    }

    private fun showDatePicker() {
        // Show date picker dialog
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, day ->
                selectedDate = Calendar.getInstance().apply {
                    set(year, month, day)
                }
                checkDateAvailability()
            },
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun checkDateAvailability() {
        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return
        
        // First check if the user already has a booking for this date
        db.collection("Gym")
            .document("gym1")
            .collection("services")
            .document(service.id)
            .collection("bookings")
            .whereEqualTo("userId", uid)
            .get()
            .addOnSuccessListener { userBookings ->
                // Check if user has any booking for this date
                val hasBooking = userBookings.documents.any { doc ->
                    val bookingDate = doc.get("requestedDate") as? Long
                    bookingDate?.let { isSameDay(Date(it), selectedDate.time) } ?: false
                }

                if (hasBooking) {
                    Toast.makeText(this, "You already have a booking for this date", Toast.LENGTH_LONG).show()
                    return@addOnSuccessListener
                }

                // First get the service capacity
                db.collection("Gym")
                    .document("gym1")
                    .collection("services")
                    .document(service.id)
                    .get()
                    .addOnSuccessListener { serviceDoc ->
                        val serviceCapacity = serviceDoc.getLong("capacity")?.toInt() ?: 0
                        Log.d("BookingDebug", "Service capacity: $serviceCapacity")

                        // Then check the total bookings for this service on this date
                        db.collection("Gym")
                            .document("gym1")
                            .collection("services")
                            .document(service.id)
                            .collection("bookings")
                            .get()
                            .addOnSuccessListener { bookingsSnapshot ->
                                // Count bookings for the selected date
                                val totalBookings = bookingsSnapshot.documents.count { doc ->
                                    val bookingDate = doc.get("requestedDate") as? Long
                                    bookingDate?.let { isSameDay(Date(it), selectedDate.time) } ?: false
                                }
                                
                                Log.d("BookingDebug", "Total bookings for date ${selectedDate.time}: $totalBookings")

                                if (totalBookings < serviceCapacity) {
                                    // There's still capacity, create the booking
                                    createBooking()
                                } else {
                                    // Capacity reached
                                    Toast.makeText(
                                        this,
                                        "Sorry, this service has reached its daily capacity of $serviceCapacity bookings for the selected date",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                            .addOnFailureListener {
                                Log.e("BookingDebug", "Error checking bookings", it)
                                Toast.makeText(
                                    this,
                                    "Error checking availability. Please try again.",
                                    Toast.LENGTH_SHORT
                                ).show()
                }
            }
            .addOnFailureListener {
                        Log.e("BookingDebug", "Error getting service capacity", it)
                        Toast.makeText(
                            this,
                            "Error retrieving service capacity. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
    }

    private fun createBooking() {
        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return

        val booking = hashMapOf(
            "createdAt" to Calendar.getInstance().time,
            "offerId" to selectedOffer?.id,
            "requestedDate" to selectedDate.timeInMillis,  // Store as Long timestamp
            "status" to "pending",
            "userId" to uid
        )

        db.collection("Gym")
            .document("gym1")
            .collection("services")
            .document(service.id)
            .collection("bookings")
            .add(booking)
            .addOnSuccessListener {
                Toast.makeText(this, "Booking created successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Log.e("BookingDebug", "Error creating booking", it)
                Toast.makeText(this, "Failed to create booking. Please try again.", Toast.LENGTH_SHORT).show()
            }
    }

    private fun isSameDay(date1: Date, date2: Date): Boolean {
        val cal1 = Calendar.getInstance().apply { time = date1 }
        val cal2 = Calendar.getInstance().apply { time = date2 }
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
    }
}

