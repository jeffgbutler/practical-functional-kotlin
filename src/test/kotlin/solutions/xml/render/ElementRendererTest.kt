package solutions.xml.render

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import solutions.xml.model.*

class ElementRendererTest {

    @Test
    fun testTextElement() {
        val element = TextElement("some text")

        val answer = ElementRenderer().render(element)
                .joinToString("\n")

        assertThat(answer).isEqualTo("some text")
    }

    @Test
    fun testEmptyElementNoAttributes() {
        val element = XmlElementWithoutChildren("testElement")

        val answer = ElementRenderer().render(element)
                .joinToString("\n")

        assertThat(answer).isEqualTo("<testElement/>")
    }

    @Test
    fun testEmptyElementWithAttribute() {
        val element = XmlElementWithoutChildren("testElement", Attribute("foo", "bar"))

        val answer = ElementRenderer().render(element)
                .joinToString("\n")

        assertThat(answer).isEqualTo("""<testElement foo="bar"/>""")
    }

    @Test
    fun testElementWithAttributeAndText() {
        val element = XmlElementWithChildren("testElement", Attribute("foo", "bar"),
                TextElement("some text"))

        val answer = ElementRenderer().render(element)
                .joinToString("\n")

        val expected = """
            |<testElement foo="bar">
            |  some text
            |</testElement>
            """.trimMargin()

        assertThat(answer).isEqualTo(expected)
    }

    @Test
    fun textComplexElement() {
        val element = XmlElementWithoutChildren("testElement", Attribute("foo", "bar"))

        var element2 = element + TextElement("some text")

        val subElement = XmlElementWithChildren("subElement1", Attribute("name", "fred"),
                TextElement("more text"))

        element2 += subElement

        val subElement2 = XmlElementWithoutChildren("subElement2")

        element2 += subElement2

        val answer = ElementRenderer().render(element2)
                .joinToString("\n")

        val expected = """
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
