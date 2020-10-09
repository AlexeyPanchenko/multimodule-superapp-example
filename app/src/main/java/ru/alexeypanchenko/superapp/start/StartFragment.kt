package ru.alexeypanchenko.superapp.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.start_fragment.view.*
import ru.alexeypanchenko.donorapp.list.di.ListComponentsProvider
import ru.alexeypanchenko.superapp.MainActivity
import ru.alexeypanchenko.superapp.R
import javax.inject.Inject

class StartFragment : Fragment() {

    @Inject
    lateinit var startRouter: StartRouter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerStartComponent.builder()
            .listComponent(ListComponentsProvider.getListComponent())
            .mainActivityComponent((requireActivity() as MainActivity).mainActivityComponent)
            .build()
            .inject(this)

        val view: View = inflater.inflate(R.layout.start_fragment, container, false)
        view.open_list_button.setOnClickListener { startRouter.openItemsFeature() }
        return view
    }
}