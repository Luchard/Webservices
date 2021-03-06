/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author luchi
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

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
        resources.add(fr.unice.miage.ntdp.bibliotheque.services.AuteurFacadeREST.class);
        resources.add(fr.unice.miage.ntdp.bibliotheque.services.CategorieFacadeREST.class);
        resources.add(fr.unice.miage.ntdp.bibliotheque.services.LivreFacadeREST.class);
        resources.add(fr.unice.miage.ntdp.bibliotheque.services.PersonneFacadeREST.class);
        resources.add(fr.unice.miage.ntdp.bibliotheque.services.PretFacadeREST.class);
        resources.add(fr.unice.miage.ntdp.bibliotheque.services.UsersFacadeREST.class);
        resources.add(org.netbeans.rest.application.config.RequestFilter.class);
    }
    
   
    
}
