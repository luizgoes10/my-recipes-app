package br.com.codeone.minhasreceitas.commons.activity

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {
    protected val context: Context get() = this
}
