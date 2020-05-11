package com.akoca.mvc.dao;

import com.akoca.mvc.domain.Organization;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizationDao {

    // Set the data-source that will be required to create a connection to the database.
    public void setDataSource(DataSource ds);

    // Create a record in the organization table
    public boolean create(Organization org);

    // Retrieve a single organization
    public Organization getOrganization(Integer id);

    // Retrieve all organizations from the table.
    public List<Organization> getAllOrganizations();

    // Delete a specific organization from the table.
    public boolean delete(Organization org);

    // Update an existing organization
    public boolean update(Organization org);

    public void cleanup();

}