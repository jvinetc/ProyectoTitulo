/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.contoller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import ppro.modelo.PproPersona;
import ppro.modelo.PproProveedor;
import ppro.servicio.PersonaServicio;
import ppro.servicio.ProveedorServicio;

/**
 *
 * @author casa
 */
@ManagedBean
@ApplicationScoped
public class ProveedorConroller {

    @EJB    
    private PersonaServicio personaServicio;

    @EJB
    private ProveedorServicio proveedorServicio;
        
    @ManagedProperty(value = "#{pproPersona}")
    private PproPersona pproPersona;
    
    
    @ManagedProperty(value = "#{pproProveedor}")
    private PproProveedor pproProveedor;
    
    private List<PproProveedor> listaProveedor= new ArrayList<>();
    
    

    public PproProveedor getPproProveedor() {
        return pproProveedor;
    }

    public void setPproProveedor(PproProveedor pproProveedor) {
        this.pproProveedor = pproProveedor;
    }

    public PproPersona getPproPersona() {
        return pproPersona;
    }

    public void setPproPersona(PproPersona pproPersona) {
        this.pproPersona = pproPersona;
    }
    
    
    
    public void traeProveedor(){    
        
        
        FacesContext.getCurrentInstance().
                addMessage(null,new FacesMessage("Proveedor encontrado "));
     
    }

    public List<PproProveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<PproProveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }
    
    
    public List<PproProveedor> completarProveedor(String query){
        List<PproProveedor> listaProv= this.getListaProveedor();
        List<PproProveedor> filtroLista= new ArrayList<>();
            for(PproProveedor prov : listaProv){
                if(String.valueOf(prov.getProvPerId().getPerRut()).contains(query)){
                    filtroLista.add(prov);
                }
            }        
       return filtroLista;
     
    }
    
    
    
    @PostConstruct
    public void init(){
        listaProveedor= proveedorServicio.listaProveedor();
    }
}
