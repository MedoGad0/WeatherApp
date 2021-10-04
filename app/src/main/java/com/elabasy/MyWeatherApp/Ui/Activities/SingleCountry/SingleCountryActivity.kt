package com.elabasy.MyWeatherApp.Ui.Activities.SingleCountry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.elabasy.MyWeatherApp.R
import com.elabasy.MyWeatherApp.Ui.Activities.Home.DailyRecyclerViewAdapter
import com.elabasy.MyWeatherApp.Util.DataTesttt
import com.elabasy.MyWeatherApp.databinding.ActivitySingleCountryBinding

class SingleCountryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleCountryBinding

    // for Daily Recycler View
    private lateinit var dailyAdapter: DailyRecyclerViewAdapter
    private lateinit var dailyLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleCountryBinding.inflate(layoutInflater)
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

    }
}