package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)

        // two ways to add an on click listener for a navigation action (second is preferred)
//        binding.playButton.setOnClickListener { view: View ->
//            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
//        }

        // this is the preferred way if we are not using the safeargs gradle plugin
//        binding.playButton.setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))

        // but if we are using the safeargs gradle plugin, this is the way to do it, since we must use an anonymous function
        binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }


        // set that we have an options menu available
        setHasOptionsMenu(true)
        return binding.root
    }

    // inflate the menu resource when the menu is created by overriding the default
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    // need to override to allow the nav controller to navigate where we want when the menu option is selected
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
                view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
