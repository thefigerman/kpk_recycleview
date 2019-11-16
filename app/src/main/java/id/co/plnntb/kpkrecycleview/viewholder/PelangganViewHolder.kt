package id.co.plnntb.kpkrecycleview.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.co.plnntb.kpkrecycleview.R
import id.co.plnntb.kpkrecycleview.model.Pelanggan
import kotlinx.android.synthetic.main.item_pelanggan.view.*

class PelangganViewHolder (inflater: LayoutInflater,parent:ViewGroup):
    RecyclerView.ViewHolder(
        inflater.inflate(R.layout.item_pelanggan, parent, false)
    )

{

    //deklarasi variabel untuk memegang komponen yang ada pada layout
    var idpel: TextView? = null
    var nama: TextView? = null
    var alamat: TextView? = null
    var trfdya: TextView? = null

    // ambil komponen dari layout, masukkan ke variabel

    init {
        idpel = itemView.findViewById(R.id.idpel)
        nama = itemView.findViewById(R.id.nama)
        alamat = itemView.findViewById(R.id.alamat)
        trfdya = itemView.findViewById(R.id.trfdya)
    }

    //binding data pelanggan ke komponen (yang sudah dimasukkan variabel)

    fun bind(data: Pelanggan){
        idpel?.text = data.idpel
        nama?.text = data.nama
        alamat?.text = data.alamat
        trfdya?.text = "${data.tarif} / ${data.daya}VA"

    }

}