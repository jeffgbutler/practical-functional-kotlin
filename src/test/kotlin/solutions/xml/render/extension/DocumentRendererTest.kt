package solutions.xml.render.extension

import solutions.xml.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DocumentRendererTest {

    @Test
    fun testMinimalDocument() {
        val element = XmlElementWithoutChildren("testElement")

        val document = Document(null, element)

        val answer = document.render()

        val expected = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<!DOCTYPE testElement>
                |<testElement/>
                """.trimMargin()

        assertThat(answer).isEqualTo(expected)
    }

    @Test
    fun testMinimalDocumentWithSystemDocType() {
        val element = XmlElementWithoutChildren("testElement", Attribute("foo", "bar"))

        val docType = SystemDocType("example.dtd")

        val document = Document(docType, element)

        val answer = document.render()

        val expected = """
             |<?xml version="1.0" encoding="UTF-8"?>
             |<!DOCTYPE testElement SYSTEM "example.dtd">
             |<testElement foo="bar"/>
             """.trimMargin()

        assertThat(answer).isEqualTo(expected)
    }

    @Test
    fun testDocumentAttributeAndText() {
        val element = XmlElementWithChildren("testElement",
                Attribute("foo", "bar"),
                TextElement("some text"))

        val docType = SystemDocType("example.dtd")

        val document = Document(docType, element)

        val answer = document.render()

        val expected = """
            |<?xml version="1.0" encoding="UTF-8"?>
            |<!DOCTYPE testElement SYSTEM "example.dtd">
            |<testElement foo="bar">
            |  some text
            |</testElement>
            """.trimMargin()


        assertThat(answer).isEqualTo(expected)
    }

    @Test
    fun textComplexDocument() {
        var element = XmlElementWithChildren("testElement",
                Attribute("foo", "bar"),
                TextElement("some text"))

        val subElement = XmlElementWithChildren("subElement1",
                Attribute("name", "fred"),
                TextElement("more text"))

        element = element + subElement

        val subElement2 = XmlElementWithoutChildren("subElement2")

        element = element + subElement2

        val docType = PublicDocType("example.dtd", "-//Example//EN")

        val document = Document(docType, element)

        val answer = document.render()

        val expected = """
            |<?xml version="1.0" encoding="UTF-8"?>
            |<!DOCTYPE testElement PUBLIC "-//Example//EN" "example.dtd">
            |<testElement foo="bar">
            |  some text
            |  <subElement1 name="fred">
            |    more text
            |  </subElement1>
            |  <subElement2/>
            |</testElement>
            """.trimMargin()

        assertThat(answer).isEqualTo(expected)
    }
}
