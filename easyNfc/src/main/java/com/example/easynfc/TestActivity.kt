package com.example.easynfc

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity




class TestActivity : AppCompatActivity() {

    private var intentFilterArray: Array<IntentFilter>? = null
    private var pendingIntent: PendingIntent? = null

    val nfcAdapter: NfcAdapter? by lazy {
        NfcAdapter.getDefaultAdapter(this)
    }

    private var nfcLib = EzNfc( this, intentFilterArray = intentFilterArray)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nfcLib.nfcAdapter = nfcAdapter

        pendingIntent = PendingIntent.getActivity(this, 0,
            Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0)

    }
}