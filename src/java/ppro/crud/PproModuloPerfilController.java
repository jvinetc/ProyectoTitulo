package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproModuloPerfil;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproModuloPerfilController")
@ViewScoped
public class PproModuloPerfilController extends AbstractController<PproModuloPerfil> {

    @Inject
    private PproModuloController rmodModIdController;
    @Inject
    private PproPerfilController rmodPerfIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproModuloPerfilController() {
        // Inform the Abstract parent controller of the concrete PproModuloPerfil Entity
        super(PproModuloPerfil.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        rmodModIdController.setSelected(null);
        rmodPerfIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PproModulo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRmodModId(ActionEvent event) {
        if (this.getSelected() != null && rmodModIdController.getSelected() == null) {
            rmodModIdController.setSelected(this.getSelected().getRmodModId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproPerfil controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRmodPerfId(ActionEvent event) {
        if (this.getSelected() != null && rmodPerfIdController.getSelected() == null) {
            rmodPerfIdController.setSelected(this.getSelected().getRmodPerfId());
        }
    }
}
