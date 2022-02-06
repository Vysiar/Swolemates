package com.example.swolemates


import android.content.Intent
import android.os.Bundle
import android.app.Activity
import android.os.Parcel
import android.os.Parcelable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swolemates.databinding.FragmentProfileEditorBinding
import java.util.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileEditor.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileEditor() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentProfileEditorBinding

    private lateinit var model: SwoleViewModel
    lateinit var user: User

    private lateinit var recyclerView: RecyclerView
//    val potentionalMatches = ArrayList<User>()
    val adapter = ListAdapter()

    constructor(parcel: Parcel) : this() {
        param1 = parcel.readString()
        param2 = parcel.readString()
    }


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

        binding.addActivityButton.setOnClickListener(){
            processAddIntrestClick(user,binding)
        }

        recyclerView = binding.Activities
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter.setLocations(user.interests)

//        initArray(user.interests)


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

    inner class ListAdapter() :
        RecyclerView.Adapter<ProfileEditor.ListAdapter.AddressViewHolder>() {
        private var locations = emptyList<Interest>()

        override fun getItemCount(): Int {
            return locations.size
        }


        internal fun setLocations(locations: List<Interest>) {
            this.locations = locations
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {


            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.interest_activity_card, parent, false)

//            v.findViewById<Spinner>(R.id.name).adapter = ArrayAdapter<ACTIVITY>(
//                binding.root.context,
//                android.R.layout.simple_spinner_dropdown_item,
//                ACTIVITY.values()
//            )


            return AddressViewHolder(v)
        }

        override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {


            holder.view.findViewById<Spinner>(R.id.name).adapter = ArrayAdapter<ACTIVITY>(
                binding.root.context,
                android.R.layout.simple_spinner_dropdown_item,
                ACTIVITY.values()
            )




//            holder.view.findViewById<TextView>(R.id.name).text =
//                locations[position].name + ", " + locations[position].age
//            holder.view.findViewById<TextView>(R.id.reply_text).text=locations[position].short_description

            holder.itemView.setOnClickListener() {


            }

        }


        inner class AddressViewHolder(val view: View) : RecyclerView.ViewHolder(view),
            View.OnClickListener {
            override fun onClick(view: View?) {
                if (view != null) {

                }
            }
        }


    }


    private fun processSaveAndContClick(user: User, binding: FragmentProfileEditorBinding) {
        user.name = binding.NameTextField.text.toString()
        user.age = binding.AgeTextField.text.toString().toInt()
        user.gender = binding.GenderSpinner.selectedItem as Gender
        user.aboutMe = binding.AboutMeTextField.text.toString()
        binding.root?.findNavController()?.navigate(R.id.action_profileEditor_to_matching)
//    binding.testText.setText(user.gender.toString())


    }

    private fun processAddIntrestClick(user: User, binding: FragmentProfileEditorBinding){
        user.interests.add(Interest(ACTIVITY.NOTSELECTED, -1))
    }
}