package model.rdf.sparql.datacube

import model.rdf.LocalizedValue

case class DataCubeDataset(
  uri: String,
  title: Option[LocalizedValue] = None,
  label: Option[LocalizedValue] = None,
  comment: Option[LocalizedValue] = None,
  description: Option[LocalizedValue] = None,
  publisher: Option[String] = None,
  issued: Option[String] = None
)