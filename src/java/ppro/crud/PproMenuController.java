package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproMenu;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproMenuController")
@ViewScoped
public class PproMenuController extends AbstractController<PproMenu> {

    @Inject
    private MobilePageController mobilePageController;

    public PproMenuController() {
        // Inform the Abstract parent controller of the concrete PproMenu Entity
        super(PproMenu.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproRelPerfilMenu
     * entities that are retrieved from PproMenu?cap_first and returns the
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
