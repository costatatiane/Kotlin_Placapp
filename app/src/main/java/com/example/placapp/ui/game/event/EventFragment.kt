package com.example.placapp.ui.game.event


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.example.placapp.R
import com.example.placapp.ui.extensions.setupClearButtonWithAction
import com.example.placapp.ui.game.hometeam.HomeTeamFragment
import kotlinx.android.synthetic.main.fragment_away_team.*
import kotlinx.android.synthetic.main.fragment_event.*
import kotlinx.android.synthetic.main.fragment_event.btNextStep

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class EventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputEvent.setupClearButtonWithAction()
        btNextStep.setOnClickListener {
            sendHomeTeamName()        }
    }

    private fun sendHomeTeamName() {
        val intent = Intent("FILTER_EVENT")
        intent.putExtra("event_name", inputEvent.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }
}
