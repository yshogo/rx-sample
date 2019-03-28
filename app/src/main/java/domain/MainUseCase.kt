package domain

import data.MainRepository
import io.reactivex.Observable

class MainUseCase {

    fun getHackerNew(): Observable<List<Int>> {
        val repository = MainRepository()
        return repository.getHackerNews()
    }
}
