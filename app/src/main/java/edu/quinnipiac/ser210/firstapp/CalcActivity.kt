package edu.quinnipiac.ser210.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = ApiInterface.create().getWeather(35.5,-78.5)

        //apiInterface.enqueue( Callback<List<Movie>>())
        if (apiInterface != null) {
            apiInterface.enqueue( object : Callback<ArrayList<Weather?>?> {
                override fun onResponse(call: Call<ArrayList<Weather?>?>?, response: Response<ArrayList<Weather?>?>) {
                    if (response != null) {
                        Log.d("Main activity", response.message())
                        Log.d("Main activity", response.headers().toString())
                        Log.d("Main activity", response.body().toString())
                    }

                }

                override fun onFailure(call: Call<ArrayList<Weather?>?>, t: Throwable) {
                    if (t != null) {

                        t.message?.let { Log.d("onFailure", it) }
                    }
                }
            })
        }
    }
}