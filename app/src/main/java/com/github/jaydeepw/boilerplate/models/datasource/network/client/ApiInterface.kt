package com.github.jaydeepw.boilerplate.models.datasource.network.client

import android.graphics.pdf.PdfDocument
import com.github.jaydeepw.pokemondirectory.models.dataclasses.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("api/v2/pokemon")
    fun getPokemons(): Call<PdfDocument.Page>

    @GET("api/v2/pokemon/{id}")
    fun getPokemonDetails(@Path("id") id :Int ) : Call<Pokemon>
}