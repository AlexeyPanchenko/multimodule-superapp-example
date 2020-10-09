package ru.alexeypanchenko.superapp.list

import ru.alexeypanchenko.donorapp.list.ListItem
import ru.alexeypanchenko.donorapp.list.dependencies.ListItemsRepository
import ru.alexeypanchenko.superapp.ItemsRepository
import javax.inject.Inject

class AppListItemsRepository @Inject constructor(
    private val itemsRepository: ItemsRepository
) : ListItemsRepository {

    override fun getItems(): List<ListItem> {
        return itemsRepository.getAll().map { ListItem(it.id, it.title, it.description) }
    }

}