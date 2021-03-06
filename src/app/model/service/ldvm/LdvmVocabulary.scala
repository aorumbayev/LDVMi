package model.service.ldvm

object LdvmVocabulary {

  val ttl =
    """
      |@prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#> .
      |@prefix skos:  <http://www.w3.org/2004/02/skos/core#> .
      |@prefix xsd:   <http://www.w3.org/2001/XMLSchema#> .
      |@prefix void:  <http://rdfs.org/ns/void#> .
      |@prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
      |
      |@prefix ldvm:  <http://linked.opendata.cz/ontology/ldvm/> .
      |
      |ldvm:Pipeline a rdfs:Class;
      | rdfs:label "LDVM Pipeline"@en;
      | rdfs:comment "Linked Data Visualization Model Pipeline"@en;
      | .
      |
      |ldvm:ComponentTemplate a rdfs:Class ;
      | rdfs:label "LDVM Component Template"@en;
      | rdfs:comment "Linked Data Visualization Model Component Template"@en;
      | .
      |
      |ldvm:ComponentInstance a rdfs:Class ;
      | rdfs:label "LDVM Component Instance"@en;
      | rdfs:comment "Linked Data Visualization Model Component Instance"@en;
      | .
      |
      |ldvm:DataSourceTemplate a rdfs:Class;
      | rdfs:label "LDVM Data Source Template"@en;
      | rdfs:comment "Linked Data Visualization Model Data Source Template"@en;
      | rdfs:subClassOf ldvm:ComponentTemplate ;
      | .
      |
      |ldvm:DataSourceInstance a rdfs:Class;
      | rdfs:label "LDVM Data Source Instance"@en;
      | rdfs:comment "Linked Data Visualization Model Data Source Instance"@en;
      | rdfs:subClassOf ldvm:ComponentInstance ;
      | .
      |
      |ldvm:AnalyzerTemplate a rdfs:Class;
      | rdfs:label "LDVM Analyzer Template"@en;
      | rdfs:comment "Linked Data Visualization Model Analyzer Template"@en;
      | rdfs:subClassOf ldvm:ComponentTemplate ;
      | .
      |
      |ldvm:AnalyzerInstance a rdfs:Class;
      | rdfs:label "LDVM Analyzer Instance"@en;
      | rdfs:comment "Linked Data Visualization Model Analyzer Instance"@en;
      | rdfs:subClassOf ldvm:ComponentInstance ;
      | .
      |
      |ldvm:VisualizerTemplate a rdfs:Class;
      | rdfs:label "LDVM Visualizer Template"@en;
      | rdfs:comment "Linked Data Visualization Model Visualizer Template"@en;
      | rdfs:subClassOf ldvm:ComponentTemplate ;
      | .
      |
      |ldvm:VisualizerInstance a rdfs:Class;
      | rdfs:label "LDVM Visualizer Instance"@en;
      | rdfs:comment "Linked Data Visualization Model Visualizer Instance"@en;
      | rdfs:subClassOf ldvm:ComponentInstance ;
      | .
      |
      |ldvm:DataPortTemplate a rdfs:Class;
      | rdfs:label "LDVM Data Port Template"@en;
      | rdfs:comment "Linked Data Visualization Model Data Port Template"@en;
      | .
      |
      |ldvm:InputDataPortTemplate a rdfs:Class;
      | rdfs:label "LDVM Input Data Port Template"@en;
      | rdfs:comment "Linked Data Visualization Model Input Data Port Template"@en;
      | rdfs:subClassOf ldvm:DataPortTemplate ;
      | .
      |
      |ldvm:OutputDataPortTemplate a rdfs:Class;
      | rdfs:label "LDVM Output Data Port Template"@en;
      | rdfs:comment "Linked Data Visualization Model Output Data Port Template"@en;
      | rdfs:subClassOf ldvm:DataPortTemplate ;
      | .
      |
      |ldvm:DataPortInstance a rdfs:Class;
      | rdfs:label "LDVM Data Port Instance"@en;
      | rdfs:comment "Linked Data Visualization Model Data Port Instance"@en;
      | .
      |
      |ldvm:inputTemplate a rdf:Property;
      | rdfs:label "Input Template"@en;
      | rdfs:domain ldvm:ComponentTemplate ;
      | rdfs:range ldvm:DataPortTemplate ;
      | .
      |
      |ldvm:inputInstance a rdf:Property;
      | rdfs:label "Input Instance"@en;
      | rdfs:domain ldvm:ComponentInstance ;
      | rdfs:range ldvm:DataPortInstance ;
      | .
      |
      |ldvm:ComponentConfiguration a rdfs:Class;
      | rdfs:label "LDVM Component Configuration"@en;
      | rdfs:comment "Linked Data Visualization Model Component Configuration"@en;
      | .
      |
      |ldvm:Feature a rdfs:Class;
      | rdfs:label "LDVM Feature"@en;
      | rdfs:comment "Linked Data Visualization Model Feature"@en;
      | .
      |
      |ldvm:MandatoryFeature a rdfs:Class;
      | rdfs:label "LDVM Mandatory Feature"@en;
      | rdfs:subClassOf ldvm:Feature ;
      | rdfs:comment "Linked Data Visualization Model Mandatory Feature"@en;
      | .
      |
      |ldvm:OptionalFeature a rdfs:Class;
      | rdfs:label "LDVM Optional Feature"@en;
      | rdfs:subClassOf ldvm:Feature ;
      | rdfs:comment "Linked Data Visualization Model Optional Feature"@en;
      | .
      |
      |ldvm:Signature a rdfs:Class;
      | rdfs:label "LDVM Signature"@en;
      | rdfs:comment "Linked Data Visualization Model Signature"@en;
      | .
      |
      |ldvm:feature a rdf:Property;
      | rdfs:label "Feature"@en;
      | rdfs:domain ldvm:ComponentTemplate ;
      | rdfs:range ldvm:Feature ;
      | .
      |
      |ldvm:signature a rdf:Property;
      | rdfs:label "Signature"@en;
      | rdfs:domain ldvm:Feature ;
      | rdfs:range ldvm:Signature ;
      | .
      |
      |ldvm:componentConfigurationTemplate a rdf:Property;
      | rdfs:label "Configuration Template"@en;
      | rdfs:domain ldvm:ComponentTemplate ;
      | rdfs:range ldvm:ComponentConfiguration ;
      | .
      |
      |ldvm:componentConfigurationInstance a rdf:Property;
      | rdfs:label "Configuration Instance"@en;
      | rdfs:domain ldvm:ComponentInstance ;
      | rdfs:range ldvm:ComponentConfiguration ;
      | .
      |
      |ldvm:outputInstance a rdf:Property;
      | rdfs:label "Output Instance"@en;
      | rdfs:domain ldvm:ComponentInstance ;
      | rdfs:range ldvm:DataPortInstance ;
      | .
      |
      |ldvm:outputTemplate a rdf:Property;
      | rdfs:label "Output Template"@en;
      | rdfs:domain ldvm:ComponentTemplate ;
      | rdfs:range ldvm:DataPortTemplate ;
      | .
      |
      |ldvm:query a rdf:Property;
      | rdfs:label "Query"@en;
      | rdfs:domain ldvm:Signature;
      | rdfs:range xsd:string ;
      | .
      |
      |ldvm:appliesTo a rdf:Property;
      | rdfs:label "Applies to"@en;
      | rdfs:domain ldvm:Signature;
      | rdfs:range ldvm:InputDataPortTemplate ;
      | .
      |
      |ldvm:instanceOf a rdf:Property;
      | rdfs:label "Instance of"@en ;
      | rdfs:domain ldvm:ComponentTemplate ;
      | rdfs:range ldvm:ComponentInstance ;
      | .
      |
      |ldvm:boundTo a rdf:Property;
      | rdfs:label "Bound To"@en ;
      | rdfs:domain ldvm:DataPortInstance ;
      | rdfs:range ldvm:DataPortInstance ;
      | .
      |
      |ldvm:member a rdf:Property;
      | rdfs:label "Pipeline member"@en ;
      | rdfs:domain ldvm:Pipeline ;
      | rdfs:range ldvm:ComponentInstance ;
      | .
    """.stripMargin

}
