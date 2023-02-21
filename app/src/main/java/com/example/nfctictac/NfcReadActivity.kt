package com.example.nfctictac

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.easynfc.EzNfc

class NfcReadActivity : AppCompatActivity() {

    private var intentFilterArray: Array<IntentFilter>? = null
    private var pendingIntent: PendingIntent? = null

    private lateinit var textView : TextView

    private val nfcAdapter: NfcAdapter? by lazy {
        NfcAdapter.getDefaultAdapter(this)
    }

    private var nfcLib = EzNfc( this, intentFilterArray = intentFilterArray)
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nfc_read_activity)
        textView = findViewById(R.id.txtviewmachineid)

        nfcLib.nfcAdapter = nfcAdapter

        pendingIntent = PendingIntent.getActivity(this, 0,
            Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0)

            intentFilterArray = nfcLib.onCreateFilter()
    }
        override fun onResume(){
            super.onResume()


          //  EzNfc(intent, this, NfcAdapter.getDefaultAdapter(this), intentFilterArray).onResumeRead(pendingIntent)
            nfcLib.onResumeRead(pendingIntent)
        }

    override fun onNewIntent(intent: Intent){
        super.onNewIntent(intent)

        //nfcLib.intent = intent
        //nfcLib.newIntent(intent)

       // textView.text =    EzNfc(intent, this).builderRead()


          textView.text =  nfcLib.read(intent)

    }

    override fun onPause() {
      // EzNfc(intent, this).onPause()
       nfcLib.onPause()
        super.onPause()

    }

}