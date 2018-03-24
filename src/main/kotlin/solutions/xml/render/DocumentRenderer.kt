package solutions.xml.render

import solutions.xml.model.DocType
import solutions.xml.model.Document

class DocumentRenderer {

    fun render(document: Document): String {
        return (listOf(renderXmlHeader(), renderDocType(document)) + renderRootElement(document))
                .joinToString("\n")
    }

    private fun renderXmlHeader(): String {
        return """<?xml version="1.0" encoding="UTF-8"?>"""
    }

    private fun renderDocType(document: Document): String {
        return """<!DOCTYPE ${document.rootElement.name}${renderDocType(document.docType)}>"""
    }

    private fun renderDocType(docType: DocType?): String {
        return docType?.let {" " + DocTypeRenderer().render(it)} ?: ""
    }

    private fun renderRootElement(document: Document): List<String> {
        return ElementRenderer().render(document.rootElement)
    }
}
