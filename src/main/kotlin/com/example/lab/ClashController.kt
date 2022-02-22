package com.example.lab

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ClashController {

    @GetMapping(value = ["/calculate"])
    fun calculate(
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
            return init()
        }

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<form action=\"http://localhost:8080/calculate\">\n" +
                "  <label for=\"weightOfFirst\">Масса 1</label>\n" +
                "  <br>\n" +
                "  <input type=\"text\" id=\"weightOfFirst\" name=\"weightOfFirst\" value = \"$weightOfFirst\">\n" +
                "  <br>\n" +
                "  <label for=\"speedOfFirst\">Скорость 1</label>\n" +
                "  <br>\n" +
                "  <input type=\"text\" id=\"speedOfFirst\" name=\"speedOfFirst\" value = \"$speedOfFirst\">\n" +
                "  <br>\n" +
                "  <label for=\"weightOfSecond\">Масса 2</label>\n" +
                "  <br>\n" +
                "  <input type=\"text\" id=\"weightOfSecond\" name=\"weightOfSecond\" value = \"$weightOfSecond\">\n" +
                "  <br>\n" +
                "  <label for=\"speedOfSecond\">Скорость 2</label>\n" +
                "  <br>\n" +
                "  <input type=\"text\" id=\"speedOfSecond\" name=\"speedOfSecond\" value = \"$speedOfSecond\">\n" +
                "  <br>\n" +
                "  <br>\n" +
                "  <label for=\"speedAfterClash\">Скорость после столкновения = ${clash.calculateSpeedAfterClash()}</label>\n" +
                "  <br>\n" +
                "  <br>\n" +
                "  <input type=\"submit\" value=\"Посчитать\"> </form>\n" +
                "</body>\n" +
                "\n" +
                "</html>"
    }

    @GetMapping(value = ["/"])
    fun init(): String {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<form action=\"http://localhost:8080/calculate\">\n" +
                "  <label for=\"weightOfFirst\">Масса 1</label>\n" +
                "  <br>\n" +
                "  <input type=\"text\" id=\"weightOfFirst\" name=\"weightOfFirst\">\n" +
                "  <br>\n" +
                "  <label for=\"speedOfFirst\">Скорость 1</label>\n" +
                "  <br>\n" +
                "  <input type=\"text\" id=\"speedOfFirst\" name=\"speedOfFirst\">\n" +
                "  <br>\n" +
                "  <label for=\"weightOfSecond\">Масса 2</label>\n" +
                "  <br>\n" +
                "  <input type=\"text\" id=\"weightOfSecond\" name=\"weightOfSecond\">\n" +
                "  <br>\n" +
                "  <label for=\"speedOfSecond\">Скорость 2</label>\n" +
                "  <br>\n" +
                "  <input type=\"text\" id=\"speedOfSecond\" name=\"speedOfSecond\">\n" +
                "  <br>\n" +
                "  <br>\n" +
                "  <label for=\"speedAfterClash\">Скорость после столкновения</label>\n" +
                "  <br>\n" +
                "  <br>\n" +
                "  <input type=\"submit\" value=\"Посчитать\"> </form>\n" +
                "</body>\n" +
                "\n" +
                "</html>"
    }
}