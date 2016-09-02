/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ppro.modelo.PproRelEntidadProveedor;

/**
 *
 * @author casa
 */
@Stateless
public class PproRelEntidadProveedorFacade extends AbstractFacade<PproRelEntidadProveedor> {

    @PersistenceContext(unitName = "PproMpitV1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PproRelEntidadProveedorFacade() {
        super(PproRelEntidadProveedor.class);
    }
    
}
