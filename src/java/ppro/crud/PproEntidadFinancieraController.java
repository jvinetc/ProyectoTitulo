package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproEntidadFinanciera;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproEntidadFinancieraController")
@ViewScoped
public class PproEntidadFinancieraController extends AbstractController<PproEntidadFinanciera> {

    @Inject
    private MobilePageController mobilePageController;

    public PproEntidadFinancieraController() {
        // Inform the Abstract parent controller of the concrete PproEntidadFinanciera Entity
        super(PproEntidadFinanciera.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproRelEntidadProveedor
     * entities that are retrieved from PproEntidadFinanciera?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for PproRelEntidadProveedor page
     */
    public String navigatePproRelEntidadProveedorCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproRelEntidadProveedor_items", this.getSelected().getPproRelEntidadProveedorCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproRelEntidadProveedor/index";
    }

}
