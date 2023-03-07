package edu.quinnipiac.ser210.firstapp


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiInterface {

    @GET("3hourly/")
    @Headers("X-RapidAPI-Key:UygwA3LnI1mshAPcqbrTdu6rvUkxp1Kd1q6jsnETjeLq2t3LzS", "X-RapidAPI-Host:weatherbit-v1-mashape.p.rapidapi.com")
    fun getWeather(@Query("lat") lat:Double, @Query("lon") lon:Double) : Call<ArrayList<Weather?>?>?


    companion object {

        var BASE_URL = "https://weatherbit-v1-mashape.p.rapidapi.com/forecast/"


        fun create() : ApiInterface {

            val logging = HttpLoggingInterceptor()
// set your desired log level
// set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging) // <-- this is the important line!
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}