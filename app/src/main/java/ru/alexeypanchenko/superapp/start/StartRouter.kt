package ru.alexeypanchenko.superapp.start

import androidx.fragment.app.FragmentManager
import ru.alexeypanchenko.donorapp.list.ListInRoute
import javax.inject.Inject

class StartRouter @Inject constructor(
    private val listInRoute: ListInRoute,
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) {

    fun openItemsFeature() {
        fragmentManager
            .beginTransaction()
            .replace(containerId, listInRoute.listFragment())
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }
}