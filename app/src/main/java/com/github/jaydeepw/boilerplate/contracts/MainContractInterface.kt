package com.github.jaydeepw.boilerplate.contracts

import com.github.jaydeepw.pokemondirectory.models.dataclasses.Pokemon
import com.github.jaydeepw.pokemondirectory.models.datasource.MainDataSource
import com.github.jaydeepw.boilerplate.views.BaseView

interface MainContractInterface {

    interface View: BaseView {
        fun showData(list: ArrayList<Pokemon>?)
        fun showDetails(pokemon: Pokemon?)
    }

    interface Presenter {
        fun onGetData()
        fun onItemClick(pokemon: Pokemon?)
    }

    interface Model : MainDataSource
}