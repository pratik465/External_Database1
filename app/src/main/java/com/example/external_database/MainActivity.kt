package com.example.external_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.external_database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var Shayrilist = ArrayList<ShayriModel>()
    lateinit var dbHelper: ExternalDatabase
    lateinit var adapter: ShayariAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = ShayariAdapter()

        dbHelper = ExternalDatabase(this)
        Shayrilist = dbHelper.shayri as ArrayList<ShayriModel>

        adapter.setshayri(Shayrilist)

        binding.rcvlistShayri.layoutManager = LinearLayoutManager(this)
        binding.rcvlistShayri.adapter = adapter

    }
}

