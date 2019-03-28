package data

import domain.MainService
import domain.mapper.Item
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {

    fun getHackerNews(): Observable<List<Int>> {
        val repository = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://hacker-news.firebaseio.com/v0/").build()
        val service = repository.create(MainService::class.java)
        return service.getTopStories()
    }

    fun getNewsItem(itemId: Int): Observable<Item> {
        val repository = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://hacker-news.firebaseio.com/v0/").build()
        val service = repository.create(MainService::class.java)
        return service.getItemInfo(itemId)
    }
}
