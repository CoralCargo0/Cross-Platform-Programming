package com.example.lab

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class ClashController {

    @GetMapping("/calculate")
    fun calculate(
        model: Model,
        @RequestParam(value = "weightOfFirst", defaultValue = "0.0") weightOfFirst: String,
        @RequestParam(value = "speedOfFirst", defaultValue = "0.0") speedOfFirst: String,
        @RequestParam(value = "weightOfSecond", defaultValue = "0.0") weightOfSecond: String,
        @RequestParam(value = "speedOfSecond", defaultValue = "0.0") speedOfSecond: String
    ): String {
        val clash: InelasticClashOfTwo
        try {
            clash = InelasticClashOfTwo(
                weightOfFirst.toDouble(),
                speedOfFirst.toDouble(),
                weightOfSecond.toDouble(),
                speedOfSecond.toDouble()
            )
        } catch (e: Throwable) {
            return init(model)
        }
        model.apply {
            addAttribute("weightOfFirst", weightOfFirst)
            addAttribute("speedOfFirst", speedOfFirst)
            addAttribute("weightOfSecond", weightOfSecond)
            addAttribute("speedOfSecond", speedOfSecond)
            addAttribute("result", clash.calculateSpeedAfterClash())

        }
        return "clashOfTwo"
    }

    @GetMapping(value = ["/"])
    fun init(model: Model): String {
        model.addAttribute("result", "")
        return "clashOfTwo"
    }
}