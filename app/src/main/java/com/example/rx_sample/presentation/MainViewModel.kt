package com.example.rx_sample.presentation

import android.util.Log
import domain.MainUseCase
import domain.mapper.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel {
    private val useCase = MainUseCase()
    fun getHackerNews() {

        useCase.getHackerNew().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(list: List<Int>) {

        for (id in list) {
            useCase.getNews(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(
                    this::handleNews, this::handleError
                )
        }
    }

    private fun handleError(throwable: Throwable) {
        Log.e("エラー", throwable.message)
    }

    private fun handleNews(item: Item) {
        Log.d("できたよー", item.title)
    }
}
