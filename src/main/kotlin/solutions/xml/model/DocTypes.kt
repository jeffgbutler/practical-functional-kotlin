package solutions.xml.model

sealed class DocType (val dtdLocation: String)

class PublicDocType (dtdLocation: String, val dtdName: String) : DocType(dtdLocation)

class SystemDocType (dtdLocation: String) : DocType(dtdLocation)
