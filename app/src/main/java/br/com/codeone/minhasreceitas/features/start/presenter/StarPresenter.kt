package br.com.codeone.minhasreceitas.features.start.presenter

import androidx.lifecycle.LifecycleOwner
import br.com.codeone.minhasreceitas.commons.presenter.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

open class StartPresenter(val viewCallback: StartPresenter.ViewCallback,
                         val lifecycleOwner: LifecycleOwner = viewCallback as LifecycleOwner):
    BasePresenter(lifecycleOwner) {

    interface ViewCallback{

        fun hideActionBar()

        fun showFullScreen()

        fun startLoginActivity()

    }

    open fun onViewCreate(){
        viewCallback.hideActionBar()
        viewCallback.showFullScreen()
        Observable.timer(5000L, TimeUnit.MILLISECONDS)
            .timeInterval()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                viewCallback.startLoginActivity()
            }
    }
}