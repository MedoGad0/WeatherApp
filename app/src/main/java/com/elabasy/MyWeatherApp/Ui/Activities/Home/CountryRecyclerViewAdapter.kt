package com.elabasy.MyWeatherApp.Ui.Activities.Home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elabasy.MyWeatherApp.Interface.OnItemRecyclerViewClickListener
import com.elabasy.MyWeatherApp.Util.DataTesttt
import com.elabasy.MyWeatherApp.databinding.ItemCountryRecyclerViewBinding
import com.elabasy.MyWeatherApp.databinding.ItemDailyRecyclerViewBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder as ViewHolder1

@SuppressLint("NotifyDataSetChanged")
class CountryRecyclerViewAdapter(
    list: ArrayList<DataTesttt>? = null,
    var context: Context? = null
) :
    RecyclerView.Adapter<CountryRecyclerViewAdapter.ItemViewHolder>() {

    private var list = ArrayList<DataTesttt>()
    private lateinit var clickListener: OnItemRecyclerViewClickListener


    init {
        if (list != null) {
            this.list = ArrayList<DataTesttt>(list)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<DataTesttt>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    // to mack OnClickListener from activity
    @SuppressLint("NotifyDataSetChanged")
    fun setOnItemClick(recyclerViewOnItemClick: OnItemRecyclerViewClickListener) {
        clickListener = recyclerViewOnItemClick
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemCountryRecyclerViewBinding = ItemCountryRecyclerViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = list[position]
        holder.binding.item.setOnClickListener { clickListener.setOnItemClickListener(position) }
        holder.binding.delete.setOnClickListener { remove(list[position]) }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemViewHolder(itemView: ItemCountryRecyclerViewBinding) :
        ViewHolder1(itemView.root) {
        val binding: ItemCountryRecyclerViewBinding = itemView

    }

    private fun add(data: DataTesttt) {
        list.add(data)
        notifyItemInserted(list.size - 1)
    }

//    fun addAll(mcList: ArrayList<DataTesttt>) {
//        for (mc in mcList) {
//            add(mc)
//        }
//    }

    private fun remove(item: DataTesttt) {
        val position = list.indexOf(item)
        if (position > -1) {
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }


}