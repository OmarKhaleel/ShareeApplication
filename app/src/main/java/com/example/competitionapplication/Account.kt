package com.example.competitionapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.Color
import android.widget.TextView
import com.example.competitionapplication.databinding.FragmentAccountBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Account.newInstance] factory method to
 * create an instance of this fragment.
 */
class Account : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentAccountBinding
    private lateinit var aboutTab: TextView
    private lateinit var myWalletTab: TextView
    private var selectedTab: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        binding = FragmentAccountBinding.inflate(layoutInflater)

        replaceFragment(About())

        aboutTab = view.findViewById(R.id.AboutTabTV)
        myWalletTab = view.findViewById(R.id.MyWalletTabTV)

        aboutTab.setOnClickListener {
            selectedTab = 1
            selectedTab(1)
        }

        myWalletTab.setOnClickListener {
            selectedTab = 2
            selectedTab(2)
        }

        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun selectedTab(tabNumber: Int) {
        if(tabNumber == 1) {
            replaceFragment(About())
            aboutTab.setTextColor(Color.parseColor("#000000"))
            myWalletTab.setTextColor(Color.parseColor("#80A6F2"))

        } else {
            replaceFragment(MyWallet())
            aboutTab.setTextColor(Color.parseColor("#A2A2A2"))
            myWalletTab.setTextColor(Color.parseColor("#80A6F2"))
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Account.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Account().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}