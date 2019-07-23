package jp.honkot.testconstraintlayout

import android.os.Build
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jp.honkot.testconstraintlayout.databinding.ActivityImagePlaceHolderBinding

class ImagePlaceHolderActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityImagePlaceHolderBinding>(this, R.layout.activity_image_place_holder)
    }

    private val viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    fun onClickedClear(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
        }
        binding.placeHolder.setContentId(R.id.placeHolder)
    }

    fun onClickedImage1(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
        }
        binding.placeHolder.setContentId(R.id.image1)
    }

    fun onClickedImage2(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
        }
        binding.placeHolder.setContentId(R.id.image2)
    }

    fun onClickedImage3(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
        }
        binding.placeHolder.setContentId(R.id.image3)
    }

    fun onClickedImage4(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
        }
        binding.placeHolder.setContentId(R.id.image4)
    }

    class ViewModel()
}
