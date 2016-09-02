package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproRelUsuarioPerfil;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproRelUsuarioPerfilController")
@ViewScoped
public class PproRelUsuarioPerfilController extends AbstractController<PproRelUsuarioPerfil> {

    @Inject
    private PproUsuarioController rupUsuIdController;
    @Inject
    private PproPerfilController rupPerfIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproRelUsuarioPerfilController() {
        // Inform the Abstract parent controller of the concrete PproRelUsuarioPerfil Entity
        super(PproRelUsuarioPerfil.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        rupUsuIdController.setSelected(null);
        rupPerfIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PproUsuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRupUsuId(ActionEvent event) {
        if (this.getSelected() != null && rupUsuIdController.getSelected() == null) {
            rupUsuIdController.setSelected(this.getSelected().getRupUsuId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproPerfil controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRupPerfId(ActionEvent event) {
        if (this.getSelected() != null && rupPerfIdController.getSelected() == null) {
            rupPerfIdController.setSelected(this.getSelected().getRupPerfId());
        }
    }
}
