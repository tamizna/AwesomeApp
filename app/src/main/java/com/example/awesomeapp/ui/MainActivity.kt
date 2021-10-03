package com.example.awesomeapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.awesomeapp.R
import com.example.awesomeapp.databinding.ActivityMainBinding
import com.example.awesomeapp.di.components.DaggerApiComponent
import com.example.awesomeapp.di.modules.ApiModule
import com.example.awesomeapp.di.modules.CoroutineModule
import com.example.awesomeapp.ui.adapters.ImageAdapter
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mainViewModel: MainViewModel by viewModels { viewModelFactory }

    lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        imageAdapter = ImageAdapter {
            val bundle = Bundle()
            bundle.putSerializable("photo", it)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.rvContentImage.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = imageAdapter
        }

        getImages()
        initObservable()
    }

    private fun initObservable() {
        mainViewModel.images.observe(this, Observer {
            imageAdapter.addData(it.photos)
        })

        mainViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun getImages() {
        mainViewModel.getRandomImages()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_grid -> {
                binding.rvContentImage.layoutManager = GridLayoutManager(this, 2)
                imageAdapter.changeTypeView(0)
                true
            }
            R.id.action_list -> {
                binding.rvContentImage.layoutManager = LinearLayoutManager(this)
                imageAdapter.changeTypeView(1)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun inject() {
        DaggerApiComponent.builder().coroutineModule(CoroutineModule())
            .apiModule(
                ApiModule()
            ).build().inject(this)
    }

}