package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproDocumento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproDocumentoController")
@ViewScoped
public class PproDocumentoController extends AbstractController<PproDocumento> {

    @Inject
    private PproTipoDocumentoController docTdocIdController;
    @Inject
    private PproUsuarioController docUsuIngresaController;
    @Inject
    private PproUsuarioController docUsuAutorizaController;
    @Inject
    private PproUsuarioController docUsuModificaController;
    @Inject
    private PproProveedorController docProvIdController;
    @Inject
    private PproEstadoDocumentoController docEdocIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproDocumentoController() {
        // Inform the Abstract parent controller of the concrete PproDocumento Entity
        super(PproDocumento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        docTdocIdController.setSelected(null);
        docUsuIngresaController.setSelected(null);
        docUsuAutorizaController.setSelected(null);
        docUsuModificaController.setSelected(null);
        docProvIdController.setSelected(null);
        docEdocIdController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PproAnexoDocumento
     * entities that are retrieved from PproDocumento?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PproAnexoDocumento page
     */
    public String navigatePproAnexoDocumentoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproAnexoDocumento_items", this.getSelected().getPproAnexoDocumentoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproAnexoDocumento/index";
    }

    /**
     * Sets the "selected" attribute of the PproTipoDocumento controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocTdocId(ActionEvent event) {
        if (this.getSelected() != null && docTdocIdController.getSelected() == null) {
            docTdocIdController.setSelected(this.getSelected().getDocTdocId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproUsuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocUsuIngresa(ActionEvent event) {
        if (this.getSelected() != null && docUsuIngresaController.getSelected() == null) {
            docUsuIngresaController.setSelected(this.getSelected().getDocUsuIngresa());
        }
    }

    /**
     * Sets the "selected" attribute of the PproUsuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocUsuAutoriza(ActionEvent event) {
        if (this.getSelected() != null && docUsuAutorizaController.getSelected() == null) {
            docUsuAutorizaController.setSelected(this.getSelected().getDocUsuAutoriza());
        }
    }

    /**
     * Sets the "selected" attribute of the PproUsuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocUsuModifica(ActionEvent event) {
        if (this.getSelected() != null && docUsuModificaController.getSelected() == null) {
            docUsuModificaController.setSelected(this.getSelected().getDocUsuModifica());
        }
    }

    /**
     * Sets the "selected" attribute of the PproProveedor controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocProvId(ActionEvent event) {
        if (this.getSelected() != null && docProvIdController.getSelected() == null) {
            docProvIdController.setSelected(this.getSelected().getDocProvId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproEstadoDocumento controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocEdocId(ActionEvent event) {
        if (this.getSelected() != null && docEdocIdController.getSelected() == null) {
            docEdocIdController.setSelected(this.getSelected().getDocEdocId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of PproFactura entities that
     * are retrieved from PproDocumento?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PproFactura page
     */
    public String navigatePproFacturaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PproFactura_items", this.getSelected().getPproFacturaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/crud/pproFactura/index";
    }

}
