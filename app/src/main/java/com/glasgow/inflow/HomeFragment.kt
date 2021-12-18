package com.glasgow.inflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.glasgow.inflow.adapter.GameAdapter
import com.glasgow.inflow.model.listGame
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var gameAdapter: GameAdapter
    val lm = LinearLayoutManager(activity)
    val addGameList: MutableList<listGame> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    fun initView(){
        rv_game.layoutManager = lm
        gameAdapter = GameAdapter(requireActivity())
        rv_game.adapter = gameAdapter

        addGameList.add(listGame("Ahmad M", "Mario Bros 2.0", "Ini deskripsi 1", "0"))
        addGameList.add(listGame("Alafta A", "DOTA NIHHH", "DOTA 2 reborn", "1"))
        addGameList.add(listGame("Riko B", "PUBG GENGS", "Review final PUBG", "2"))
        addGameList.add(listGame("Adam A", "10 Game Berbahaya", "Apa saja game yang tidak baik bagi pengguna", "3"))
        addGameList.add(listGame("Alafta A", "DOTA NIHHH", "DOTA 2 reborn", "4"))
        addGameList.add(listGame("Riko B", "PUBG GENGS", "Review final PUBG", "5"))

        gameAdapter.setGame(addGameList)
    }

}