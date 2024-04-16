package com.example.printit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.printit.databinding.ActivityForgetpassBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class forgetpassActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityForgetpassBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.send.setOnClickListener {
            validateData()
        }


    }


    private fun validateData() {
        val email=binding.email.text.toString()
        if(email.isEmpty()){
            binding.email.setError("Required")
        }else{
            forgetPassword(email)
        }
    }

    private fun forgetPassword(email:String) {
        Firebase.auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this@forgetpassActivity, "Reset Link has been send", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@forgetpassActivity,loginActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this, "Failed ${it.exception?.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}