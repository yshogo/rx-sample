package domain

import data.MainRepository
import domain.mapper.Item
import io.reactivex.Observable

class MainUseCase {

    fun getHackerNew(): Observable<List<Int>> {
        val repository = MainRepository()
        return repository.getHackerNews()
    }

    fun getNews(itemId: Int): Observable<Item> {
        val repository = MainRepository()
        return repository.getNewsItem(itemId)
    }
}
