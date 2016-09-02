package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproTipoDocumento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproTipoDocumentoController")
@ViewScoped
public class PproTipoDocumentoController extends AbstractController<PproTipoDocumento> {

    @Inject
    private MobilePageController mobilePageController;

    public PproTipoDocumentoController() {
        // Inform the Abstract parent controller of the concrete PproTipoDocumento Entity
        super(PproTipoDocumento.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproDocumento entities
     * that are retrieved from PproTipoDocumento?cap_first and returns the
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

}
