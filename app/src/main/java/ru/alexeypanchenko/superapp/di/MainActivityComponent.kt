package ru.alexeypanchenko.superapp.di

import android.app.Activity
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.superapp.MainActivity
import ru.alexeypanchenko.superapp.R
import javax.inject.Scope

@Scope
@Retention
annotation class MainActivityScope

@MainActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun getFragmentContainer(): Int
    fun getActivity(): Activity
    fun getFragmentManager(): FragmentManager
    fun inject(target: MainActivity)
}

@Module
class MainActivityModule(
    private val activity: AppCompatActivity
) {

    @MainActivityScope
    @Provides
    @IdRes
    fun provideFragmentContainer(): Int {
        return R.id.container
    }

    @MainActivityScope
    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @MainActivityScope
    @Provides
    fun provideFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }

}