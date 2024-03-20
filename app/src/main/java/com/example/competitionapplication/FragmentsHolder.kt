package com.example.competitionapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.competitionapplication.databinding.ActivityFragmentsHolderBinding

class FragmentsHolder : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentsHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_holder)

        binding = ActivityFragmentsHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Home())

        binding.BottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.Home -> replaceFragment(Home())
                R.id.Groups -> replaceFragment(Groups())
                R.id.AddGroupExpense -> {
                    val addGroupExpenseIntent = Intent(this, AddGroupExpense::class.java)
                    startActivity(addGroupExpenseIntent)
                }
                R.id.History -> replaceFragment(History())
                R.id.Account -> replaceFragment(Account())

                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout, fragment)
        fragmentTransaction.commit()
    }
}