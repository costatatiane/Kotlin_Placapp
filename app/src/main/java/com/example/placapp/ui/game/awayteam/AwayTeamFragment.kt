package com.example.placapp.ui.game.awayteam


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.placapp.R
import com.example.placapp.ui.extensions.setupClearButtonWithAction

import com.example.placapp.ui.score.ScoreActivity
import kotlinx.android.synthetic.main.fragment_away_team.*
import kotlinx.android.synthetic.main.fragment_away_team.btNextStep
import kotlinx.android.synthetic.main.fragment_event.*
import kotlinx.android.synthetic.main.fragment_home_team.*

class AwayTeamFragment : Fragment() {

    // outra forma de enviar infos ao invés de broadcast do sistema, comunicação ocorre entre as duas classes
    interface AwayTeamSelectedListener {
        fun onAwayTeam(awayName: String)
    }

    private var listener: AwayTeamSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AwayTeamSelectedListener) {
            listener = context
        }
    }

    companion object {

        //  cria uma instância dentro da própria classe depois de ela ser iniciada e retorna já com a mudança
        fun newInstance (homeTeam: String) : AwayTeamFragment {
            val args = Bundle()
            args.putSerializable("homeTeam", homeTeam)
            val fragment = AwayTeamFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_away_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputAwayTeam.setupClearButtonWithAction()
        btNextStep.setOnClickListener {
            sendAwayTeamName()
        }
    }
    private fun sendAwayTeamName() {
//        val intent = Intent("FILTER_AWAY_TEAM")
//        intent.putExtra("away_team", inputAwayTeam.text.toString())
//        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        listener?.onAwayTeam(inputAwayTeam.text.toString())
    }

}
