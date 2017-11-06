package com.example.joaopedrosilva.projectkotlin.di

import com.example.joaopedrosilva.projectkotlin.ProjectKotlinApplication
import dagger.Component

/**
 * Created by joaopedrosilva on 30/10/17.
 */
@AppScope
@Component(modules = arrayOf(AppModule::class,
        ActBindModule::class))
interface AppComponent {
    fun inject(application: ProjectKotlinApplication)

    companion object {
        fun build(app: ProjectKotlinApplication) {
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build().apply { inject(app) }

//            app.registerActivityLifecycleCallbacks(MyLifeCycle())
        }
    }

    /*private class MyLifeCycle : Application.ActivityLifecycleCallbacks {

        private val actHash: HashMap<Int, FragmentManager.FragmentLifecycleCallbacks> = hashMapOf()

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            if (activity is HasSupportFragmentInjector) {
                AndroidInjection.inject(activity)
//                Timber.i("AndroidInjection: size: ${actHash.size}")
            } else {
                return
            }

            if (activity is FragmentActivity) {
                val cb = object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(fm: FragmentManager, f: Fragment, sis: Bundle?) {
//                        if (f is InjectableAsync) {
//                            // we don't auto inject here. This one is a async injector, must
//                            // be done on the class itself
//                        }else if(f is Injectable){
                        AndroidSupportInjection.inject(f)
//                            Timber.i("AndroidSupportInjection: size: ${actHash.size}, frag: ${f::class}")
//                        }
                    }

                    override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                        super.onFragmentViewDestroyed(fm, f)
//                        Timber.i("Fragment: ${f::class.java} onViewDestroyed called")
                    }
                }
                actHash.put(activity.hashCode(), cb)
                activity.supportFragmentManager.registerFragmentLifecycleCallbacks(cb, true)
//                Timber.i("registerFragmentLifecycleCallbacks: size: ${actHash.size}, act: ${activity::class}")
            }
        }

        override fun onActivityPaused(activity: Activity) {}
        override fun onActivityResumed(activity: Activity) {}
        override fun onActivityStarted(activity: Activity) {}
        override fun onActivityDestroyed(activity: Activity) {
            if (activity is HasSupportFragmentInjector && activity is FragmentActivity) {
                val key = activity.hashCode()
                val cb = actHash[key]
                if (cb != null) {
                    activity.supportFragmentManager.unregisterFragmentLifecycleCallbacks(cb)
                    actHash.remove(key)
//                    Timber.i("unregisterFragmentLifecycleCallbacks: size: ${actHash.size}, act: ${activity::class}")
                }
            }
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {}
        override fun onActivityStopped(activity: Activity) {}
    }*/
}