package ru.alexeypanchenko.superapp.start

import dagger.Component
import ru.alexeypanchenko.donorapp.list.di.ListComponent
import ru.alexeypanchenko.superapp.di.MainActivityComponent
import javax.inject.Scope

@Scope
@Retention
annotation class StartScope

@StartScope
@Component(
    dependencies = [
        ListComponent::class,
        MainActivityComponent::class,
    ]
)
interface StartComponent {
    fun inject(target: StartFragment)
}