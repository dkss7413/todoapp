package com.example.todoapp.tasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.todoapp.R
import com.example.todoapp.statistics.StatisticsActivity
import com.example.todoapp.util.setupActionBar
import com.google.android.material.navigation.NavigationView

class TasksActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    private lateinit var tasksPresenter: TasksPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks_act)

        setupActionBar(R.id.toolbar){
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        drawerLayout = (findViewById<DrawerLayout>(R.id.drawer_layout)).apply{
            setStatusBarBackground(R.color.colorPrimaryDark)
        }
        setupDrawerContent(findViewById(R.id.nav_view))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent(navigationView: NavigationView){
        navigationView.setNavigationItemSelectedListener { menuItem ->
            if(menuItem.itemId == R.id.statistics_navigation_menu_item){
                val intent = Intent(this@TasksActivity, StatisticsActivity::class.java)
                startActivity(intent)
            }

            true
        }
    }
}
