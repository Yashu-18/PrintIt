package com.example.printit

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.printit.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class loginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var gogleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.forget.setOnClickListener {
            startActivity(Intent(this@loginActivity,forgetpassActivity::class.java))
        }
        //login user
        binding.Login.setOnClickListener {
            val userEmail=binding.email.text.toString()
            val userPassword=binding.password.text.toString()

            Firebase.auth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener {
                if(userEmail.isEmpty() || userPassword.isEmpty()){
                    Toast.makeText(this, "Please fill all Details", Toast.LENGTH_SHORT).show()
                }else{
                    if(it.isSuccessful){
                        Toast.makeText(this, "Signin Successfull", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@loginActivity,DashboardActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this, "Failed ${it.exception?.localizedMessage}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.SignUP.setOnClickListener{
            startActivity(Intent(this@loginActivity,SignupActivity::class.java))
        }

        val default_web_client_id =
            "460770204293-l3hbqk133h4d16ptvj7up1duavlp8qja.apps.googleusercontent.com"
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(default_web_client_id)
            .requestEmail()
            .build()

        gogleSignInClient = GoogleSignIn.getClient(this, gso)
        binding.google.setOnClickListener {
            val SignInClient = gogleSignInClient.signInIntent
            launcher.launch(SignInClient)
        }



    }

    private var launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    firebaseAuthWithGoogle(account)
                } catch (e: ApiException) {
                    Toast.makeText(this, "Google sign in failed: ${e.statusCode}", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Google sign in canceled", Toast.LENGTH_SHORT).show()
            }
        }


    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        Firebase.auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = Firebase.auth.currentUser
                    val isNewUser = task.result?.additionalUserInfo?.isNewUser ?: false
                    if (isNewUser) {
                        // New user, perform additional actions if needed (e.g., saving user info to database)
                        Toast.makeText(this, "Welcome ${user?.displayName}", Toast.LENGTH_SHORT).show()
                    } else {
                        // Existing user
                        Toast.makeText(this, "Welcome back ${user?.displayName}", Toast.LENGTH_SHORT).show()
                    }
                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

}