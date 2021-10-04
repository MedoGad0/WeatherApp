package com.elabasy.MyWeatherApp.Ui.Activities.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.elabasy.MyWeatherApp.Interface.OnItemRecyclerViewClickListener
import com.elabasy.MyWeatherApp.R
import com.elabasy.MyWeatherApp.Ui.Activities.SingleCountry.SingleCountryActivity
import com.elabasy.MyWeatherApp.Util.DataTesttt
import com.elabasy.MyWeatherApp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    // for Daily Recycler View
    private lateinit var dailyAdapter: DailyRecyclerViewAdapter
    private lateinit var dailyLayout: GridLayoutManager

    // for Country Recycler View
    private lateinit var countryAdapter: CountryRecyclerViewAdapter
    private lateinit var countryLayout: GridLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set status background white
        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        // set status background text white
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        var arrayList = ArrayList<DataTesttt>()
        arrayList.add(DataTesttt("0"))
        arrayList.add(DataTesttt("0"))
        arrayList.add(DataTesttt("0"))
        arrayList.add(DataTesttt("0"))
        arrayList.add(DataTesttt("0"))



        dailyAdapter = DailyRecyclerViewAdapter(null, this)
        dailyAdapter.setList(arrayList)
        binding.daysRecyclerView.adapter = dailyAdapter

        dailyLayout = GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
        binding.daysRecyclerView.layoutManager = dailyLayout


        // for Country Recycler View
        var arrayList2 = ArrayList<DataTesttt>()
        arrayList2.add(DataTesttt("0"))
        arrayList2.add(DataTesttt("0"))
        arrayList2.add(DataTesttt("0"))
        arrayList2.add(DataTesttt("0"))
        arrayList2.add(DataTesttt("0"))

        countryAdapter = CountryRecyclerViewAdapter(null, this)
        countryAdapter.setList(arrayList2)
        binding.countryRecyclerView.adapter = countryAdapter

        countryLayout = GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
        binding.countryRecyclerView.layoutManager = countryLayout

        countryAdapter.setOnItemClick(object : OnItemRecyclerViewClickListener {
            override fun setOnItemClickListener(position: Int) {
                startActivity(Intent(this@HomeActivity, SingleCountryActivity::class.java))
            }
        })

    }


}