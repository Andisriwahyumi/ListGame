package com.example.kelompok4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GameAdapter constructor(private val context: Context) : BaseAdapter(){

    internal var game = arrayListOf<Game>()
    override fun getCount(): Int = game.size

    override fun getItem(i: Int): Any = game[i]

    override fun getItemId(i: Int): Long = i.toLong()
    override fun getView(position: Int, v: View?, viewGroup: ViewGroup): View {
        var itemView = v
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_game, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val _game = getItem(position) as Game
        viewHolder.bind(_game)
        return itemView
    }
    private inner class ViewHolder constructor(view: View) {
        private val tvNama: TextView = view.findViewById(R.id.tv_nama)
        private val tvDeskripsi: TextView = view.findViewById(R.id.tv_deskripsi)
        private val imgFoto: ImageView = view.findViewById(R.id.img_item_photo)
        fun bind(game : Game) {
            tvNama.text = game.nama
            tvDeskripsi.text = game.deskripsi
            imgFoto.setImageResource(game.foto)
        }
    }
}