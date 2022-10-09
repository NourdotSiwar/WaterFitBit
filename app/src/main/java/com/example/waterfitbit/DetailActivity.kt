package com.example.waterfitbit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        findViewById<Button>(R.id.btnEnter).setOnClickListener{
            val cups = findViewById<EditText>(R.id.inputCups).text.toString()
            val days = findViewById<EditText>(R.id.inputDays).text.toString()

            lifecycleScope.launch(IO) {
                (application as MyApplication).db.WaterDao().insert(
                    WaterConsumption(days, cups)
                )
            }
                val i = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(i)
        }


    }
}