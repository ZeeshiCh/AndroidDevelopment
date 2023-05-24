package com.example.databindingusingnavgraph

//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.databindingusingnavgraph.databinding.FragmentMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class Main_Fragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
//    private val _userDataFlow = MutableSharedFlow<String>()
    private val userDataFlow = MutableSharedFlow<String>()
    private val _dataByStateFlow = MutableStateFlow("String by z")
    private val dataByStateFlow: StateFlow<String> = _dataByStateFlow
    var name = "saim"
    // this is use to convert other flow into state flow
    //val dataByStateFlow = _dataByStateFlow.asStateFlow()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("onCreateView() called in Main Fragment")
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.tvBack.text = name
        binding.tvGuys.text = name

        observer()
        lifecycleScope.launch(Dispatchers.Main) {
//            userDataFlow.collectLatest { binding.tvBack.text = it }
            userDataFlow.emit("SharedFlowEmit")
        }



        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main){
            _dataByStateFlow.emit("StateFlowEmit")
            dataByStateFlow.collectLatest {
                binding.tvWelcome.text = it
            }
        }

        val button1 = view.findViewById<Button>(R.id.button2)
        val button2 = view.findViewById<Button>(R.id.button3)

//        button1.setOnClickListener {
//            viewLifecycleOwner.lifecycleScope.launch {
//                //flows()
//                userDataFlow.collectLatest {
//                    binding.tvWelcome.text = it
//                }
//            }
//
//        }


//        button2.setOnClickListener {
//            viewLifecycleOwner.lifecycleScope.launch {
//                _userDataFlow.emit("SharedFlowEmit")
//                dataByStateFlow.collectLatest {
//                    binding.tvBack.text = it
//                }
//            }
//        }


        return view
    }

    private fun observer() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main.immediate) {
            userDataFlow.collectLatest {
                name = it
            }

//            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main.immediate) {
//                userDataFlow.collectLatest {
//
//                }
//            }
        }
    }

//    private suspend fun flows() {
//        _userDataFlow.emit("Zeeshan by Shared Flow")
//    }


    override fun onStart() {
        super.onStart()
        println("onStart() called in Main Fragment")
    }

    override fun onResume() {
        super.onResume()
        println("onResume() called in Main Fragment")
    }

    override fun onStop() {
        super.onStop()
        println("onStop() called in Main Fragment")
    }

    override fun onPause() {
        super.onPause()
        println("onPause() called in Main Fragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("onDestroyView() called in Main Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy() called in Main Fragment")
    }

}



