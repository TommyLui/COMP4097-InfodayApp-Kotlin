package edu.hkbu.comp.comp4097.infoday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.hkbu.comp.comp4097.infoday.ui.signup.SignupFragment

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment.newInstance())
                .commitNow()
        }
    }
}