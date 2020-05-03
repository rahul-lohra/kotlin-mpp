package com.rahullohra.di.components

import com.rahullohra.activities.MainActivity
import com.rahullohra.di.modules.ActivityModule
import com.rahullohra.di.modules.DispatcherModule
import com.rahullohra.di.modules.NetworkModule
import com.rahullohra.di.modules.ViewModelModule
import com.rahullohra.di.scopes.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class, DispatcherModule::class, ViewModelModule::class, NetworkModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}