package retrofit

import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Created by Akshay Teli on 27,May,2021
 */
interface RetrofitService {

    @GET("New-indian-50-100-500-and-2000-rupees-banknotes-and-10-rupees-coin.jpg")
    suspend fun getImage():ResponseBody
}