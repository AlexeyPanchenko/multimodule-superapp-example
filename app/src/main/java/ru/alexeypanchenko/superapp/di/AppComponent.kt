package ru.alexeypanchenko.superapp.di

import dagger.Component
import ru.alexeypanchenko.donorapp.add.di.AddItemDependencies
import ru.alexeypanchenko.donorapp.list.di.ListDependencies
import ru.alexeypanchenko.superapp.add.AppAddItemModule
import ru.alexeypanchenko.superapp.db.DatabaseModule
import ru.alexeypanchenko.superapp.list.AppListModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppListModule::class,
        AppAddItemModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent : ListDependencies, AddItemDependencies {
}