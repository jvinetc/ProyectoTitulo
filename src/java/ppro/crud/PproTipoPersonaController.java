package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproTipoPersona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproTipoPersonaController")
@ViewScoped
public class PproTipoPersonaController extends AbstractController<PproTipoPersona> {

    @Inject
    private MobilePageController mobilePageController;

    public PproTipoPersonaController() {
        // Inform the Abstract parent controller of the concrete PproTipoPersona Entity
        super(PproTipoPersona.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproPersona entities that
     * are retrieved from PproTipoPersona?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PproPersona page
     */
    public String navigatePproPersonaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproPersona_items", this.getSelected().getPproPersonaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproPersona/index";
    }

}
