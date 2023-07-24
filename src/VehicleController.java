import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleController {
    private VehicleView vehicleView;
    private VehicleModel vehicleModel;

    public VehicleController(VehicleView vehicleView, VehicleModel vehicleModel){
        this.vehicleView = vehicleView;
        this.vehicleModel = vehicleModel;

        this.vehicleView.setAddBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = vehicleView.getChooseTfText();
                String startpoint = vehicleView.getSPTfText();
                String endpoint = vehicleView.getEPTfText();

                boolean result = vehicleModel.addVehicle(startpoint, endpoint, choice);
                if (result){
                    vehicleView.setFeedbackLblText("Vehicle successfully added!");
                    vehicleView.clearTextFields();
                } else {
                    vehicleView.setFeedbackLblText("Adding failed :( ");
                }
            }
        });
    }
}
