package nz.co.ventegocreative.rgIntegrationSample.detail

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import nz.co.ventegocreative.rgIntegrationSample.R
import nz.co.ventegocreative.rgIntegrationSample.data.models.Film
import nz.co.ventegocreative.rgIntegrationSample.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
	
	lateinit var binding: ActivityDetailBinding
	
	lateinit var film: Film
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
		
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		
		film = intent.getParcelableExtra(EXTRA_FILM)!!
		
		binding.model = DetailViewModel(film)
		
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == android.R.id.home) {
			onBackPressed()
			return true
		}
		
		return super.onOptionsItemSelected(item)
	}
	
	
	companion object {
		
		val EXTRA_FILM = "_EXTRA_FILM"
		
		fun getIntent(context: Context, film: Film): Intent = Intent(context, DetailActivity::class.java)
				.putExtra(EXTRA_FILM, film)
		
	}
}
