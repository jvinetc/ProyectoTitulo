package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproAnexoDocumento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproAnexoDocumentoController")
@ViewScoped
public class PproAnexoDocumentoController extends AbstractController<PproAnexoDocumento> {

    @Inject
    private PproDocumentoController aneDocIdController;
    @Inject
    private PproTipoAnexoController aneTanIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproAnexoDocumentoController() {
        // Inform the Abstract parent controller of the concrete PproAnexoDocumento Entity
        super(PproAnexoDocumento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        aneDocIdController.setSelected(null);
        aneTanIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PproDocumento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAneDocId(ActionEvent event) {
        if (this.getSelected() != null && aneDocIdController.getSelected() == null) {
            aneDocIdController.setSelected(this.getSelected().getAneDocId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproTipoAnexo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAneTanId(ActionEvent event) {
        if (this.getSelected() != null && aneTanIdController.getSelected() == null) {
            aneTanIdController.setSelected(this.getSelected().getAneTanId());
        }
    }
}
