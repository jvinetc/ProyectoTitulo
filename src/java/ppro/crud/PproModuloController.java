package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproModulo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproModuloController")
@ViewScoped
public class PproModuloController extends AbstractController<PproModulo> {

    @Inject
    private MobilePageController mobilePageController;

    public PproModuloController() {
        // Inform the Abstract parent controller of the concrete PproModulo Entity
        super(PproModulo.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproModuloPerfil entities
     * that are retrieved from PproModulo?cap_first and returns the navigation
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

}
