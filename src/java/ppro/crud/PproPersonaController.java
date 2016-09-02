package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproPersona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproPersonaController")
@ViewScoped
public class PproPersonaController extends AbstractController<PproPersona> {

    @Inject
    private PproTipoPersonaController perTiperIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproPersonaController() {
        // Inform the Abstract parent controller of the concrete PproPersona Entity
        super(PproPersona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        perTiperIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PproUsuario entities that
     * are retrieved from PproPersona?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PproUsuario page
     */
    public String navigatePproUsuarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproUsuario_items", this.getSelected().getPproUsuarioCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproUsuario/index";
    }

    /**
     * Sets the "selected" attribute of the PproTipoPersona controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePerTiperId(ActionEvent event) {
        if (this.getSelected() != null && perTiperIdController.getSelected() == null) {
            perTiperIdController.setSelected(this.getSelected().getPerTiperId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of PproProveedor entities
     * that are retrieved from PproPersona?cap_first and returns the navigation
     * outcome.
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
