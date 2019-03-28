package com.example.rx_sample.presentation

import domain.MainUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel {

    fun getHackerNews() {
        val useCase = MainUseCase()
        useCase.getHackerNew().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(list: List<Int>) {
        print(list)
    }

    private fun handleError(throwable: Throwable) {
        print(throwable)
    }
}
