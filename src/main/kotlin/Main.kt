package ru.netology

import java.math.RoundingMode

fun main() {

    var sum = 100_000_00.00 // Сумма стоимости за товар в копейках
    val vip = true
    val discount = 5.00
    val discountVip = 1.00
    var discountResult = 0.00
    var discountVipResult = 0.00

    if (sum >= 1_000_00.00 && sum <= 10_000_00.00) {
        discountResult = 100_00.00
    } else {
        if (sum >= 10_001_00.00) discountResult = sum / 100 * discount
    }
    if (vip) discountVipResult = (sum - discountResult) / 100 * discountVip

    var amountToPaid: Double = sum - discountResult - discountVipResult

    //Переведём суммы из копеек в рубли
    sum = (sum / 100).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
    amountToPaid = (amountToPaid / 100).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
    discountResult = (discountResult / 100).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
    discountVipResult = (discountVipResult / 100).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()

    println(
        """
        Сумма                         - $sum руб.
        Скидка                        - $discountResult руб.
        Скидка постоянному покупателю - $discountVipResult руб.
        К оплате                      - $amountToPaid руб.
    """.trimIndent()
    )

}