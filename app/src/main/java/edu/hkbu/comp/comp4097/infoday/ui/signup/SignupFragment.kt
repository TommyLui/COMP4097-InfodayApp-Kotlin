package edu.hkbu.comp.comp4097.infoday.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.hkbu.comp.comp4097.infoday.R

class SignupFragment : Fragment() {

    companion object {
        fun newInstance() = SignupFragment()
    }

    private lateinit var viewModel: SignupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.signup_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignupViewModel::class.java)
        // TODO: Use the ViewModel
    }

}