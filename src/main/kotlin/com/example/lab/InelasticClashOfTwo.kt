package com.example.lab

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class InelasticClashOfTwo(
    private val weightOfFirst: Double,
    private val speedOfFirst: Double,
    private val weightOfSecond: Double,
    private val speedOfSecond: Double
) {
    fun calculateSpeedAfterClash(): String {
        val speedAfterClash: Double = if (isHeadOnClash()) {
            sqrt(
                abs(
                    weightOfFirst * speedOfFirst.pow(2.0) - weightOfSecond * speedOfSecond.pow(2.0)
                ) / (weightOfFirst + weightOfSecond)
            )
        } else {
            sqrt(
                abs(
                    weightOfFirst * speedOfFirst.pow(2.0) + weightOfSecond * speedOfSecond.pow(2.0)
                ) / (weightOfFirst + weightOfSecond)
            )
        }
        return if (speedAfterClash.isNaN()) "0" else String.format("%.3f", speedAfterClash)
    }

    private fun isHeadOnClash(): Boolean = !(speedOfFirst > 0 && speedOfSecond > 0)
}