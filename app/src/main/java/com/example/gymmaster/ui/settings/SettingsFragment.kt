package com.example.gymmaster.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.gymmaster.R
import android.content.Intent
import com.example.gymmaster.SignInActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logoutButton = view.findViewById<MaterialButton>(R.id.btnLogout)
        logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            // Navigate back to the login screen (e.g., SignInActivity)
            val intent = Intent(requireContext(), SignInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
