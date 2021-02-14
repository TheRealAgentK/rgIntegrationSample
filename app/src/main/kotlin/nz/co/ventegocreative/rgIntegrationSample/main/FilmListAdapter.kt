package nz.co.ventegocreative.rgIntegrationSample.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import nz.co.ventegocreative.rgIntegrationSample.R
import nz.co.ventegocreative.rgIntegrationSample.data.models.Film

class FilmListAdapter constructor(val films: List<Film>, val click: (Film) -> Unit) : RecyclerView.Adapter<FilmListAdapter.ViewHolder>() {
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.row_film, parent, false)
		return ViewHolder(view, click)
	}
	
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(films[position])
	}
	
	override fun getItemCount(): Int = films.size
	
	class ViewHolder(val view: View, val click: (Film) -> Unit) : RecyclerView.ViewHolder(view) {
		
		@BindView(R.id.title)
		lateinit var tvTitle: TextView
		@BindView(R.id.description)
		lateinit var tvDescription: TextView
		
		init {
			ButterKnife.bind(this, view)
		}
		
		fun bind(film: Film) {
			with(film) {
				itemView.setOnClickListener { click(film) }
				tvTitle.text = title
				tvDescription.text = description
			}
		}
	}
	
}