/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.miage.ntdp.bibliotheque.services;

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
@Path("fr.unice.miage.ntdp.bibliotheque.livre")
public class LivreFacadeREST extends AbstractFacade<Livre> {

    @PersistenceContext(unitName = "BibliothequePU")
    private EntityManager em;

    public LivreFacadeREST() {
        super(Livre.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Livre entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Livre entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

      @GET
    @Path("find/pret/{id_livre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pret> findByLivre(@PathParam("id_livre") Long id) {
//       // return super.find(id);
       Query query;
       query = em.createNamedQuery("Pret.findByLivre");
       query.setParameter("idLivre", id);
//    //   Query query = em.createNamedQuery("Client.findAll");  
        return query.getResultList();
    }
    
    @GET
    @Path("find/livre/{id_Categorie}/{id_auteur}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pret> findAllAuteurCategorie(@PathParam("id_auteur") Long id_auteur, @PathParam("id_Categorie") Long id) {
        Query query = em.createNamedQuery("Livre.findByAuteurAndCategorie");
        query.setParameter("auteurId", id_auteur);
        query.setParameter("categorie",id);
        return query.getResultList();
    }
    
    @GET
    @Path("find/{nomlivre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Livre> findByLivre(@PathParam("nomlivre") String nom) {
       // return super.find(id);
      Query query;
       query = em.createNamedQuery("Livre.findLikeTitre");
        query.setParameter("nom", nom);
//    //   Query query = em.createNamedQuery("Client.findAll");  
       return query.getResultList();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Livre find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Livre> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Livre> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
