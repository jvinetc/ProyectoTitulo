package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproTipoAnexo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproTipoAnexoController")
@ViewScoped
public class PproTipoAnexoController extends AbstractController<PproTipoAnexo> {

    @Inject
    private PproTipoProveedorController tanTiproIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproTipoAnexoController() {
        // Inform the Abstract parent controller of the concrete PproTipoAnexo Entity
        super(PproTipoAnexo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tanTiproIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PproAnexoDocumento
     * entities that are retrieved from PproTipoAnexo?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PproAnexoDocumento page
     */
    public String navigatePproAnexoDocumentoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproAnexoDocumento_items", this.getSelected().getPproAnexoDocumentoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproAnexoDocumento/index";
    }

    /**
     * Sets the "selected" attribute of the PproTipoProveedor controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTanTiproId(ActionEvent event) {
        if (this.getSelected() != null && tanTiproIdController.getSelected() == null) {
            tanTiproIdController.setSelected(this.getSelected().getTanTiproId());
        }
    }
}
