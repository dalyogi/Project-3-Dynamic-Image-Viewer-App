package com.example.project3dynamicimageviewerapp

import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ViewFlipper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val imageList: ArrayList<Int> = arrayListOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize ViewFlipper and set animation
        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        val inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)

        viewFlipper.inAnimation = inAnimation
        viewFlipper.outAnimation = outAnimation

        // Add images to ViewFlipper
        for (image in imageList) {
            val imageView = ImageView(this)
            imageView.setImageResource(image)
            imageView.layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
            )
            viewFlipper.addView(imageView)
        }

        // Set button actions
        val previousBtn = findViewById<Button>(R.id.previousBtn)
        previousBtn.setOnClickListener {
            viewFlipper.showPrevious()
        }

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            viewFlipper.showNext()
        }

        // "Go to Dashboard" button: Show img1 when clicked
        val dashboardBtn = findViewById<Button>(R.id.dashboardBtn)
        dashboardBtn.setOnClickListener {
            // Set the ViewFlipper to show the first image (img1)
            viewFlipper.displayedChild = 0
        }

        // Change button background color programmatically
        // Previous Button background color
        previousBtn.setBackgroundColor(Color.parseColor("#FF5733")) // Red background
        previousBtn.setTextColor(Color.WHITE) // Optional: Set text color to white

        // Next Button background color
        nextBtn.setBackgroundColor(Color.parseColor("#2D6A4F")) // Green background
        nextBtn.setTextColor(Color.WHITE)
    }
}
