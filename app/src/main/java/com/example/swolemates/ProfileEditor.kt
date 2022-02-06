package com.example.swolemates


import android.content.Intent
import android.os.Bundle
import android.app.Activity
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.swolemates.databinding.FragmentProfileEditorBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileEditor.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileEditor : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentProfileEditorBinding

    private lateinit var model: SwoleViewModel
    lateinit var user: User



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        binding = FragmentProfileEditorBinding.inflate(layoutInflater)
        val view = binding.root

        model = ViewModelProvider(this.requireActivity()).get(SwoleViewModel::class.java)
        user = model.user


        binding.GenderSpinner.adapter = ArrayAdapter<Gender>(
            view.context,
            android.R.layout.simple_spinner_dropdown_item,
            Gender.values()
        )

        binding.SaveAndContinueButton.setOnClickListener() {
            processSaveAndContClick(user, binding)
        }





    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
//        return inflater.inflate(R.layout.fragment_profile_editor, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileEditor.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileEditor().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


private fun processSaveAndContClick(user: User, binding: FragmentProfileEditorBinding) {
    user.name = binding.NameTextField.text.toString()
    user.age = binding.AgeTextField.text.toString().toInt()
    user.gender = binding.GenderSpinner.selectedItem as Gender
    user.aboutMe = binding.AboutMeTextField.text.toString()
    binding.root?.findNavController()?.navigate(R.id.action_profileEditor_to_preferences)
//    binding.testText.setText(user.gender.toString())






}