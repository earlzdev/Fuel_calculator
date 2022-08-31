package com.freed_asd.fuel_calculator.presentation.main

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.ActivityMainBinding
import com.freed_asd.fuel_calculator.presentation.about.AboutDialogFragment
import com.freed_asd.fuel_calculator.presentation.main.viewpager.ViewPagerAdapter
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.MileageStatsActivity
import com.freed_asd.fuel_calculator.presentation.statistic.trips.TripsStatsActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        viewPager()
        drawer()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun viewPager() {

        binding.viewpager.adapter = ViewPagerAdapter(this)
        binding.tableLayout.tabIconTint = null

        binding.tableLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportActionBar?.title = tab?.contentDescription
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit

            override fun onTabReselected(tab: TabLayout.Tab?) = Unit
        })

        TabLayoutMediator(binding.tableLayout, binding.viewpager) { tab, pos ->
            when(pos) {
                0 -> {
                    tab.setIcon(R.drawable.ic_cons_toolbar)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                    tab.contentDescription = getString(R.string.calc_cons_toolbar)
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_price_toolbar)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                    tab.contentDescription = getString(R.string.calc_price_toolbar)
                }
                2 -> {
                    tab.setIcon(R.drawable.ic_distance_toolbar)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                    tab.contentDescription = getString(R.string.calc_distance_toolbar)
                }
            }
        }.attach()
    }

    private fun drawer() {

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.statistic -> {
                    startActivity(Intent(this, MileageStatsActivity::class.java))
                    drawerLayout.closeDrawers()
                }
                R.id.trips -> {
                    startActivity(Intent(this, TripsStatsActivity::class.java))
                    drawerLayout.closeDrawers()
                }
                R.id.communicate -> { communicateWithDev() }
                R.id.rate -> { rate() }
                R.id.share -> { share() }
                R.id.about -> {
                    about()
                    drawerLayout.closeDrawers()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun communicateWithDev() {
        val intent = Intent(
            Intent.ACTION_SENDTO,
            Uri.fromParts("mailto", "esinilyadev@gmail.com", null)
        )
        intent.putExtra(Intent.EXTRA_SUBJECT, "Топливный калькулятор")
        try {
            startActivity(Intent.createChooser(intent, "Выберите мессенджер..."))
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                this@MainActivity,
                R.string.no_emails_client,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun rate() {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
        }
    }

    private fun share() {
        val email = Intent(Intent.ACTION_SEND)
        email.putExtra(Intent.EXTRA_SUBJECT, "Приложение для расчета расхода топлива")
        email.putExtra(Intent.EXTRA_TEXT, "Рекомендую этот Топливный калькулятор, скачать можно отсюда:" +
                "\n ${"https://play.google.com/store/apps/details?id=$packageName"}")
        email.type = "message/rfc822"
        startActivity(Intent.createChooser(email, "Выберите e-mail клиент: "))
    }

    private fun about() {
        AboutDialogFragment.newInstance().show(supportFragmentManager.beginTransaction(), AboutDialogFragment.TAG)
    }
}