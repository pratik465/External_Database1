package com.example.external_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.external_database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var Shayrilist = ArrayList<ShayriModel>()
    lateinit var database: ExternalDatabase
    lateinit var adapter: ShayriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}