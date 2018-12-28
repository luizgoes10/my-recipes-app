package br.com.codeone.minhasreceitas.features.login.presenter

import androidx.lifecycle.LifecycleOwner
import br.com.codeone.minhasreceitas.commons.presenter.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.TimeUnit

open class LoginPresenter(val viewCallback: LoginPresenter.ViewCallback,
                          val lifecycleOwner: LifecycleOwner = viewCallback as LifecycleOwner
): BasePresenter(lifecycleOwner) {

    interface ViewCallback{

        fun initializeAzure()
        fun insertAzure()
    }

    open fun onViewCreate(){

        Observable.timer(5000L, TimeUnit.MILLISECONDS)
            .timeInterval()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewCallback.initializeAzure()
                viewCallback.insertAzure()
            }
    }
}