package solutions.xml.render

import solutions.xml.model.DocType
import solutions.xml.model.PublicDocType
import solutions.xml.model.SystemDocType

class DocTypeRenderer  {

    fun render(docType: DocType): String {
        return when (docType) {
            is SystemDocType -> render(docType)
            is PublicDocType -> render(docType)
        }
    }

    private fun render(doctype: PublicDocType): String {
        return """PUBLIC "${doctype.dtdName}" "${doctype.dtdLocation}""""
    }

    private fun render(doctype: SystemDocType): String {
        return """SYSTEM "${doctype.dtdLocation}""""
    }
}
