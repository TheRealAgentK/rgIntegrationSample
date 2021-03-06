package nz.co.ventegocreative.rgIntegrationSample.detail

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import nz.co.ventegocreative.rgIntegrationSample.R
import nz.co.ventegocreative.rgIntegrationSample.data.models.Film

class DetailViewModel(private val film: Film) {
	
	fun getTitle() = film.title
	
	fun getSubtitle() = "${film.director} - ${film.releaseDate}"
	
	fun getDescription() = film.description
	
	fun getImageUrl() = "https://robohash.org/${film.id}.png?bgset=any"
	
	companion object {
		
		@JvmStatic
		@BindingAdapter("bind:imageUrl")
		fun loadImage(view: ImageView, imageUrl: String) {
			Picasso.with(view.context)
					.load(imageUrl)
					.error(R.drawable.mock_image)
					.into(view)
		}
	}
	
	
}