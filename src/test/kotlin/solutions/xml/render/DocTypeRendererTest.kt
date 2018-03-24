package solutions.xml.render

import org.assertj.core.api.Assertions.*

import org.junit.Test
import solutions.xml.render.DocTypeRendererTest.DtdInfo.DTD_LOCATION
import solutions.xml.render.DocTypeRendererTest.DtdInfo.DTD_NAME

import solutions.xml.model.PublicDocType
import solutions.xml.model.SystemDocType

class DocTypeRendererTest {


    @Test
    fun testPublicDocType() {
        val docType = PublicDocType(DTD_LOCATION, DTD_NAME)

        val dcType = DocTypeRenderer().render(docType)

        assertThat(dcType).isEqualTo("""PUBLIC "$DTD_NAME" "$DTD_LOCATION"""")
    }

    @Test
    fun testSystemDocType() {
        val docType = SystemDocType(DTD_LOCATION)

        val dcType = DocTypeRenderer().render(docType)
        assertThat(dcType).isEqualTo("""SYSTEM "$DTD_LOCATION"""")
    }

    object DtdInfo {
        const val DTD_NAME = "-//Example//EN"
        const val DTD_LOCATION = "example.dtd"
    }
}
