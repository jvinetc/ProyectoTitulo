/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ppro.modelo.PproDocumento;

/**
 *
 * @author casa
 */
@Stateless
public class PproDocumentoFacade extends AbstractFacade<PproDocumento> {

    @PersistenceContext(unitName = "PproMpitV1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PproDocumentoFacade() {
        super(PproDocumento.class);
    }
    
}
