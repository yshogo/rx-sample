package domain

import domain.mapper.NewsId
import io.reactivex.Observable
import retrofit2.http.GET

interface MainService {
    @GET("topstories.json")
    fun getTopStories() : Observable<List<Int>>
}
