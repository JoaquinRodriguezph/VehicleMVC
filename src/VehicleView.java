import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VehicleView {
    private JFrame mainframe;
    private JLabel choiceLbl, startingPointLbl, endingPointLbl, feedbackLbl;
    private JTextField chooseTf, spTf, epTf;
    private JButton addBtn, viewBtn;
    public VehicleView(){
        this.mainframe = new JFrame("Vehicle Fare Simulator");
        this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainframe.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainframe.setSize(250, 400);

        this.startingPointLbl = new JLabel();
        this.endingPointLbl = new JLabel();
        this.feedbackLbl = new JLabel();
        this.chooseTf = new JTextField();
        this.spTf = new JTextField();
        this.epTf = new JTextField();

        chooseVehicle();
        setPoints();

        this.addBtn = new JButton("Add");
        this.addBtn.setPreferredSize(new Dimension(220, 30));

        this.mainframe.add(addBtn);
        this.mainframe.add(feedbackLbl);
        this.mainframe.setVisible(true);
    }

    public void chooseVehicle(){
        this.choiceLbl = new JLabel("<html>Choose!<br/>1 - Bus <br/>2 - Jeepney <br/>3 - Helicopter</html>");
        this.mainframe.add(choiceLbl);
        chooseTf.setColumns(10);
        this.mainframe.add(chooseTf);
    }
    public void setPoints(){
        startingPointLbl.setText("Starting Point: ");
        endingPointLbl.setText("Ending Point: ");

        this.mainframe.add(startingPointLbl);
        spTf.setColumns(10);
        this.mainframe.add(spTf);
        this.mainframe.add(endingPointLbl);
        epTf.setColumns(10);
        this.mainframe.add(epTf);
    }
    public void setAddBtnListener(ActionListener actionListener){this.addBtn.addActionListener(actionListener);}
    public void setViewBtnListener(ActionListener actionListener){this.viewBtn.addActionListener(actionListener);}

    public void setFeedbackLblText(String text){this.feedbackLbl.setText(text);}
    public String getChooseTfText(){return this.chooseTf.getText();}

    public String getSPTfText(){return this.spTf.getText();}

    public String getEPTfText(){return this.epTf.getText();}

    public void clearTextFields(){
        this.chooseTf.setText("");
        this.spTf.setText("");
        this.epTf.setText("");
    }
}
