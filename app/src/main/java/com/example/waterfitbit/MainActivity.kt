package com.example.waterfitbit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.waterfitbit.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import layout.WaterAdapter

class MainActivity : AppCompatActivity() {

    private val waters = mutableListOf<WaterConsumption>()

    private lateinit var waterRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // setContentView(R.layout.activity_main)

        waterRecyclerView = findViewById(R.id.DataRV)
        // TODO: Set up ArticleAdapter with articles
        val articleAdapter = WaterAdapter(this, waters)
        waterRecyclerView.adapter = articleAdapter

        lifecycleScope.launch{

            (application as MyApplication).db.WaterDao().getAll().collect { databaseList ->
                databaseList.map { mappedList ->
                    // waters.clear()
                    waters.addAll(listOf(mappedList))
                    articleAdapter.notifyDataSetChanged()
                }
            }
        }

        waterRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            waterRecyclerView.addItemDecoration(dividerItemDecoration)
        }


        val add = findViewById<Button>(R.id.button)

        add.setOnClickListener {
            val i = Intent(this@MainActivity, DetailActivity::class.java)
            startActivity(i)
        }
    }

    }

