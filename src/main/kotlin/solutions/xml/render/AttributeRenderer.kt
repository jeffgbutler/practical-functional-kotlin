package solutions.xml.render

import solutions.xml.model.Attribute

class AttributeRenderer {
    fun renderAttribute(attribute: Attribute): String {
        return """${attribute.name}="${attribute.value}""""
    }

    fun renderAttributes(attributes: List<Attribute>): String {
        return attributes
                .sorted()
                .joinToString(" ", transform = this::renderAttribute)
    }
}
