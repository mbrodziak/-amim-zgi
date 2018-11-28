package org.akop.ararat.widget

import android.content.Context
import android.os.SystemClock
import android.view.animation.DecelerateInterpolator


/**
 * A simple class that animates double-touch zoom gestures. Functionally similar to a [ ].
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class Zoomer(context: Context) {
    /**
     * The interpolator, used for making zooms animate 'naturally.'
     */
    private val interpolator = DecelerateInterpolator()

    /**
     * The total animation duration for a zoom.
     */
    private val animationDurationMillis: Int = context.resources.getInteger(
            android.R.integer.config_shortAnimTime)

    /**
     * Returns whether the zoomer has finished zooming.
     *
     * @return True if the zoomer has finished zooming, false otherwise.
     */
    var isFinished = true
        private set

    /**
     * The current zoom value; computed by [.computeZoom].
     *
     * @see android.widget.Scroller.getCurrX
     */
    var currZoom: Float = 0f
        private set

    /**
     * The time the zoom started, computed using [SystemClock.elapsedRealtime].
     */
    private var startRTC: Long = 0

    /**
     * The destination zoom factor.
     */
    private var endZoom: Float = 0f

    /**
     * Forces the zoom finished state to the given value. Unlike [.abortAnimation], the
     * current zoom value isn't set to the ending value.
     *
     * @see android.widget.Scroller.forceFinished
     */
    fun forceFinished(finished: Boolean) {
        isFinished = finished
    }

    /**
     * Aborts the animation, setting the current zoom value to the ending value.
     *
     * @see android.widget.Scroller.abortAnimation
     */
    fun abortAnimation() {
        isFinished = true
        currZoom = endZoom
    }

    /**
     * Starts a zoom from 1.0 to (1.0 + endZoom). That is, to zoom from 100% to 125%, endZoom should
     * by 0.25f.
     *
     * @see android.widget.Scroller.startScroll
     */
    fun startZoom(endZoom: Float) {
        startRTC = SystemClock.elapsedRealtime()
        this.endZoom = endZoom

        isFinished = false
        currZoom = 1f
    }

    /**
     * Computes the current zoom level, returning true if the zoom is still active and false if the
     * zoom has finished.
     *
     * @see android.widget.Scroller.computeScrollOffset
     */
    fun computeZoom(): Boolean {
        if (isFinished) {
            return false
        }

        val tRTC = SystemClock.elapsedRealtime() - startRTC
        if (tRTC >= animationDurationMillis) {
            isFinished = true
            currZoom = endZoom
            return false
        }

        val t = tRTC * 1f / animationDurationMillis
        currZoom = endZoom * interpolator.getInterpolation(t)
        return true
    }
}