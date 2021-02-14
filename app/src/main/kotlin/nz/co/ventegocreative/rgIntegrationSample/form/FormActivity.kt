package nz.co.ventegocreative.rgIntegrationSample.form

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import nz.co.ventegocreative.rgIntegrationSample.R
import nz.co.ventegocreative.rgIntegrationSample.data.LocalData
import nz.co.ventegocreative.rgIntegrationSample.data.models.Film
import nz.co.ventegocreative.rgIntegrationSample.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
	
	lateinit var binding: ActivityFormBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
		
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		
		binding.doneFab.setOnClickListener { saveFilm() }
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == android.R.id.home) {
			onBackPressed()
			return true
		}
		
		return super.onOptionsItemSelected(item)
	}
	
	override fun onBackPressed() {
		setResult(Activity.RESULT_CANCELED)
		super.onBackPressed()
	}
	
	
	private fun saveFilm() {
		with(binding) {
			LocalData(this@FormActivity).saveFilm(Film(
					titleEt.text.toString(),
					descriptionEt.text.toString(),
					directorEt.text.toString(),
					releaseDateEt.text.toString()))
		}
		setResult(Activity.RESULT_OK)
		finish()
	}
	
	companion object {
		fun getIntent(context: Context): Intent = Intent(context, FormActivity::class.java)
	}
}
