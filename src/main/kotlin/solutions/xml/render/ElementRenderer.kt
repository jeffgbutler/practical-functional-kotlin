package solutions.xml.render

import solutions.xml.model.*
import solutions.xml.model.*

class ElementRenderer {

    fun render(element: Element): List<String> {
        return when (element) {
            is TextElement -> render(element)
            is XmlElementWithChildren -> render(element)
            is XmlElementWithoutChildren -> render(element)
        }
    }

    private fun render(element: TextElement): List<String> {
        return  listOf(element.content)
    }

    private fun render(element: XmlElementWithoutChildren): List<String> {
        return listOf("<${element.name}${renderAttributes(element)}/>")
    }

    private fun render(element: XmlElementWithChildren): List<String> {
        return renderOpen(element) + renderChildren(element) + renderClose(element)
    }


    private fun renderAttributes(element: XmlElement): String {
        return element.attributes?.let(this::renderAttributes) ?: ""
    }

    private fun renderAttributes(attributes: List<Attribute>): String {
        return " " + AttributeRenderer().renderAttributes(attributes)
    }

    private fun renderOpen(element: XmlElement): List<String> {
        return listOf("<${element.name}${renderAttributes(element)}>")
    }

    private fun renderChildren(element: XmlElementWithChildren): List<String> {
        return element.children
                .flatMap(this::renderChild)
                .map(this::indent)
    }

    private fun renderChild(child: Element): List<String> {
        return render(child)
    }

    private fun indent(s: String): String {
        return "  $s"
    }

    private fun renderClose(element: XmlElement): List<String> {
        return listOf("</${element.name}>")
    }
}
