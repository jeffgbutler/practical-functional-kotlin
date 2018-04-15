package solutions.xml.render.extension

import solutions.xml.model.*

fun Attribute.render(): String {
    return """$name="$value""""
}

fun List<Attribute>?.render(): String {
    return if (this == null) {
        ""
    } else {
        " " + sorted()
                .joinToString(" ", transform = { it.render() })
    }
}

fun DocType?.render() = if (this == null) {
    ""
} else {
    when (this) {
        is SystemDocType -> render()
        is PublicDocType -> render()
    }
}

fun PublicDocType.render(): String {
    return """ PUBLIC "$dtdName" "$dtdLocation""""
}

fun SystemDocType.render(): String {
    return """ SYSTEM "$dtdLocation""""
}

fun Element.render(): List<String> {
    return when (this) {
        is TextElement -> render()
        is XmlElementWithChildren -> render()
        is XmlElementWithoutChildren -> render()
    }
}

fun TextElement.render(): List<String> {
    return listOf(content)
}

fun XmlElementWithoutChildren.render(): List<String> {
    return listOf("<$name${attributes.render()}/>")
}

fun XmlElementWithChildren.render(): List<String> {
    return renderOpen() + renderChildren() + renderClose()
}

fun XmlElementWithChildren.renderOpen(): List<String> {
    return listOf("<$name${attributes.render()}>")
}

private fun XmlElementWithChildren.renderChildren(): List<String> {
    return children
            .flatMap(Element::render)
            .map(String::indent)
}

fun XmlElementWithChildren.renderClose(): String {
    return "</$name>"
}

private fun String.indent(): String {
    return "  ${this}"
}

fun Document.render(): String {
    return (listOf(renderXmlHeader(), renderDocType()) + rootElement.render())
            .joinToString("\n")
}

private fun renderXmlHeader(): String {
    return """<?xml version="1.0" encoding="UTF-8"?>"""
}

fun Document.renderDocType(): String {
    return "<!DOCTYPE ${rootElement.name}${docType.render()}>"
}
