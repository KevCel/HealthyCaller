package net.celesoft.healthycaller

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Kevin Celejowski.
 */
class IntroPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var pFragment: ArrayList<IntroPageFragment> = ArrayList()

    init {

        //TODO: replace temporary fragments with correct contents
        pFragment.add(IntroPageFragment.newInstance("Test1", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Test2", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Test3", R.drawable.ic_bluetooth_audio))

    }

    override fun getItem(position: Int): Fragment {
        return pFragment[position]
    }

    override fun getCount(): Int {
        return pFragment.size
    }
}