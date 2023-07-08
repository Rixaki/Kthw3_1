fun main(args: Array<String>) {

    val secs: Int = 61 + 60  * 2
    println(agoToText(secs))
}

fun agoToText(secAgo: Int): String = when {
    (secAgo > 3 * 24 * 60 * 60) -> "Давно"
    (secAgo > 2 * 24 * 60 * 60) -> "Позавчера"
    (secAgo > 1 * 24 * 60 * 60) -> "Вчера"

    (secAgo > 60 * 60) -> {
        val hours = secAgo / (60 * 60)
        "Был(а) $hours ${hourCaseEnum(hours)} назад"
    }

    (secAgo > 60) -> {
        val minutes = secAgo / 60
        "Был(а) $minutes ${minCaseEnum(minutes)} назад"
    }

    else -> "Был(а) только что"
}

fun hourCaseEnum(count: Int): String = when {
    (count % 10 == 1) && (count % 100 != 11) -> "час"
    (count % 10 in 2..4) && (count % 100 < 10) -> "часа"
    else -> "часов"
}

fun minCaseEnum(count: Int): String = when {
    (count % 10 == 1) && (count % 100 != 11) -> "минуту"
    (count % 10 in 2..4) && (count % 100 < 10) -> "минуты"
    else -> "минут"
}