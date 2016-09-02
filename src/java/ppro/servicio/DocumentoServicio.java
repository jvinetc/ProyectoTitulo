/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ppro.modelo.PproDocumento;

/**
 *
 * @author casa
 */
@Stateless
public class DocumentoServicio {
    
     @PersistenceContext(unitName = "PproMpitV1PU")
        private EntityManager em;
     
     public boolean guardarDocumento(PproDocumento d){
         boolean hecho=false;
         try {
             em.persist(d);
             hecho=true;
         } catch (Exception e) {
         }
         return hecho;
     } 
     
     public List<PproDocumento> listaDocumento(){
         TypedQuery<PproDocumento> query= em.createNamedQuery("PproDocumento.findAll",PproDocumento.class);
         return query.getResultList();
     }
     
     public PproDocumento buscarDoc(PproDocumento documento){
          return  em.find(PproDocumento.class, documento.getDocId());
     }
}
