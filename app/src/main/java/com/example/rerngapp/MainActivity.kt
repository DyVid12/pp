package com.example.rerngapp


import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepage)

        bottomNavigationView = findViewById(R.id.bottom_navbar)
        frameLayout = findViewById(R.id.frameLayout)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.explor-> loadFragment(ExploreFragment(), false)
                R.id.favorite -> loadFragment(FavouriteFragment(), false)
                R.id.profile -> loadFragment( LoginFragment(),false)
                R.id.about -> loadFragment(AboutFragment(),false)

            }
            true

        }
        loadFragment(ExploreFragment(), true)
        }
    private fun loadFragment(fragment: Fragment, isAppInitialized: Boolean) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frameLayout, fragment)
        } else {
            fragmentTransaction.replace(R.id.frameLayout, fragment)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }


}
