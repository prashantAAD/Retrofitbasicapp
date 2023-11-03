package www.revengerfitness.blogspot.com.retrofitbasicapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import www.revengerfitness.blogspot.com.retrofitbasicapp.model.News
import www.revengerfitness.blogspot.com.retrofitbasicapp.R
import www.revengerfitness.blogspot.com.retrofitbasicapp.repository.NewsService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()
    }
    fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in", 1)
        news.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("prashant chauhan", "error in fetching news", t)
            }



            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {

                    Log.d("prashant chauhan",news.toString())

                }
            }


        })
    }

}