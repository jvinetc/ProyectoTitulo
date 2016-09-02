package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproFormaPago;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproFormaPagoController")
@ViewScoped
public class PproFormaPagoController extends AbstractController<PproFormaPago> {

    @Inject
    private MobilePageController mobilePageController;

    public PproFormaPagoController() {
        // Inform the Abstract parent controller of the concrete PproFormaPago Entity
        super(PproFormaPago.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproProveedor entities
     * that are retrieved from PproFormaPago?cap_first and returns the
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

}
