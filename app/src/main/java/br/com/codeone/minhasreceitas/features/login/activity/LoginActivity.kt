package br.com.codeone.minhasreceitas.features.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.codeone.minhasreceitas.R
import br.com.codeone.minhasreceitas.commons.activity.BaseActivity
import br.com.codeone.minhasreceitas.features.login.presenter.LoginPresenter
import br.com.codeone.minhasreceitas.services.azure.AzureMobileServiceClient
import br.com.codeone.minhasreceitas.services.azure.TodoItem
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback

class LoginActivity : BaseActivity(), LoginPresenter.ViewCallback {

    private val presenter by lazy { LoginPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onViewCreate()
    }

    override fun initializeAzure() {
        AzureMobileServiceClient.Initialize(this)
    }

    override fun insertAzure() {
        var todoItem:TodoItem = TodoItem()
        todoItem.text = "Luiz"
        todoItem.complete = false
        var mInstance = AzureMobileServiceClient.instance
        var client = mInstance.client
        client.getTable(TodoItem::class.java).insert(todoItem).get()
    }
}
