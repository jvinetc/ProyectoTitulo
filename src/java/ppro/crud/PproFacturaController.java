package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproFactura;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproFacturaController")
@ViewScoped
public class PproFacturaController extends AbstractController<PproFactura> {

    @Inject
    private PproDocumentoController facDocIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproFacturaController() {
        // Inform the Abstract parent controller of the concrete PproFactura Entity
        super(PproFactura.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        facDocIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PproDocumento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFacDocId(ActionEvent event) {
        if (this.getSelected() != null && facDocIdController.getSelected() == null) {
            facDocIdController.setSelected(this.getSelected().getFacDocId());
        }
    }
}
