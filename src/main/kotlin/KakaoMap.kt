import csstype.px
import emotion.react.css
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.*
import react.*
import react.dom.html.ReactHTML.div
import kotlin.js.Json
import kotlin.js.json

//val kakao = window["kakao"]

val KMap = FC<Props> {
    div {
        id = "map"
        css {
            width = 1000.px
            height = 800.px
        }
    }
    useEffect {
        val container = document.getElementById("map")
        val options = json(
            Pair("center", kakao.maps.LatLng(37.365264512305174, 127.10676860117488)),
            Pair("level", 3)
        )

        kakao.maps.Map(container, options)
    }
}

external object kakao {
    object maps {
        class LatLng constructor(a: Double, b: Double)
        class Map constructor(container: Element?, options: Json)
    }
}