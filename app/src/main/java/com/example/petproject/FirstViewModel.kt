package com.example.petproject

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.petproject.dataClass.moreDataPerson
import com.example.petproject.requests.GetPerson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FirstViewModel(application: Application): AndroidViewModel(application) {

    var personsList: MutableList<moreDataPerson> = emptyList<moreDataPerson>().toMutableList()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchPerson(getPerson: GetPerson?){
        var buf = 0
        getPerson?.let {
            compositeDisposable.add(getPerson.getPerson()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                          personsList.add(it.data.get(buf))
                    Log.e("TAG", personsList.toString())
                    buf++

                },{

                })
            )
        }

    }

}