package com.example.mypratice_navigationandtoolbar_appbarconfiguration_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.mypratice_navigationandtoolbar_appbarconfiguration_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.materialToolbar.inflateMenu(R.menu.menu_toolbar)

        //在Activity取得NavController，A方法
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        val navController = navHostFragment.findNavController()

        //在Activity取得NavController，B方法
        val navHostFragment = binding.fragmentContainerView.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()

        //將ToolBar和Navigation和appBarConfiguration建立關聯
        //Builder()方法中填入的參數用於指定頂層Fragment
        val appBarConfiguration = AppBarConfiguration.Builder(R.navigation.nav_graph).build()
        //setupWithNavController()用於將Toolbar與 NavController 和 AppBarConfiguration 綁定
        binding.materialToolbar.setupWithNavController(navController, appBarConfiguration)

        //設置一個ToolBar的監聽器
        binding.materialToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.helpFragment -> {
                    it.onNavDestinationSelected(navController)
                    true
                }
                else -> {false}
            }
        }
    }
}