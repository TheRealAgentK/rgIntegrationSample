package nz.co.ventegocreative.rgIntegrationSample.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import nz.co.ventegocreative.rgIntegrationSample.data.models.Film
import java.net.URL

class FilmsRequest() {
	
	companion object {
		private val FILMS_URL = "https://ghibliapi.herokuapp.com/films"
	}
	
	fun send(): List<Film> {
		val result = URL(FILMS_URL).readText()
		
		return Gson().fromJson<List<Film>>(result, object : TypeToken<List<Film>>() {}.type)
	}
}