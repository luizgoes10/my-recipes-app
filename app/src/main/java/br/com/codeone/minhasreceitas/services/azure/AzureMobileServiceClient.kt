package br.com.codeone.minhasreceitas.services.azure


import android.content.Context
import com.microsoft.windowsazure.mobileservices.*
import java.lang.IllegalStateException


open class AzureMobileServiceClient private constructor(private val mContext: Context) {
    private val mMobileBackendUrl = "https://mobile-recipes-app.azurewebsites.net"
    val client: MobileServiceClient

    init {
        client = MobileServiceClient(mMobileBackendUrl, mContext)
    }

    companion object {
        private var mInstance: AzureMobileServiceClient? = null

        fun Initialize(context: Context) {
            if (mInstance == null) {
                mInstance = AzureMobileServiceClient(context)
            } else {
                throw IllegalStateException("AzureServiceAdapter is already initialized")
            }
        }

        val instance: AzureMobileServiceClient
            get() {
                if (mInstance == null) {
                    throw IllegalStateException("AzureServiceAdapter is not initialized")
                }
                return mInstance as AzureMobileServiceClient
            }
    }

    // Place any public methods that operate on mClient here.
}

