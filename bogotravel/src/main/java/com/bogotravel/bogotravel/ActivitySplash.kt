package com.bogotravel.bogotravel

    import android.content.Intent
    import android.os.Bundle
    import android.view.Window
    import androidx.appcompat.app.AppCompatActivity
    import com.bogotravel.bogotravel.main.MainActivity
    import java.util.*
    import kotlin.concurrent.timerTask

    class ActivitySplash : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.splash_background)

            val timer = Timer()
            timer.schedule(timerTask {
                goToMainActivity()
            }, 1000
            )

        }

        private fun goToMainActivity() {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }