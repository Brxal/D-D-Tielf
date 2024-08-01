package com.alexquispe.ddtielf

import android.os.Bundle
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

        pdfWebView.webViewClient = WebViewClient()

        // URL del PDF
        val pdfUrl = intent.getStringExtra("pdfUrl") ?: ""
        pdfWebView.loadUrl("https://docs.google.com/gview?embedded=true&url=$pdfUrl")
    }
}
