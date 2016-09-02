package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproProveedor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproProveedorController")
@ViewScoped
public class PproProveedorController extends AbstractController<PproProveedor> {

    @Inject
    private PproPersonaController provPerIdController;
    @Inject
    private PproFormaPagoController provFpagIdController;
    @Inject
    private PproTipoProveedorController provTiproIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproProveedorController() {
        // Inform the Abstract parent controller of the concrete PproProveedor Entity
        super(PproProveedor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        provPerIdController.setSelected(null);
        provFpagIdController.setSelected(null);
        provTiproIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PproDocumento entities
     * that are retrieved from PproProveedor?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PproDocumento page
     */
    public String navigatePproDocumentoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproDocumento_items", this.getSelected().getPproDocumentoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproDocumento/index";
    }

    /**
     * Sets the "items" attribute with a collection of PproRelEntidadProveedor
     * entities that are retrieved from PproProveedor?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PproRelEntidadProveedor page
     */
    public String navigatePproRelEntidadProveedorCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproRelEntidadProveedor_items", this.getSelected().getPproRelEntidadProveedorCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproRelEntidadProveedor/index";
    }

    /**
     * Sets the "selected" attribute of the PproPersona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProvPerId(ActionEvent event) {
        if (this.getSelected() != null && provPerIdController.getSelected() == null) {
            provPerIdController.setSelected(this.getSelected().getProvPerId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproFormaPago controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProvFpagId(ActionEvent event) {
        if (this.getSelected() != null && provFpagIdController.getSelected() == null) {
            provFpagIdController.setSelected(this.getSelected().getProvFpagId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproTipoProveedor controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProvTiproId(ActionEvent event) {
        if (this.getSelected() != null && provTiproIdController.getSelected() == null) {
            provTiproIdController.setSelected(this.getSelected().getProvTiproId());
        }
    }
}
