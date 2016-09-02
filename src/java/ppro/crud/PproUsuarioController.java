package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproUsuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproUsuarioController")
@ViewScoped
public class PproUsuarioController extends AbstractController<PproUsuario> {

    @Inject
    private PproPersonaController usuPerIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproUsuarioController() {
        // Inform the Abstract parent controller of the concrete PproUsuario Entity
        super(PproUsuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        usuPerIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PproPersona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuPerId(ActionEvent event) {
        if (this.getSelected() != null && usuPerIdController.getSelected() == null) {
            usuPerIdController.setSelected(this.getSelected().getUsuPerId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of PproDocumento entities
     * that are retrieved from PproUsuario?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of PproDocumento entities
     * that are retrieved from PproUsuario?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PproDocumento page
     */
    public String navigatePproDocumentoCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproDocumento_items", this.getSelected().getPproDocumentoCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproDocumento/index";
    }

    /**
     * Sets the "items" attribute with a collection of PproDocumento entities
     * that are retrieved from PproUsuario?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PproDocumento page
     */
    public String navigatePproDocumentoCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproDocumento_items", this.getSelected().getPproDocumentoCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproDocumento/index";
    }

    /**
     * Sets the "items" attribute with a collection of PproRelUsuarioPerfil
     * entities that are retrieved from PproUsuario?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PproRelUsuarioPerfil page
     */
    public String navigatePproRelUsuarioPerfilCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproRelUsuarioPerfil_items", this.getSelected().getPproRelUsuarioPerfilCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproRelUsuarioPerfil/index";
    }

}
