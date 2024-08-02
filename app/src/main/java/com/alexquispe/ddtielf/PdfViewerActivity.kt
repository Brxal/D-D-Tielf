package com.alexquispe.ddtielf

import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class PdfViewerActivity : AppCompatActivity() {

    private lateinit var pdfWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        pdfWebView = findViewById(R.id.pdfWebView)

        // Configura el WebView
        val webSettings = pdfWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true

        pdfWebView.webViewClient = WebViewClient()

        // URL del PDF
        val pdfUrl = intent.getStringExtra("pdfUrl") ?: ""
        Log.d("PdfViewerActivity", "Loading PDF URL: $pdfUrl")
        pdfWebView.loadUrl("https://docs.google.com/gview?embedded=true&url=$pdfUrl")
    }
}
