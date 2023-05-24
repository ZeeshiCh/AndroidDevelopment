package com.example.databindingusingnavgraph


import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.databindingusingnavgraph.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Fragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    // Firebase Auth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentLoginBinding.inflate(inflater,container,false)
        println("onCreateView() called in Login Fragment")
        val view = binding.root
        val button = view.findViewById<Button>(R.id.button)


        //firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        button.setOnClickListener{
            validateData()
            binding.progressBar.visibility= View.VISIBLE;

        }
        return view
    }

    private fun validateData() {
        email = binding.EmailFrag.text.toString().trim()
        password = binding.passwordFrag.text.toString().trim()


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.EmailFrag.error = getString(R.string.invalid_email_address)

        } else if (TextUtils.isEmpty(password)) {
            binding.passwordFrag.error = getString(R.string.please_enter_password)
        }
        else {
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            findNavController().navigate(R.id.action_login_Fragment_to_main_Fragment)

        }

        binding.progressBar.visibility= View.GONE;

    }

    override fun onStart() {
        super.onStart()
        println("onStart() called in Login Fragment")
    }

    override fun onResume(){
        super.onResume()
        println("onResume() called in Login Fragment")
    }

    override fun onStop() {
        super.onStop()
        println("onStop() called in Login Fragment")
    }

    override fun onPause(){
        super.onPause()
        println("onPause() called in Login Fragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("onDestroyView() called in Login Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy() called in Login Fragment")
    }

}
