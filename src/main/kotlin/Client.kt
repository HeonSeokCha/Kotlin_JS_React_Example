import csstype.px
import kotlinx.browser.document
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div

fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find root container!")
    val root = createRoot(container)

    root.render(Fragment.create() {
        div {
            id = "map"
        }
    })
}