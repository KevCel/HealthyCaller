package net.celesoft.healthycaller

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_intro.*
import kotlinx.android.synthetic.main.fragment_intro.view.*

/**
 * Created by Kevin Celejowski.
 */

class IntroPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_intro, container, false)

        rootView.introLabel.text = arguments?.getString(TITLE) ?: "empty"
        rootView.introIcon.setImageResource(arguments.getInt(IMAGE) ?: R.drawable.ic_bluetooth_audio)

        return rootView
    }

    companion object {

        private val TITLE = "section_number"
        private val IMAGE = "intro_icon"

        fun newInstance(title: String, iconId: Int): IntroPageFragment {
            val fragment = IntroPageFragment()
            val args = Bundle()
            args.putString(TITLE, title)
            args.putInt(IMAGE, iconId)
            fragment.arguments = args
            return fragment
        }
    }
}