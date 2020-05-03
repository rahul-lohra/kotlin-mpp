package com.rahullohra

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun CoroutineScope.launchCatchError(body: suspend () -> Unit, error: (t:Throwable) -> Unit) {
    launch {
        try {
            body.invoke()
        } catch (t: Throwable) {
            error.invoke(t)
        }
    }
}