package com.ragabz.openlibrary.ui

import androidx.activity.viewModels
import com.ragabz.core.base.BaseVBActivity
import com.ragabz.core.extensions.hide
import com.ragabz.core.extensions.observe
import com.ragabz.core.extensions.show
import com.ragabz.core.utils.NetworkUtils
import com.ragabz.openlibrary.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseVBActivity<ActivityMainBinding, MainViewModel>(
    ActivityMainBinding::inflate
) {
    override val viewModel: MainViewModel by viewModels()
    val networkViewModel: NetworkViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        handleNetworkChanges()
    }

    private fun handleNetworkChanges() {
        observe(NetworkUtils.getNetworkLiveData(applicationContext)) { isConnected ->
            when (isConnected) {
                true -> {
                    binding.noConnectionLayout.hide()
                    networkViewModel.changeToConnected()
                }
                false -> {
                    binding.noConnectionLayout.show()
                    networkViewModel.changeToNotConnected()
                }
            }
        }
    }
}
