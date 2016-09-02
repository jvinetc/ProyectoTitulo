/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.contoller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import ppro.modelo.PproDocumento;

/**
 *
 * @author casa
 */
@ManagedBean
@RequestScoped
public class GestionController {
    
    
    @ManagedProperty(value = "#{pproDocumento}")
    private PproDocumento pproDocumento;

    public PproDocumento getPproDocumento() {
        return pproDocumento;
    }

    public void setPproDocumento(PproDocumento pproDocumento) {
        this.pproDocumento = pproDocumento;
    }
    
    public void buscaDocumento(PproDocumento doc) throws IOException{
        //FacesContext.getCurrentInstance().getExternalContext().redirect("gestion.xhtml");        
             
        FacesContext.getCurrentInstance().getExternalContext().redirect("gestion.xhtml");
        pproDocumento=doc;   
        RequestContext.getCurrentInstance().update("updateForm");
    }
}
