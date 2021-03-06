package model.rdf

import scala.collection.JavaConversions._
import scala.collection.mutable

class LocalizedValue {

  private val languageMap = new mutable.HashMap[String, String]

  def put(language: String, localizedString: String) {
    languageMap.put(language, localizedString)
  }

  def get(language: String): Option[String] = {
    languageMap.get(language)
  }

  def getOrElse(language: String, defaultLanguage: String): Option[String] = {
    val primary = languageMap.get(language)
    if (primary.isDefined) {
      primary
    } else {
      languageMap.get(defaultLanguage)
    }
  }

  def getOrFirst(language: String): Option[String] = {
    val primary = languageMap.get(language)
    if (primary.isDefined) {
      primary
    } else {
      languageMap.headOption.map(_._2)
    }
  }

  def size = languageMap.size
}

object LocalizedValue {

  def apply(variants: Map[String, String]): LocalizedValue = {
    val l = new LocalizedValue
    variants.foreach { case (language, value) =>
      l.put(language.isEmpty match { case true => "nolang"; case false => language }, value)
    }
    l
  }

  def create(variant: (String, String)): LocalizedValue = {
    apply(Seq(variant).toMap)
  }

  def create(literal: org.apache.jena.rdf.model.Literal): LocalizedValue = {
    create((literal.getLanguage, literal.getString))
  }

  def create(literals: Seq[org.apache.jena.rdf.model.Literal]): LocalizedValue = {
    apply(literals.map(l => (l.getLanguage, l.getString)).toMap)
  }

  def create(resource: org.apache.jena.rdf.model.Resource, property: org.apache.jena.rdf.model.Property): LocalizedValue = {
    apply(resource.listProperties(property).toList
      .map(_.getObject.asLiteral()).reverse
      .map(l => (l.getLanguage, l.getString)).toMap)
  }

  def unapply(l: LocalizedValue): Option[Map[String, String]] = {
    if (l.languageMap.nonEmpty) {
      Some(l.languageMap.toMap)
    } else {
      None
    }
  }

}
