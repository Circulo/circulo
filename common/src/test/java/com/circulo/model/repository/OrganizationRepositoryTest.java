package com.circulo.model.repository;

import com.circulo.model.Organization;
import com.circulo.util.DateFormat;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by tfulton on 5/24/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringockitoContextLoader.class,
        locations = {"classpath:spring-test-config.xml"})
public class OrganizationRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private OrganizationRepository organizationRepository;

    private Gson gson = new Gson();

    @Test
    public void testCreateOrganization() {

        String dateStr = DateFormat.getIso8061(new Date());

        Organization organization = new Organization();
        organization.setId(UUID.randomUUID().toString());
        organization.setName("blah blah");
        organization.setDescription(dateStr);

        System.out.println(gson.toJson(organization));


        organizationRepository.save(organization);

        Query query = new Query(Criteria.where("_id").is(organization.getId()));
        List<Organization> orgCopy = mongoTemplate.find(query, Organization.class);

        Assert.assertTrue(orgCopy.size() > 0);
    }
}

