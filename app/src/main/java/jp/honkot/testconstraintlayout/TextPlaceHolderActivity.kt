package jp.honkot.testconstraintlayout

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.os.Build
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import jp.honkot.testconstraintlayout.databinding.ActivityTextPlaceHolderBinding

class TextPlaceHolderActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityTextPlaceHolderBinding>(this, R.layout.activity_text_place_holder)
    }

    private val viewModel = ViewModel()

    private var lastTapView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    fun onClickedClear(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val autoTransition = AutoTransition()
            autoTransition.duration = ANIMATION_DURATION
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup, autoTransition)
        }
        binding.placeHolder.setContentId(R.id.placeHolder)
        changeColor(null)
    }

    fun onClickedImage1(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val autoTransition = AutoTransition()
            autoTransition.duration = ANIMATION_DURATION
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup, autoTransition)
        }
        binding.placeHolder.setContentId(R.id.image1)
        changeColor(view as TextView)
    }

    fun onClickedImage2(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val autoTransition = AutoTransition()
            autoTransition.duration = ANIMATION_DURATION
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup, autoTransition)
        }
        binding.placeHolder.setContentId(R.id.image2)
        changeColor(view as TextView)
    }

    fun onClickedImage3(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val autoTransition = AutoTransition()
            autoTransition.duration = ANIMATION_DURATION
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup, autoTransition)
        }
        binding.placeHolder.setContentId(R.id.image3)
        changeColor(view as TextView)
    }

    fun onClickedImage4(@Suppress("UNUSED_PARAMETER") view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val autoTransition = AutoTransition()
            autoTransition.duration = ANIMATION_DURATION
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup, autoTransition)
        }
        binding.placeHolder.setContentId(R.id.image4)
        changeColor(view as TextView)
    }

    /**
     * 引数のTextViewの文字色をアクセントカラーへ変更、
     * 前にコールされたときの引数の文字色を元に戻す
     *
     * @param accentInTextView アクセントカラーを変更する対象
     */
    private fun changeColor(accentInTextView: TextView?) {
        // 引数のTextViewの色を徐々に変更する
        accentInTextView?.also { animate(it, colorIn = true) }

        // 前にこのメソッドコール時の引数であるViewの色を徐々に戻す
        lastTapView?.also { animate(it, colorIn = false) }
        lastTapView = accentInTextView
    }

    /**
     * 引数のTextViewの色を徐々に変更していく
     *
     * @param textView target text view.
     * @param colorIn true means change accent color slowly, false means opposite.
     */
    private fun animate(textView: TextView, colorIn: Boolean) {
        // Change text color slowly
        val fromColor = ResourcesCompat.getColor(resources, if (colorIn) android.R.color.black else android.R.color.holo_red_light, theme)
        val toColor = ResourcesCompat.getColor(resources, if (colorIn) android.R.color.holo_red_light else android.R.color.black, theme)
        val animatorForColor = ValueAnimator()
        animatorForColor.setIntValues(fromColor, toColor)
        animatorForColor.setEvaluator(ArgbEvaluator()) // ArgbEvaluatorをつかうことで、ARGB各値がアニメーションされる。
        animatorForColor.addUpdateListener { anim ->
            val color = anim.animatedValue as Int
            textView.setTextColor(color)
        }
        animatorForColor.duration = ANIMATION_DURATION

        // Change text size slowly
        val startSize = if (colorIn) 12f else 32f
        val endSize = if (colorIn) 32f else 12f
        val animatorForText = ValueAnimator.ofFloat(
            startSize, endSize
        )
        animatorForText.duration = 300
        animatorForText.addUpdateListener { valueAnimator ->
            val animatedValue = valueAnimator.animatedValue as Float
            textView.textSize = animatedValue
        }

        // Start animation
        animatorForColor.start()
        animatorForText.start()
    }

    companion object {
        private const val ANIMATION_DURATION = 300L
    }

    class ViewModel()
}
