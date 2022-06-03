
import csstype.Properties
import csstype.px
import emotion.css.css
import emotion.react.css
import kotlinx.browser.document
import react.*
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div

fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find root container!")
    val root = createRoot(container)
    root.render(
        Fragment.create {
            div {
                id = "map"
                css {
                    width = 500.px
                    height = 400.px
                }
            }
        }
    )
}

