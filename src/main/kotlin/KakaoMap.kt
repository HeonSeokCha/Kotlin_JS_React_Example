import csstype.ClassName
import csstype.px
import emotion.react.css
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.appendElement
import org.w3c.dom.*
import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span
import kotlin.js.Json
import kotlin.js.json

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
        var marker = kakao.maps.Marker(null)
        var infowindow = kakao.maps.InfoWindow(json("zindex" to 1))


        kakao.maps.event.addListener(map, "click") { mouseEvent ->
            searchDetailAddrFromCoords(mouseEvent.asDynamic().latLng as Any) { result, status ->
                if (status.asDynamic() == kakao.maps.asDynamic().services.Status.OK) {
                    console.log(result)
                    var detailAddr = if (result.asDynamic()[0].road_address != null) {
                        document.createElement("div").apply {
                            this.textContent = "도로명 주소 : " + result.asDynamic()[0].road_address.address_name
                        }
                    } else document.createElement("div")
                    detailAddr.appendChild(document.createElement("div").apply {
                        this.textContent = "지번 주소 : " + result.asDynamic()[0].address.address_name
                        }
                    )

                    var content = document.createElement("div").apply {
                        className = "bAddr"
                        this.appendChild(document.createElement("span").apply {
                            textContent = "당신이 클릭한 주소"
                        })
                        this.appendChild(detailAddr)
                    }


                    marker.setPosition(mouseEvent.asDynamic().latLng)
                    marker.setMap(map)

                    infowindow.setContent(content)
                    infowindow.open(map, marker)
                }
            }
        }

    }
}

val geocoder = kakao.maps.services.Geocoder()
fun searchDetailAddrFromCoords(coords: Any, callback: (result: List<Any>, status: Any) -> Unit) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(
        coords.asDynamic().getLng() as Any,
        coords.asDynamic().getLat() as Any,
        callback
    )
}


external object kakao {
    object maps {
        class LatLng constructor(a: Double, b: Double)
        class Map constructor(container: Element?, options: Json) {

        }

        class Marker(json: Json?) {
            fun setMap(map: Map)
            fun setPosition(position: Any?)
        }

        class InfoWindow constructor(json: Json?) {
            fun setContent(a: Any?)
            fun open(a: Any?, b: Any?)
        }

        object services {
            class Geocoder {
                fun coord2Address(a: Any, b: Any, c: Any)

            }
        }

        object event {
            fun addListener(
                map: Any,
                state: Any,
                function: (mouse: Any) -> Unit
            )
        }
    }
}