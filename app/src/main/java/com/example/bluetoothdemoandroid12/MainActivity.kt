package com.example.bluetoothdemoandroid12

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var btnEarPiece: Button? = null
    var btnSpeaker: Button? = null
    var btnPlay: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        //playMusic()
    }

    private fun playMusic() {
        AudioTogglePlugin().setAudioMode("normal", this)
        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.ruladeti)
        mediaPlayer?.start()
    }

    fun stopMusic() {
        mediaPlayer?.stop()
    }

    fun clickListener() {
        btnEarPiece?.setOnClickListener {
            AudioTogglePlugin().setAudioMode("earpiece", this)
        }

        btnSpeaker?.setOnClickListener {
            AudioTogglePlugin().setAudioMode("speaker", this)
        }

        btnPlay?.setOnClickListener {
            playMusic()
        }
    }

    private fun init() {
        btnEarPiece = findViewById(R.id.btnEarPiece)
        btnSpeaker = findViewById(R.id.btnSpeaker)
        btnPlay = findViewById(R.id.btnPlay)
        clickListener()
    }
}

