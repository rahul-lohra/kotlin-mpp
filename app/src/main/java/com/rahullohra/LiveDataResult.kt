package com.rahullohra

sealed class LiveDataResult<out T>
data class Success<out T>(val data: T) : LiveDataResult<T>()
data class Fail<out T>(val ex: Throwable) : LiveDataResult<T>()
class Loading<out T> : LiveDataResult<T>()