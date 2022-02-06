package com.example.swolemates

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swolemates.Gender
import com.example.swolemates.R
import com.example.swolemates.User

import java.util.ArrayList

class Matching : Fragment() {


    private lateinit var recyclerView: RecyclerView
    val potentionalMatches = ArrayList<User>()
    val adapter = ListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_matching, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView = view.findViewById(R.id.potential_matches)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter

        val model: SwoleViewModel by viewModels()
        adapter.setLocations(model.otherUsers)

//        potentionalMatches.add(User(111111, "Donald Pump", 24, "Blacksburg", Gender.MALE, true))
//        potentionalMatches.add(User(222222, "Ron Row",21, "Blacksburg", Gender.MALE, false))
//        potentionalMatches.add(User(333333, "Debby Deadlifts",20, "Blacksburg", Gender.FEMALE, true))
//        potentionalMatches.add(User(444444, "Felicity Flash",23, "Blacksburg", Gender.FEMALE, true))
//        potentionalMatches.add(User(555555, "Lady Macbuff",20, "Blacksburg", Gender.FEMALE, true))
        initArray(potentionalMatches)

        view.findViewById<ImageButton>(R.id.to_profile).setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_matching_to_profileScreen)
        }
    }
    private fun initArray(myDataset: MutableList<User>){
        myDataset.clear()

   //     myDataset.add(User(111111, "Donald Pump", 24, "Blacksburg", Gender.MALE, true))
   //     myDataset.add(User(222222, "Ron Row",21, "Blacksburg", Gender.MALE, false))
   //     myDataset.add(User(333333, "Debby Deadlifts",20, "Blacksburg", Gender.FEMALE, true))
   //     myDataset.add(User(444444, "Felicity Flash",23, "Blacksburg", Gender.FEMALE, true))
    //    myDataset.add(User(555555, "Lady Macbuff",20, "Blacksburg", Gender.FEMALE, true))
    }


    inner class ListAdapter():
        RecyclerView.Adapter<ListAdapter.AddressViewHolder>(){
        private var locations = mutableListOf<User>()

        override fun getItemCount(): Int {
            return locations.size
        }



        internal fun setLocations(locations: List<User>) {
            this.locations = locations as MutableList<User>
            notifyDataSetChanged()
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.cardview, parent, false)
            return AddressViewHolder(v)
        }
        override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {

            holder.view.findViewById<TextView>(R.id.name).text=locations[position].name + ", " + locations[position].age
            holder.view.findViewById<TextView>(R.id.gender).text= locations[position].gender.toString()

            if (locations[position].matched){
                if (locations[position].liked){
                    holder.view.findViewById<CardView>(R.id.cv).setCardBackgroundColor(Color.parseColor("#B5D9C3"))
                    holder.view.findViewById<TextView>(R.id.status_text).text = "It's a match!"
                }else{
                    //  holder.view.setBackgroundColor(Color.RED)
                    //   locations.drop(position)
                    holder.view.findViewById<TextView>(R.id.status_text).text = "Waiting for a response from " + locations[position].name
                }
            }
            holder.itemView.setOnClickListener() {
                val bundle = Bundle()
                bundle.putString("name", locations[position].name)
                bundle.putInt("age",  locations[position].age)
                bundle.putString("location",  locations[position].location)
                bundle.putString("gender",  locations[position].gender.toString())
                bundle.putString("bio",  locations[position].bio)

                view?.findNavController()?.navigate(R.id.action_matching_to_profileScreen, bundle)
            }

            holder.view.findViewById<ImageButton>(R.id.check).setOnClickListener {
                if (locations[position].liked){
                    holder.view.findViewById<CardView>(R.id.cv).setCardBackgroundColor(Color.parseColor("#B5D9C3"))
                    holder.view.findViewById<TextView>(R.id.status_text).text = "It's a match!"
                }else{
                  //  holder.view.setBackgroundColor(Color.RED)
                   //   locations.drop(position)
                    holder.view.findViewById<TextView>(R.id.status_text).text = "Waiting for a response from " + locations[position].name
                }

                locations[position].matched = true
            }

            holder.view.findViewById<ImageButton>(R.id.hide).setOnClickListener {
                Toast.makeText(activity, locations[position].name + " has been hidden", Toast.LENGTH_SHORT).show()
                this.locations.removeAt(position)
                notifyItemRemoved(position)

            }
        }



        inner class AddressViewHolder(val view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
            override fun onClick(view: View?){
                if (view != null) {

                }
            }
        }
    }
}