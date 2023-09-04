package com.rangga.resepku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val img: ImageView = findViewById(R.id.img_item_profile_photo)
        Glide.with(applicationContext)
            .load(R.drawable.profile).centerCrop().transform(RoundedCorners(200)).into(img)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Profile"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}