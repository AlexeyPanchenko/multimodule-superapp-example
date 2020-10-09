package ru.alexeypanchenko.superapp.list

import android.app.Activity
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import ru.alexeypanchenko.donorapp.add.AddInRoute
import ru.alexeypanchenko.donorapp.list.ListItem
import ru.alexeypanchenko.donorapp.list.dependencies.ListOutRoute
import javax.inject.Inject

class AppListOutRoute @Inject constructor(
    private val activity: Activity,
    private val fragmentManager: FragmentManager,
    private val addInRoute: AddInRoute,
    @IdRes private val containerId: Int
) : ListOutRoute {

    override fun openDetail(item: ListItem) {
        Toast.makeText(activity, "Not yet implemented!", Toast.LENGTH_SHORT).show()
    }

    override fun openSettings() {
        Toast.makeText(activity, "Not yet implemented!", Toast.LENGTH_SHORT).show()
    }

    override fun openAdd() {
        fragmentManager.beginTransaction()
            .replace(containerId, addInRoute.getAddFragment())
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

}