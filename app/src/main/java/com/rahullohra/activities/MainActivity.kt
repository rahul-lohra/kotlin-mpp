package com.rahullohra.activities

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahullohra.MainAdapter
import com.rahullohra.R
import com.rahullohra.di.components.DaggerActivityComponent
import com.rahullohra.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainAdapter
    val dataList = arrayListOf<String>()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerActivityComponent.builder()
            .build()
            .inject(this)

        val viewModelProvider = ViewModelProviders.of(this, viewModelFactory)
        mainViewModel = viewModelProvider[MainViewModel::class.java]

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MainAdapter(dataList)

        etSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchImages(etSearch.text.toString().decapitalize().trim())
                closeKeyboard()
                true
            } else
                false
        }

        searchImages("Delhi")
    }

    fun searchImages(text: String) {
        mainViewModel.getPhotos(text, 10)
    }

    fun closeKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(etSearch.windowToken, 0)
    }
}
