package com.example.katalognovel


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.let as let1

/**
 * A simple [Fragment] subclass.
 */
class RomanceFragment: Fragment() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_romance, container, false)
        initView(view)
        return view
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.romance_name)
        val image = resources.obtainTypedArray(R.array.romance_image)

        items.clear()
        for (i in name.indices) {
            items.add(
                Item(
                    name[i],
                    image.getResourceId(i, 0)
                )
            )
        }

        image.recycle()
    }

    fun initView(view: View) {
        initData()
        val rv = view.findViewById<RecyclerView>(R.id.romance_list)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = activity?.let1 { RecyclerViewAdapter(it, items) }
    }
}