package com.github.jaydeepw.boilerplate.views

interface BaseView {
    fun showError(messageResId: Int)
    fun showError(message: String)
    fun showProgress()
    fun hideProgress()
}