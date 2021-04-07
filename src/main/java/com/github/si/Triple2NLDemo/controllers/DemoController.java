package com.github.si.Triple2NLDemo.controllers;

import org.aksw.triple2nl.TripleConverter;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.dllearner.kb.sparql.SparqlEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/greeting")
	public String getDemoResult() {
		// create the triple we want to convert by using JENA API
		Triple t = Triple.create(
					 NodeFactory.createURI("http://dbpedia.org/resource/Albert_Einstein"),
					 NodeFactory.createURI("http://dbpedia.org/ontology/range"),
					 NodeFactory.createURI("http://dbpedia.org/resource/region"));

		// Optionally, we can declare a knowledge base that contains the triple.
		// This can be useful during the verbalization process, e.g. the KB could contain labels for entities.
		// Here, we use the DBpedia SPARQL endpoint.
		SparqlEndpoint endpoint = SparqlEndpoint.getEndpointDBpedia();

		// create the triple converter
		TripleConverter converter = new TripleConverter(endpoint);

		// convert the triple into natural language
		return converter.convert(t);
	}
}
