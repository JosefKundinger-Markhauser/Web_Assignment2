/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.service;

import ass2.entity.Sprite;
import ass2.entity.AbstractFacade;
import java.util.List;
import java.util.Objects;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

/**
 *
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 * @version 2.0
 * 
 * This class implements a RESTFUL API.
 */
@javax.ejb.Stateless
@javax.ws.rs.Path("ass2.entity.sprite")
@DeclareRoles({"Admin", "RestGroup"})
public class SpriteFacadeREST extends AbstractFacade<Sprite> {
    
    private String okMessage = "Success";

    @PersistenceContext(unitName = "Assignment2-ejbPU")
    private EntityManager em;

    public SpriteFacadeREST() {
        super(Sprite.class);
    }

    /**
     * 
     * @param id The ID of the Sprite to be operated on.
     * @param newSprite The new Sprite object passed through the request.
     * @return Error response message when an error occurs, or okay message when successful.
     */
    @javax.ws.rs.PUT
    @RolesAllowed({"Admin", "RestGroup"})
    @javax.ws.rs.Path("{id}")
    @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public Response put(@javax.ws.rs.PathParam("id") Long id, Sprite newSprite) {
        Sprite oldSprite = super.find(id);
        if (oldSprite == null){
            return Response.status(404).build();
        }
        else if(!Objects.equals(oldSprite.getId(), newSprite.getId())){
            return Response.status(403).build();
        }
        super.edit(newSprite);
       
        return Response.ok(okMessage).build();
    }
    
    /**
     * 
     * @param id The ID of the Sprite to be operated on.
     * @param newSprite The new Sprite object passed through the request.
     * @return Error response message when an error occurs, or okay message when successful.
     */
    @javax.ws.rs.POST
    @RolesAllowed({"Admin", "RestGroup"})
    @javax.ws.rs.Path("{id}")
    @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public Response post(@javax.ws.rs.PathParam("id") Long id, Sprite newSprite) {
        Sprite oldSprite = super.find(id);
        if (oldSprite == null){
            return Response.status(404).build();
        }
        else if(!Objects.equals(oldSprite.getId(), newSprite.getId())){
            return Response.status(403).build();
        }
        
        newSprite.updates(oldSprite);
        super.edit(oldSprite);
        
        return Response.ok(okMessage).build();
    }
    
    /**
     * 
     * @param newSprite The new Sprite object passed through the request.
     * @return Error response message when an error occurs, or okay message when successful.
     */
    @javax.ws.rs.POST
    @RolesAllowed({"Admin", "RestGroup"})
    @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public Response post(Sprite newSprite) {
        if(newSprite.getId() == null){
            super.create(newSprite);
        }
        else{
            Sprite oldSprite = super.find(newSprite.getId());
            if(oldSprite != null){
                newSprite.updates(oldSprite);
                super.edit(oldSprite);
            }
            else{
                return Response.status(404).build();
            }
        }
        
        return Response.ok(okMessage).build();
    }

    @javax.ws.rs.DELETE
    @RolesAllowed({"Admin", "RestGroup"})
    @javax.ws.rs.Path("{id}")
    public void remove(@javax.ws.rs.PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @javax.ws.rs.GET
    @RolesAllowed({"Admin", "RestGroup"})
    @javax.ws.rs.Path("{id}")
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public Sprite find(@javax.ws.rs.PathParam("id") Long id) {
        return super.find(id);
    }

    @javax.ws.rs.GET
    @RolesAllowed({"Admin", "RestGroup"})
    @Override
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    @javax.ws.rs.GET
    @RolesAllowed({"Admin", "RestGroup"})
    @javax.ws.rs.Path("{from}/{to}")
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@javax.ws.rs.PathParam("from") Integer from, @javax.ws.rs.PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     * This is the endpoint to see how many sprites are in the database.
     * @return The total number of Sprites.
     */
    @javax.ws.rs.GET
    @RolesAllowed({"Admin", "RestGroup"})
    @javax.ws.rs.Path("count")
    @javax.ws.rs.Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
