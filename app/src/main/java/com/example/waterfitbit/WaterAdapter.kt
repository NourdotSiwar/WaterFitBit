package layout

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waterfitbit.R
import com.example.waterfitbit.WaterConsumption

class WaterAdapter(private val context: Context, private val waters: List<WaterConsumption>) :
    RecyclerView.Adapter<WaterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.new_water, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Get the individual article and bind to holder
        val water = waters[position]
        holder.bind(water)
    }

    override fun getItemCount() = waters.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val Days = itemView.findViewById<TextView>(R.id.txtDays)
        private val Cups = itemView.findViewById<TextView>(R.id.txtCups)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(water: WaterConsumption) {
            Days.text = water.days
            Cups.text = water.cups
        }

        override fun onClick(v: View?) {
            // Get selected article
            val water = waters[absoluteAdapterPosition]

            //  Navigate to Details screen and pass selected article
           // val intent = Intent(context, DetailActivity::class.java)
           // intent.putExtra(ARTICLE_EXTRA, article)
           // context.startActivity(intent)
        }
    }
}