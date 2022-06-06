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
            Pair("center", kakao.maps.LatLng(37.566826, 126.9786567)),
            Pair("level", 3)
        )

        val map = kakao.maps.Map(container, options)

        var markerPosition = kakao.maps.LatLng(37.566826, 126.9786567)
        var marker = kakao.maps.Marker(json("position" to markerPosition))
        marker.setMap(map)
    }
}



external object kakao {
    object maps {
        class LatLng constructor(a: Double, b: Double)
        class Map constructor(container: Element?, options: Json)
        class Marker (json: Json?) {
            fun setMap(map: Map)
        }
        class InfoWindow constructor(json: Json?)
        object services {
            class Geocoder() {
                fun coord2RegionCode(a: Any, b: Any, c: Any)
            }
        }
        object event {
            fun addListener(
                map: Map,
                state: String,
                function: () -> Unit
            )
        }
    }
}