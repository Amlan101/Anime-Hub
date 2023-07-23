package com.example.animehub.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animehub.R
import com.example.animehub.adapter.DashboardRecyclerAdapter
import com.example.animehub.model.Anime
import com.example.animehub.util.ConnectionManager


class DashboardFragment : Fragment() {

    private lateinit var recyclerDashboard: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: DashboardRecyclerAdapter
    private lateinit var internetChecker: Button

    private val animeInfoList = arrayListOf<Anime>(
        Anime("Naruto", "Masashi Kishimoto", "Winter 2002", "7.99", R.drawable.naruto_icon ),
        Anime("One Piece", "Eiichiro Oda", "Fall 1999", "8.69", R.drawable.one_piece_icon ),
        Anime("Re:Zero", "Tappei Nagatsuki", "Spring 2016", "8.23", R.drawable.rezero_icon),
        Anime("Classroom of the Elite", "Shōgo Kinugasa", "Summer 2017", "7.86", R.drawable.classroom_of_the_elite_icon ),
        Anime("86", "Asato Asato", "Spring 2021", "8.28", R.drawable.eighty_six_icon ),
        Anime("Goblin Slayer", "Kumo Kagyu", "Fall 2018", "7.42", R.drawable.goblin_slayer_icon ),
        Anime("Jujutsu Kaisen", "Gege Akutami", "Fall 2020", "8.64", R.drawable.jujutsu_kaisen_icon ),
        Anime("Black Clover", "Yūki Tabata", "Fall 2017", "8.14", R.drawable.black_clover_icon ),
        Anime("Rising of the Shield Hero", "Aneko Yusagi", "Winter 2019", "7.98", R.drawable.rising_of_the_shield_hero_icon ),
        Anime("Bleach", "Tite Kubo", "Fall 2004", "7.92", R.drawable.bleach_icon ),
        Anime("Grand Blue", "Kenji Inoue", "Summer 2018", "8.43", R.drawable.grand_blue_icon ),
        Anime("Kaguya-sama: Love is War", "Aka Akasaka", "Winter 2019", "8.41", R.drawable.kaguya_sama_love_is_war_icon ),
        Anime("Assassination classroom", "Yusei Matsui", "Winter 2015", "8.09", R.drawable.assassination_classroom_icon ),
        Anime("Full metal Alchemist", "Hiroshi Ōnogi", "Spring 2009", "9.10", R.drawable.fullmetal_alchemist_brotherhood_icon )
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard = view.findViewById(R.id.recycler_dashboard)
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, animeInfoList)

        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager

        // This piece of code is used to add divider lines between the list items
        recyclerDashboard.addItemDecoration(
            DividerItemDecoration(
                recyclerDashboard.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

        internetChecker = view.findViewById(R.id.btn_internet_checker)

        // This piece of code tells us whether we are connected to the internet or not
        internetChecker.setOnClickListener{
            if (ConnectionManager().checkConnectivity(activity as Context)){
                // Write code for Internet is available
                createDialogBox(activity as Context, "Success", "Found Internet Connection")
            }
            else{
                // Write code for Internet is not available
                createDialogBox(activity as Context, "Failed", "No Internet Connection Found")
            }
        }
        return view
    }

    // This Helper function helps us to create a dialog box
    private fun createDialogBox(context: Context, title: String, message: String) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setPositiveButton("OK"){text, listener ->
            // Functionalities to be performed on clicking of positive button
            Toast.makeText(activity as Context, "Yay", Toast.LENGTH_SHORT).show()
        }
        dialog.setNegativeButton("Cancel"){text, listener ->
            // Functionalities to be performed on clicking of negative button
            Toast.makeText(activity as Context, "Not yay", Toast.LENGTH_SHORT).show()
        }
        dialog.create()
        dialog.show()
    }

}