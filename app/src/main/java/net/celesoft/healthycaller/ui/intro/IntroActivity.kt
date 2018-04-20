package net.celesoft.healthycaller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_intro.*
import net.celesoft.healthycaller.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: IntroPagerAdapter? = null
    private var binding: ActivityIntroBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        mSectionsPagerAdapter = IntroPagerAdapter(supportFragmentManager)


        viewPager.adapter = mSectionsPagerAdapter
        pagerIndicator.setViewPager(viewPager)
        mSectionsPagerAdapter!!.registerDataSetObserver(pagerIndicator.dataSetObserver)

        nextPageButton.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem + 1
            Log.d("dsd", viewPager.currentItem.toString())
        }

        previousPageButton.setOnClickListener { viewPager.currentItem = viewPager.currentItem - 1 }
    }
}
