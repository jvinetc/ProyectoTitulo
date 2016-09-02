package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproRelPerfilMenu;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproRelPerfilMenuController")
@ViewScoped
public class PproRelPerfilMenuController extends AbstractController<PproRelPerfilMenu> {

    @Inject
    private PproPerfilController rpmPerfIdController;
    @Inject
    private PproMenuController rpmMenIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproRelPerfilMenuController() {
        // Inform the Abstract parent controller of the concrete PproRelPerfilMenu Entity
        super(PproRelPerfilMenu.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        rpmPerfIdController.setSelected(null);
        rpmMenIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PproPerfil controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRpmPerfId(ActionEvent event) {
        if (this.getSelected() != null && rpmPerfIdController.getSelected() == null) {
            rpmPerfIdController.setSelected(this.getSelected().getRpmPerfId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproMenu controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRpmMenId(ActionEvent event) {
        if (this.getSelected() != null && rpmMenIdController.getSelected() == null) {
            rpmMenIdController.setSelected(this.getSelected().getRpmMenId());
        }
    }
}
