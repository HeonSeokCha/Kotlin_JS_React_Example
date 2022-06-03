

import kotlinx.browser.document
import org.w3c.dom.Element
import react.*

val Map = {
    useEffectOnce {
        var container = document.getElementById("map")
        val options = Options.apply {
            center = kakao.maps.LatLng(33.450701, 126.570667)
            level = 3
        }
        kakao.maps.Map(container, options)
    }
}


external object Options {
    var center: Any
    var level: Int
}

external object kakao {
    val maps: Maps
}

external interface Maps {
    fun Map(container: Element?, options: Options)
    fun LatLng(a: Double, b: Double)
}


