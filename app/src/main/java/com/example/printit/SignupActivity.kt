package com.example.printit

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.printit.databinding.ActivitySignupBinding
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthProvider
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.Arrays


class SignupActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    private lateinit var gogleSignInClient: GoogleSignInClient
    private val TAG = "FacebookLogin"
    private val RC_SIGN_IN = 12345

    private var mCallbackManager: CallbackManager? = null

    private var mAuth: FirebaseAuth? = null
    override fun onStart() {
        super.onStart()
        val currentuser: FirebaseUser? = Firebase.auth.currentUser
        if (currentuser != null) {
            startActivity(Intent(this@SignupActivity, DashboardActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.login.setOnClickListener {
            startActivity(Intent(this@SignupActivity, loginActivity::class.java))
        }

        binding.signup.setOnClickListener {

            val UserData = userData(
                binding.firstname.text.toString(),
                binding.lastname.text.toString(),
                binding.email.text.toString(),
                binding.password.text.toString()
            )



            if (UserData.email.isEmpty() || UserData.firstname.isEmpty() || UserData.lastname.isEmpty() || UserData.password.isEmpty()) {
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()
            } else if (UserData.password != binding.conpassword.text.toString()) {
                Toast.makeText(this, "Password Does not match", Toast.LENGTH_SHORT).show()
            } else {
             /*  Firebase.auth.createUserWithEmailAndPassword(UserData.email, UserData.password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Signup Successfull", Toast.LENGTH_SHORT).show()
                            startActivity(
                                Intent(
                                    this@SignupActivity,
                                    DashboardActivity::class.java
                                )
                            )
                            finish()

                        } else {
                            Toast.makeText(
                                this,
                                "Failed ${it.exception?.localizedMessage}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }*/
                var intent=Intent(this@SignupActivity,otpActivity::class.java)
                intent.putExtra("email",binding.email.text.toString())
                intent.putExtra("pass",binding.password.text.toString())
                startActivity(intent)
            }

        }
       //google auth
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

        //facebook auth

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(mCallbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    // App code
                    handleFacebookAccessToken(loginResult.accessToken)
                }

                override fun onCancel() {
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    // App code
                }
            })

        binding.Facebook.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this@SignupActivity, Arrays.asList("public_profile"))
        }



    }
  //google
    private var launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                if (task.isSuccessful) {
                    val account: GoogleSignInAccount? = task.result
                    val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
                    Firebase.auth.signInWithCredential(credential).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Signup Successfull", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

    //facebook
    private fun handleFacebookAccessToken(token: AccessToken) {


        val credential = FacebookAuthProvider.getCredential(token.token)
        mAuth?.signInWithCredential(credential)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this, "Signup Successfull", Toast.LENGTH_SHORT).show()
                    startActivity(
                        Intent(
                            this@SignupActivity,
                            DashboardActivity::class.java
                        )
                    )
                    finish()
                    // Update UI
                    // updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                    // Update UI
                    // updateUI(null)
                }
            }
    }
    protected override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mCallbackManager?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }



}