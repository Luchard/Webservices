/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.miage.ntdp.bibliotheque.services;

import fr.unice.miage.ntdp.bibliotheque.Auteur;
import fr.unice.miage.ntdp.bibliotheque.Livre;
import fr.unice.miage.ntdp.bibliotheque.Pret;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author luchi
 */
@Stateless
@Path("fr.unice.miage.ntdp.bibliotheque.auteur")
public class AuteurFacadeREST extends AbstractFacade<Auteur> {

    @PersistenceContext(unitName = "BibliothequePU")
    private EntityManager em;

    public AuteurFacadeREST() {
        super(Auteur.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Auteur entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Auteur entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public Auteur find(@PathParam("id") Long id) {
       return super.find(id);
   }
    
    @GET
    @Path("find/{nomauteur}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Auteur> allLivres(@PathParam("nomauteur") String nom) {
//       // return super.find(id);
       Query query;
        query = em.createNamedQuery("Auteur.findLikeNom");
        query.setParameter("nom", nom);
        query.setParameter("prenom", nom);
    //   Query query = em.createNamedQuery("Client.findAll");  
        return query.getResultList();
 }
    
        @GET
    @Path("pret/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Pret> allPret(@PathParam("id") Long id) {
       Query query;
        query = em.createNamedQuery("Pret.findByAuteur");
        query.setParameter("auteurId", id);
        return query.getResultList();
 }


    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Auteur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Auteur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
