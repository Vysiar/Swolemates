package com.example.towdow

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swolemates.Gender
import com.example.swolemates.R
import com.example.swolemates.User

import java.util.ArrayList

class ForumPostFragment : Fragment() {


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
        adapter.setLocations(potentionalMatches)

        initArray(potentionalMatches)
    }
    private fun initArray(myDataset: MutableList<User>){
        myDataset.clear()

        myDataset.add(User(111111, "Donald Pump", 24, "Blacksburg", Gender.MALE))
        myDataset.add(User(222222, "Ben Bulkenson",21, "Blacksburg", Gender.MALE))
        myDataset.add(User(333333, "Debby Deadlifts",20, "Blacksburg", Gender.FEMALE))
        myDataset.add(User(444444, "Felicity Flash",23, "Blacksburg", Gender.FEMALE))
        myDataset.add(User(555555, "Lady Macbuff",20, "Blacksburg", Gender.FEMALE))
    }


    inner class ListAdapter():
        RecyclerView.Adapter<ListAdapter.AddressViewHolder>(){
        private var locations = emptyList<User>()

        override fun getItemCount(): Int {
            return locations.size
        }



        internal fun setLocations(locations: List<User>) {
            this.locations = locations
            notifyDataSetChanged()
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.matching_card, parent, false)
            return AddressViewHolder(v)
        }
        override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {

//            holder.view.findViewById<TextView>(R.id.reply_user_text).text=locations[position].name
//            holder.view.findViewById<TextView>(R.id.reply_text).text=locations[position].short_description

            holder.itemView.setOnClickListener(){


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