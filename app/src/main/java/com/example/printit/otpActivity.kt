package com.example.printit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.printit.databinding.ActivityOtpBinding
import com.google.firebase.auth.FirebaseAuth
import papaya.`in`.sendmail.SendMail
import kotlin.random.Random

class otpActivity : AppCompatActivity() {

    private  val binding by lazy {
        ActivityOtpBinding.inflate(layoutInflater)
    }

    lateinit var auth: FirebaseAuth
    var email : String=""
    var pass : String=""
    var random : Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        email=intent.getStringExtra("email").toString()
        pass=intent.getStringExtra("pass").toString()
        auth=FirebaseAuth.getInstance()

        random()

        binding.resend.setOnClickListener {
            Toast.makeText(this, "OTP Resended", Toast.LENGTH_SHORT).show()
            random()
        }

        binding.otp1.doOnTextChanged { text, start, before, count ->
            if (!binding.otp1.text.toString().isEmpty()) {
                binding.otp2.requestFocus()
            }
        }

        binding.otp2.doOnTextChanged { text, start, before, count ->
            if (!binding.otp2.text.toString().isEmpty()) {
                binding.otp3.requestFocus()
            } else {
                binding.otp1.requestFocus()
            }
        }

        binding.otp3.doOnTextChanged { text, start, before, count ->
            if (!binding.otp3.text.toString().isEmpty()) {
                binding.otp4.requestFocus()
            } else {
                binding.otp2.requestFocus()
            }
        }

        binding.otp4.doOnTextChanged { text, start, before, count ->
            if (binding.otp4.text.toString().isEmpty()) {
                binding.otp3.requestFocus()
            }
        }

        binding.confirm.setOnClickListener {
            val otp1 = binding.otp1.text.toString()
            val otp2 = binding.otp2.text.toString()
            val otp3 = binding.otp3.text.toString()
            val otp4 = binding.otp4.text.toString()

            val otp = "$otp1$otp2$otp3$otp4"

            if (otp.length < 4) {
                Toast.makeText(this@otpActivity, "Enter complete OTP", Toast.LENGTH_SHORT).show()
            } else if (otp != random.toString()) {
                Toast.makeText(this@otpActivity, "Wrong OTP", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this@otpActivity, DashboardActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@otpActivity, task.exception?.message.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
    fun random(){
        random= Random.nextInt(1000,10000)
        var mail= SendMail("kyash3651@gmail.com","jcgkxplktnsmgxju",email,"Login Signup app's OTP",
            "Your OTP is -> $random")
        mail.execute()
    }

}