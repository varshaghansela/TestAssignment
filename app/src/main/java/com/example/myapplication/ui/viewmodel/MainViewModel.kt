package com.example.myapplication.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.ui.models.User
import com.example.myapplication.ui.models.UserDetailsResponse
import com.example.myapplication.retrofit.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewModel(context: Application) : AndroidViewModel(context), KoinComponent {

    private val apiInterface: ApiInterface by inject()
    private val disposable = CompositeDisposable()
    var userList: MutableList<User> = mutableListOf()
    fun getUserMaster(
        success: ((UserDetailsResponse) -> Unit)? = null,
        publishError: ((msg: String) -> Unit)? = null
    ) {
        disposable.add(
            apiInterface.getUserMaster()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.code == 200) {
                        userList = it.data
                        success?.invoke(it)
                    } else {
                        publishError?.invoke(it.message ?: "No Data Found")
                    }
                }, {
                    it.printStackTrace()
                    publishError?.invoke("Something went wrong..")
                })
        )
    }


}