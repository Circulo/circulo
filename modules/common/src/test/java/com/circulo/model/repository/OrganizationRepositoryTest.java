package com.circulo.model.repository;

import com.circulo.model.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by tfulton on 5/24/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringockitoContextLoader.class,
        locations = {"classpath:spring-test-config.xml"})
public class OrganizationRepositoryTest {


    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    public void testCreateOrganization() {

        Organization organization = new Organization();
        organization.setId(UUID.randomUUID().toString());
        organization.setName("blah blah");
        organization.setDescription("this is more blah blah");

        organizationRepository.save(organization);
    }
}

