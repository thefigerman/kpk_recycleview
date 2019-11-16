package id.co.plnntb.kpkrecycleview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.plnntb.kpkrecycleview.model.Pelanggan
import id.co.plnntb.kpkrecycleview.viewholder.PelangganViewHolder

class PelangganAdapter (val list: List<Pelanggan>):
    RecyclerView.Adapter<PelangganViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PelangganViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PelangganViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PelangganViewHolder, position: Int) {
        val data : Pelanggan = list[position]
        holder.bind(data)
    }
}