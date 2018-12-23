package br.com.codeone.minhasreceitas.features.start.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import br.com.codeone.minhasreceitas.R
import br.com.codeone.minhasreceitas.commons.activity.BaseActivity
import br.com.codeone.minhasreceitas.features.login.activity.LoginActivity
import br.com.codeone.minhasreceitas.features.start.presenter.StartPresenter
import org.jetbrains.anko.startActivity

class StartActivity : BaseActivity(), StartPresenter.ViewCallback {

    private val presenter by lazy { StartPresenter(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        presenter.onViewCreate()
    }

    override fun hideActionBar() {
        supportActionBar!!.hide()
    }

    override fun showFullScreen() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun startLoginActivity() {
        startActivity<LoginActivity>()
        finish()
    }
}
