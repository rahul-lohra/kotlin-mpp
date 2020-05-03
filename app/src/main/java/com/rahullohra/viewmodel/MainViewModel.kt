package com.rahullohra.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahullohra.Fail
import com.rahullohra.LiveDataResult
import com.rahullohra.Success
import com.rahullohra.launchCatchError
import com.rahullohra.usecase.GetPhotosUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainViewModel @Inject constructor(
    val usecase: GetPhotosUseCase,
    val worker: CoroutineDispatcher
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = worker

    val photosLiveData = MutableLiveData<LiveDataResult<String>>()

    fun getPhotos(text: String, page: Int) {
        launchCatchError(body = {
            val data = usecase.searchPhotos(text, page)
            photosLiveData.postValue(Success(data))
        }) {
            photosLiveData.postValue(Fail(it))
            it.printStackTrace()
        }
    }
}