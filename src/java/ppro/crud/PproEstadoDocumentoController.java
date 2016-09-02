package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproEstadoDocumento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pproEstadoDocumentoController")
@ViewScoped
public class PproEstadoDocumentoController extends AbstractController<PproEstadoDocumento> {

    @Inject
    private MobilePageController mobilePageController;

    public PproEstadoDocumentoController() {
        // Inform the Abstract parent controller of the concrete PproEstadoDocumento Entity
        super(PproEstadoDocumento.class);
    }

    /**
     * Sets the "items" attribute with a collection of PproDocumento entities
     * that are retrieved from PproEstadoDocumento?cap_first and returns the
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
