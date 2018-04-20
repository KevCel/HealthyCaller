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
        pFragment.add(IntroPageFragment.newInstance("Lol", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Yesyt2", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Lol", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Yesyt2", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Lol", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Yesyt2", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Lol", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Yesyt2", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Lol", R.drawable.ic_bluetooth_audio))
        pFragment.add(IntroPageFragment.newInstance("Yesyt2", R.drawable.ic_bluetooth_audio))

    }

    override fun getItem(position: Int): Fragment {
        return pFragment[position]
    }

    override fun getCount(): Int {
        return pFragment.size
    }

    public fun nextStep() {

    }
}