package domain

import domain.mapper.Item
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {
    @GET("topstories.json")
    fun getTopStories() : Observable<List<Int>>

    @GET("item/{itemId}.json")
    fun getItemInfo(@Path("itemId") itemId: Int): Observable<Item>
}
