/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.service;

import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;

/**
 *
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 * @version 2.0
 * 
 * This class is used to setup the RESTFUL API.
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup= "${'java:comp/DefaultDataSource'}",
        callerQuery= "#{'SELECT PASSWORD FROM APP.APPUSER WHERE USERID= ?'}",
        groupsQuery= "SELECT GROUPNAME FROM APP.APPUSER WHERE USERID= ?",
        hashAlgorithm= PasswordHash.class,
        priority = 10
)
@BasicAuthenticationMechanismDefinition
@ApplicationScoped
@Named
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
    }
    
}
