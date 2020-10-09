package ru.alexeypanchenko.superapp

import android.app.Application
import ru.alexeypanchenko.donorapp.add.di.AddItemDependenciesProvider
import ru.alexeypanchenko.donorapp.add.di.AddItemModule
import ru.alexeypanchenko.donorapp.add.di.DaggerAddItemComponent
import ru.alexeypanchenko.donorapp.list.di.DaggerListComponent
import ru.alexeypanchenko.donorapp.list.di.ListComponentsProvider
import ru.alexeypanchenko.donorapp.list.di.ListModule
import ru.alexeypanchenko.superapp.di.AppModule
import ru.alexeypanchenko.superapp.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule((this)))
            .build()
        ListComponentsProvider.setListComponentFactory {
            DaggerListComponent.builder()
                .listModule(ListModule())
                .listDependencies(appComponent)
                .build()
        }
        AddItemDependenciesProvider.setAddItemComponentFactory {
            DaggerAddItemComponent.builder()
                .addItemModule(AddItemModule())
                .addItemDependencies(appComponent)
                .build()
        }
    }
}