package com.example.nfctictac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var buttonNfc: Button
    private lateinit var buttonRead: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonNfc = findViewById(R.id.nfc_button)
        buttonRead = findViewById(R.id.nfc_button_read)


        buttonNfc.setOnClickListener {
            val intent = Intent(this, NfcWriteActivity::class.java)
            startActivity(intent)
        }
        buttonRead.setOnClickListener {
            val intent = Intent(this, NfcReadActivity::class.java)
            startActivity(intent)
        }
    }
}