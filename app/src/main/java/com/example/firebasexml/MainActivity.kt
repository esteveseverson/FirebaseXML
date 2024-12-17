package com.example.firebasexml

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasexml.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        lateinit var auth: FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signIn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
        binding.signOut.setOnClickListener {
            auth.signOut()
            binding.userDetails.text = updateDate()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.userDetails.text = updateDate()
    }

    private fun updateDate(): String{
        return "Email: ${auth.currentUser?.email}"
    }
}