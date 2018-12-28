package br.com.codeone.minhasreceitas.services.azure

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

 class TodoItem {
     var id:String = ""
     var text:String = ""
     var complete:Boolean = true
}