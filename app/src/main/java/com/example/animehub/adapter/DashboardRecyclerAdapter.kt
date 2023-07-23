package com.example.animehub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.animehub.R
import com.example.animehub.model.Anime

class DashboardRecyclerAdapter(private val context: Context, private val itemList: ArrayList<Anime>): RecyclerView.Adapter<DashboardRecyclerAdapter.DashBoardViewHolder>() {

    class DashBoardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvAnimeName: TextView = view.findViewById(R.id.tv_anime_name)
        val tvAnimeAuthor: TextView = view.findViewById(R.id.tv_anime_author)
        val tvAnimeReleaseSeason: TextView = view.findViewById(R.id.tv_release_season)
        val tvAnimeRating: TextView = view.findViewById(R.id.tv_anime_rating)
        val imgAnimeIcon: ImageView = view.findViewById(R.id.img_anime_image )
        val contentLayout: LinearLayout = view.findViewById(R.id.content_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder {
        // This method is responsible for creating the initial viewHolders, be it 5,10 or as many fit on the screen
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row, parent, false )

        return DashBoardViewHolder(view)
    }

    override fun getItemCount(): Int {
        // This method is responsible for storing the total number of items on the list.
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
        // This method is responsible for recycling and reusing the viewHolders
        val anime = itemList[position]
        holder.tvAnimeName.text = anime.animeName
        holder.tvAnimeAuthor.text = anime.animeAuthor
        holder.tvAnimeReleaseSeason.text = anime.animeReleaseDate
        holder.tvAnimeRating.text = anime.animeRating
        holder.imgAnimeIcon.setImageResource(anime.animeImage)

        holder.contentLayout.setOnClickListener{
            Toast.makeText(context, "Clicked on ${holder.tvAnimeName.text}", Toast.LENGTH_SHORT).show()
        }
    }
}