package br.com.codeone.minhasreceitas.application

import android.app.Application
import android.util.Log

class MinhasReceitasApplication : Application() {

    // Chamado quando o Android criar o processo do aplicativo
    override fun onCreate() {
        super.onCreate()
// Salva a instância para termos acesso como Singleton
        appInstance = this
    }

    companion object {
        private const val TAG = "MinhasReceitasApp"

        // Singleton da classe Application
        lateinit var appInstance: MinhasReceitasApplication
            private set

        fun getInstance(): MinhasReceitasApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance
        }

    }

    // Chamado quando o Android finalizar o processo do aplicativo
    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "MinhasReceitasApplication.onTerminate()")
    }
}