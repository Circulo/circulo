package com.circulo.controllers;

import com.circulo.model.Organization;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.UUID;

/**
 * Created by tfulton on 5/23/15.
 */
@org.springframework.stereotype.Controller
public class OrganizationController
        extends Controller {

    @Autowired
    private MongoTemplate mongoTemplate;

    private Result create() {

//        mongoTemplate.save(org);
        return null;
    }

    public Result list() {

        List<Organization> orgs = mongoTemplate.findAll(Organization.class);
        

//        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
//        ObjectNode result = Json.newObject();
//        for (Organization org : orgs) {
//
//            ObjectNode orgNode = Json.newObject();
//            result.put("id", org.getId());
//            result.put("name", org.getName());
//            result.put("description", org.getDescription());
//
//            arrayNode.add(orgNode);
//        }
//        ObjectNode result = Json.newObject();

        return ok("Hello World");
    }
}
