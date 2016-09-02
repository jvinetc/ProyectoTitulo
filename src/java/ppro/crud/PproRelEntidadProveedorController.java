package ppro.crud;

import ppro.crud.util.MobilePageController;
import ppro.modelo.PproRelEntidadProveedor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pproRelEntidadProveedorController")
@ViewScoped
public class PproRelEntidadProveedorController extends AbstractController<PproRelEntidadProveedor> {

    @Inject
    private PproProveedorController repProvIdController;
    @Inject
    private PproEntidadFinancieraController repEntFinIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PproRelEntidadProveedorController() {
        // Inform the Abstract parent controller of the concrete PproRelEntidadProveedor Entity
        super(PproRelEntidadProveedor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        repProvIdController.setSelected(null);
        repEntFinIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PproProveedor controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRepProvId(ActionEvent event) {
        if (this.getSelected() != null && repProvIdController.getSelected() == null) {
            repProvIdController.setSelected(this.getSelected().getRepProvId());
        }
    }

    /**
     * Sets the "selected" attribute of the PproEntidadFinanciera controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRepEntFinId(ActionEvent event) {
        if (this.getSelected() != null && repEntFinIdController.getSelected() == null) {
            repEntFinIdController.setSelected(this.getSelected().getRepEntFinId());
        }
    }
}
