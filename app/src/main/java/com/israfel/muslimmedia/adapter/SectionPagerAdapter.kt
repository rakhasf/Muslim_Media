package com.israfel.muslimmedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.israfel.muslimmedia.fragments.AboutAlQuranFragment
import com.israfel.muslimmedia.fragments.AlJazeeraFragment
import com.israfel.muslimmedia.fragments.CommonFragment
import com.israfel.muslimmedia.fragments.WarningFragment

// SectionPagerAdapter inheritance FragmentStateAdapter to override instance of adapter
// this class will be used for set Fragment in ViewPager2
class SectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    // getItemCount set mount of fragment which will be display in your adapter
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        // set arrange of fragment position from left to right
        return when (position)  {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarningFragment()
            else -> CommonFragment()
        }
    }
}