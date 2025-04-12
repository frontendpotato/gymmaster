package com.example.gymmaster

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import android.widget.TextView
import com.google.firebase.auth.UserProfileChangeRequest

/*class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var nameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
        
        nameInput = findViewById(R.id.etName)
        emailInput = findViewById(R.id.etEmail)
        passwordInput = findViewById(R.id.etPassword)
        
        findViewById<MaterialButton>(R.id.btnSignUp).setOnClickListener {
            signUp()
        }

        findViewById<TextView>(R.id.tvHaveAccount).setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }

    private fun signUp() {
        val name = nameInput.text.toString()
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, getString(R.string.fill_fields), Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Update user profile with name
                    val user = auth.currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(name)
                        .build()
                    
                    user?.updateProfile(profileUpdates)
                        ?.addOnCompleteListener { profileTask ->
                            if (profileTask.isSuccessful) {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            } else {
                                Toast.makeText(this, 
                                    getString(R.string.profile_update_failed, profileTask.exception?.message),
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(this, 
                        getString(R.string.registration_failed, task.exception?.message),
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}*/




import com.google.firebase.firestore.FirebaseFirestore

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var nameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var phoneInput: TextInputEditText  // Add phone input field

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        nameInput = findViewById(R.id.etName)
        emailInput = findViewById(R.id.etEmail)
        passwordInput = findViewById(R.id.etPassword)
        phoneInput = findViewById(R.id.etPhone)  // Initialize phone input

        findViewById<MaterialButton>(R.id.btnSignUp).setOnClickListener {
            signUp()
        }

        findViewById<TextView>(R.id.tvHaveAccount).setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }

    private fun signUp() {
        val name = nameInput.text.toString()
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        val phone = phoneInput.text.toString()  // Get phone number

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, getString(R.string.fill_fields), Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(name)
                        .build()

                    user?.updateProfile(profileUpdates)
                        ?.addOnCompleteListener { profileTask ->
                            if (profileTask.isSuccessful) {
                                // After user is created, store details in Firestore
                                val userMap = hashMapOf(
                                    "uid" to user.uid,
                                    "name" to name,
                                    "email" to email,
                                    "phone" to phone
                                )

                                FirebaseFirestore.getInstance()
                                    .collection("users")
                                    .document(user.uid)
                                    .set(userMap)
                                    .addOnSuccessListener {
                                        // Go to MainActivity after saving data to Firestore
                                        startActivity(Intent(this, MainActivity::class.java))
                                        finish()
                                    }
                                    .addOnFailureListener {
                                        Log.e("SignUpActivity", "Firestore Error", it)
                                        Toast.makeText(this, "Failed to store user data: ${it.message}", Toast.LENGTH_LONG).show()
                                    }


                            } else {
                                Toast.makeText(this,
                                    getString(R.string.profile_update_failed, profileTask.exception?.message),
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(this,
                        getString(R.string.registration_failed, task.exception?.message),
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}
