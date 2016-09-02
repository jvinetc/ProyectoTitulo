/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ppro.modelo.PproModuloPerfil;

/**
 *
 * @author casa
 */
@Stateless
public class PproModuloPerfilFacade extends AbstractFacade<PproModuloPerfil> {

    @PersistenceContext(unitName = "PproMpitV1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PproModuloPerfilFacade() {
        super(PproModuloPerfil.class);
    }
    
}
