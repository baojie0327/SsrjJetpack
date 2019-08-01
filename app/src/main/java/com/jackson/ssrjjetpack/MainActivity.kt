package com.jackson.ssrjjetpack


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.readystatesoftware.systembartint.SystemBarTintManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAppBar(0)
        val navHostFragment: NavHostFragment= supportFragmentManager.findFragmentById(R.id.main_nav) as NavHostFragment
        val navController:NavController=Navigation.findNavController(this,R.id.main_nav)
        NavigationUI.setupWithNavController(bottomNavigation,navController)
       // bottomNavigation.setupWithNavController(navController)





    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this,R.id.bottomNavigation).navigateUp()
    }


}
