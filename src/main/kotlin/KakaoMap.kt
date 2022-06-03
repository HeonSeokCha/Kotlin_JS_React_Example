

import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.Window
import react.*


val KMap = FC<Props> {
    useEffectOnce {

        var container = document.getElementById("map")
//        options {
//            center = kakao.maps.LatLng(33.450701, 126.570667)
//            level = 3
//        }
//        kakao.maps.Map(container, TelegramIcon)
    }
}