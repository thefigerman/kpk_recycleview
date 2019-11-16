package id.co.plnntb.kpkrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.plnntb.kpkrecycleview.model.Pelanggan
import id.co.plnntb.kpkrecycleview.adapter.PelangganAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.alamat
import kotlinx.android.synthetic.main.activity_main.idpel
import kotlinx.android.synthetic.main.activity_main.nama
import kotlinx.android.synthetic.main.item_pelanggan.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class MainActivity : AppCompatActivity() {

    // buat variabel untuk menampung data pelanggan
    var listPlg = mutableListOf<Pelanggan>()
    val adapterPlg = PelangganAdapter(listPlg)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTampilan()

        // masukkan data pelanggan ke Recycler View
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterPlg
        }
    }

    fun initTampilan() {
        btnsimpan.setOnClickListener {
            database.use {
                insert(
                    "pelanggan",
                    "idpel" to idpel.text.toString(),
                    "nama" to nama.text.toString(),
                    "alamat" to alamat.text.toString(),
                    "tarif" to tarif.text.toString(),
                    "daya" to daya.text.toString()
                )
                listPlg.add(
                    Pelanggan(
                        idpel.text.toString(),
                        nama.text.toString(),
                        alamat.text.toString(),
                        tarif.text.toString(),
                        daya.text.toString()
                    )
                )

            }
            adapterPlg.notifyDataSetChanged()
        }


    }

    override fun onResume() {
        bacaDatabase()
        super.onResume()
    }

    fun bacaDatabase() {
        database.use {
            select("pelanggan").exec {
                while (this.moveToNext()) {
                    listPlg.add(
                        Pelanggan(
                            getString(getColumnIndex("idpel")),
                            getString(getColumnIndex("nama")),
                            getString(getColumnIndex("alamat")),
                            getString(getColumnIndex("tarif")),
                            getString(getColumnIndex("daya"))
                        )
                    )
                }
                adapterPlg.notifyDataSetChanged()
            }
        }
    }
}
