package solutions.xml.model

sealed class Element

class TextElement(val content: String) : Element()

sealed class XmlElement(val name: String, val attributes: List<Attribute>?) : Element()

class XmlElementWithoutChildren(name: String, attributes: List<Attribute>? = null) : XmlElement(name, attributes) {
    constructor(name: String, attribute: Attribute) : this(name, listOf(attribute))

    operator fun plus(child: Element): XmlElementWithChildren {
        return XmlElementWithChildren(name, attributes, listOf(child))
    }
}

class XmlElementWithChildren(name: String, attributes: List<Attribute>?, val children: List<Element>) : XmlElement(name, attributes) {
    constructor(name: String, attribute: Attribute, element: Element) : this(name, listOf(attribute), listOf(element))

    operator fun plus(child: Element): XmlElementWithChildren {
        return XmlElementWithChildren(name, attributes, children + child)
    }
}

