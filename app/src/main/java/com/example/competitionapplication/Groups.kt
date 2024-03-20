package com.example.competitionapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.FragmentManager
import com.google.android.material.imageview.ShapeableImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Groups.newInstance] factory method to
 * create an instance of this fragment.
 */
class Groups : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var profilePictureSIV: ShapeableImageView
    private lateinit var notificationsBellIB: ImageButton
    private lateinit var addGroup: LinearLayout

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
        val view = inflater.inflate(R.layout.fragment_groups, container, false)

        profilePictureSIV = view.findViewById(R.id.ProfilePictureSIV)
        profilePictureSIV.setOnClickListener {
            val fragmentToLaunch = Account()

            // Get the FragmentManager
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

            // Begin a transaction to replace the current fragment with the new one
            fragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, fragmentToLaunch)
                .addToBackStack(null) // Optional: Add to back stack for navigation
                .commit()
        }

        notificationsBellIB = view.findViewById(R.id.NotificationsBellIB)
        notificationsBellIB.setOnClickListener {
            val fragmentToLaunch = History()

            // Get the FragmentManager
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

            // Begin a transaction to replace the current fragment with the new one
            fragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, fragmentToLaunch)
                .addToBackStack(null) // Optional: Add to back stack for navigation
                .commit()
        }

        addGroup = view.findViewById(R.id.AddGroup)
        addGroup.setOnClickListener {
            val addGroupExpenseIntent = Intent(requireContext(), AddGroupExpense::class.java)
            startActivity(addGroupExpenseIntent)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Groups.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Groups().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}