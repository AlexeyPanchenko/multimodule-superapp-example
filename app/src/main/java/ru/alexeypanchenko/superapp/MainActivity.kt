package ru.alexeypanchenko.superapp

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import ru.alexeypanchenko.donorapp.add.di.AddItemDependenciesProvider
import ru.alexeypanchenko.donorapp.list.di.ListComponentsProvider
import ru.alexeypanchenko.superapp.add.DaggerAppAddItemUiComponent
import ru.alexeypanchenko.superapp.di.DaggerMainActivityComponent
import ru.alexeypanchenko.superapp.di.MainActivityComponent
import ru.alexeypanchenko.superapp.di.MainActivityModule
import ru.alexeypanchenko.superapp.list.DaggerAppListUiComponent
import ru.alexeypanchenko.superapp.start.StartFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

	lateinit var mainActivityComponent: MainActivityComponent

	@Inject
	lateinit var localFragmentManager: FragmentManager

	@JvmField
	@field:[Inject]
	@IdRes
	var containerId: Int = 0

	override fun onCreate(savedInstanceState: Bundle?) {
		initDependenciesProviders()
		mainActivityComponent.inject(this)
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		if (localFragmentManager.findFragmentById(containerId) == null) {
			supportFragmentManager
				.beginTransaction()
				.replace(R.id.container, StartFragment())
				.commitAllowingStateLoss()
		}
	}

	private fun initDependenciesProviders() {
		mainActivityComponent = DaggerMainActivityComponent.builder()
			.mainActivityModule(MainActivityModule(this))
			.build()

		ListComponentsProvider.setListUiComponentDependenciesFactory(
			{
				DaggerAppListUiComponent.builder()
					.mainActivityComponent(mainActivityComponent)
					.addItemComponent(AddItemDependenciesProvider.getAddItemComponent())
					.build()
			},
			lifecycle
		)
		AddItemDependenciesProvider.setUiComponentDependenciesFactory(
			{
				DaggerAppAddItemUiComponent.builder()
					.mainActivityComponent(mainActivityComponent)
					.build()
			},
			lifecycle
		)
	}
}