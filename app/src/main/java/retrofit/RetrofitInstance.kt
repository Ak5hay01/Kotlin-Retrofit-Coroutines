package retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Akshay Teli on 27,May,2021
 */
class RetrofitInstance {

    companion object{
        val baseUrl = "https://taxguru.in/wp-content/uploads/2020/01/"

        fun getRetrofitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}