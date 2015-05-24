package com.circulo.model.repository;

import com.circulo.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tfulton on 5/23/15.
 */
public interface OrganizationRepository
    extends JpaRepository<Organization, Long>{

}
