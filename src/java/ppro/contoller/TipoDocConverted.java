/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppro.contoller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import ppro.modelo.PproTipoDocumento;

/**
 *
 * @author STM1
 */
@FacesConverter("tipoDocConverted")
public class TipoDocConverted implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value!=null && value.trim().length()>0){
            try {
                TipoDocumentoController tipoDoc= (TipoDocumentoController) context.getExternalContext().getApplicationMap().get("tipoDocumentoController");
                return tipoDoc.getListaTipo().get(Integer.parseInt(value)-1);
            } catch (NumberFormatException e) {
                throw  new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Conversion", "No es un valor valido"));
            }
        }else{
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if(value!=null){
            return String.valueOf(((PproTipoDocumento) value).getTdocId());
        }else{
            return null;
        }
    }
    
}
