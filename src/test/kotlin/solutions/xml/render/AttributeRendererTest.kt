package solutions.xml.render

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import solutions.xml.model.Attribute

class AttributeRendererTest {

    @Test
    fun testSingleAttribute() {
        val attribute = Attribute("foo", "bar")

        assertThat(AttributeRenderer().renderAttribute(attribute)).isEqualTo("""foo="bar"""")
    }

    @Test
    fun testMultipleAttributes() {
        val attributes = listOf(
                Attribute("name", "fred"),
                Attribute("foo", "bar"))

        assertThat(AttributeRenderer().renderAttributes(attributes)).isEqualTo("""foo="bar" name="fred"""")
    }
}
