package com.rangga.resepku

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailResep : AppCompatActivity() {
    companion object {
        const val Resep = "resep"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_resep)
        val imageObj:ImageView = findViewById(R.id.img_item_detail)
        val titleObj:TextView = findViewById(R.id.tv_item_judul)
        val descObj:TextView = findViewById(R.id.tv_item_deskripsi)
        val descObj2:TextView = findViewById(R.id.tv_item_deskripsi2)
        val btnBahan:Button = findViewById(R.id.bahan)
        val btnMasak:Button = findViewById(R.id.masak)


        val data: String = "bahan"

        val resep = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(Resep, Hero::class.java)
        } else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(Resep)
        }

        if(resep != null){
            Glide.with(applicationContext)
                .load(resep.photo) // URL Gambar
                .into(imageObj)
            titleObj.text = resep.name
            descObj.text = resep.description
            descObj2.text = resep.bahan
        }
        btnBahan.setOnClickListener(){
            descObj2.text = resep?.bahan
        }

        btnMasak.setOnClickListener(){
            descObj2.text = resep?.masak
        }



        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Detail"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}