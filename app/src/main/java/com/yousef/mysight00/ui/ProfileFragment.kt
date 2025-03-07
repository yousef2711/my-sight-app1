package com.yousef.mysight00.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yousef.mysight00.R
import com.yousef.mysight00.ui.adapter.ProfileAdapter
import com.yousef.mysight00.ui.model.ProfileItem

class ProfileFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = listOf(
            ProfileItem(R.drawable.ic_favorite, "Favourites"),
            ProfileItem(R.drawable.ic_download, "Downloads"),
            ProfileItem(R.drawable.ic_language, "Languages"),
            ProfileItem(R.drawable.ic_location, "Location"),
            ProfileItem(R.drawable.ic_clear_cache, "Clear Cache"),
            ProfileItem(R.drawable.ic_clear_history, "Clear History"),
            ProfileItem(R.drawable.ic_logout, "Log Out")
        )

        val adapter = ProfileAdapter(items)
        recyclerView.adapter = adapter
    }
}
