package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproTipoProveedor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproTipoProveedorController")
@ViewScoped
public class PproTipoProveedorController extends AbstractController<PproTipoProveedor> {

    @Inject
    private MobilePageController mobilePageController;

    public PproTipoProveedorController() {
        // Inform the Abstract parent controller of the concrete PproTipoProveedor Entity
        super(PproTipoProveedor.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproProveedor entities
     * that are retrieved from PproTipoProveedor?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PproProveedor page
     */
    public String navigatePproProveedorCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproProveedor_items", this.getSelected().getPproProveedorCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproProveedor/index";
    }

    /**
     * Sets the "items" attribute with a collection of PproTipoAnexo entities
     * that are retrieved from PproTipoProveedor?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PproTipoAnexo page
     */
    public String navigatePproTipoAnexoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproTipoAnexo_items", this.getSelected().getPproTipoAnexoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproTipoAnexo/index";
    }

}
