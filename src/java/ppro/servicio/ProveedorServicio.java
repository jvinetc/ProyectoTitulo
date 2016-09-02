/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ppro.modelo.PproProveedor;

/**
 *
 * @author casa
 */
@Stateless
public class ProveedorServicio {
        
    @PersistenceContext(unitName = "PproMpitV1PU")
    private EntityManager em;
    
    public PproProveedor buscaPorRut(PproProveedor proveedor){
        try {
            Query query= em.createNamedQuery("PproProveedor.findByRutProv",PproProveedor.class);
            query.setParameter("rutProv", proveedor.getProvPerId().getPerRut());
            proveedor=(PproProveedor) query.getSingleResult();
        } catch (Exception e) {
        }
        return proveedor;
    }
    
    public List<PproProveedor> listaProveedor(){
        
       
            
            TypedQuery<PproProveedor> query= em.createNamedQuery("PproProveedor.findAll",PproProveedor.class);
              
        
       return query.getResultList();
    }
    
    public PproProveedor buscaPorId(Integer id){
        Query query=em.createNamedQuery("PproProveedor.findByProvId", PproProveedor.class);
        query.setParameter("provId", id);
        return (PproProveedor) query.getSingleResult();
    }
}
