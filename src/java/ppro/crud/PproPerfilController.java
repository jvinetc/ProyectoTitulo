package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproPerfil;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproPerfilController")
@ViewScoped
public class PproPerfilController extends AbstractController<PproPerfil> {

    @Inject
    private MobilePageController mobilePageController;

    public PproPerfilController() {
        // Inform the Abstract parent controller of the concrete PproPerfil Entity
        super(PproPerfil.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproModuloPerfil entities
     * that are retrieved from PproPerfil?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PproModuloPerfil page
     */
    public String navigatePproModuloPerfilCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproModuloPerfil_items", this.getSelected().getPproModuloPerfilCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproModuloPerfil/index";
    }

    /**
     * Sets the "items" attribute with a collection of PproRelUsuarioPerfil
     * entities that are retrieved from PproPerfil?cap_first and returns the
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

    /**
     * Sets the "items" attribute with a collection of PproRelPerfilMenu
     * entities that are retrieved from PproPerfil?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PproRelPerfilMenu page
     */
    public String navigatePproRelPerfilMenuCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproRelPerfilMenu_items", this.getSelected().getPproRelPerfilMenuCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproRelPerfilMenu/index";
    }

}
