package ir.oxima.githubtrending.models.interfaces

import ir.oxima.githubtrending.models.models.Category

interface IReloadTrends {
    fun onChangeCategory(category: Category?)
}