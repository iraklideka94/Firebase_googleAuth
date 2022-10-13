
package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseauth.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")

        binding.textView.text = email + "\n" + displayName

        binding.signOutBtn.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}