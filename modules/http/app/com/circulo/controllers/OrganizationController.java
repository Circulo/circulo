package com.circulo.controllers;

import com.circulo.model.Organization;
import com.circulo.model.repository.OrganizationRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.UUID;

/**
 * Created by tfulton on 5/23/15.
 */
@org.springframework.stereotype.Controller
public class OrganizationController
        extends Controller {

    private OrganizationRepository organizationRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BodyParser.Of(BodyParser.Json.class)
    public Result create() {

        JsonNode json = request().body().asJson();

        Organization org = new Organization();
        org.setId(UUID.randomUUID().toString());
        org.setName(json.get("name").textValue());
        org.setDescription(json.get("description").textValue());
        mongoTemplate.save(org);

        return created();
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result update(String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.find(query, Organization.class);

        JsonNode json = request().body().asJson();

        Organization org = new Organization();
        org.setId(UUID.randomUUID().toString());
        org.setName(json.get("name").textValue());
        org.setDescription(json.get("description").textValue());

        mongoTemplate.updateFirst(query,
                Update.update("name", org.getName())
                        .addToSet("description", org.getDescription()),
                Organization.class);

        return ok();

    }

    public Result list() {

//        List<Organization> orgs = mongoTemplate.findAll(Organization.class);


//        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
//        ObjectNode result = Json.newObject();
//        for (Organization org : orgs) {
//
//            ObjectNode orgNode = Json.newObject();
//            orgNode.put("id", org.getId());
//            orgNode.put("name", org.getName());
//            orgNode.put("description", org.getDescription());

//            arrayNode.add(orgNode);
//        }
//        ObjectNode result = Json.newObject();

        return ok("Hello World");
    }
}
