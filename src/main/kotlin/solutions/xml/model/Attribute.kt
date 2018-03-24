package solutions.xml.model

class Attribute (val name: String, val value: String) : Comparable<Attribute> {
    override operator fun compareTo(other: Attribute) = name.compareTo(other.name)
}