package com.akoca.mvc.service;

import com.akoca.mvc.dao.OrganizationDao;
import com.akoca.mvc.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    public List<Organization> getOrgList() {
        List<Organization> organizationList = organizationDao.getAllOrganizations();

        return organizationList;
    }
}