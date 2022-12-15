import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
public class CarGUI extends JFrame {
    public CarGUI(){
        setTitle("Car Rental");
        setSize(600,400);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ArrayList<JRadioButton> carRadioButtons=createButtons();
        JTextField inputModel=createinputModel();
        createButton(carRadioButtons,inputModel);
    }
    private void showSelection(ArrayList<JRadioButton>carRadioButtons,JTextField model){
        String showSelectionMessage="";
        for(JRadioButton radio:carRadioButtons){
            if(radio.isSelected())
                showSelectionMessage="You chose the type of car " + radio.getText() + " " + model.getText()+"."
                        +"Click OK to proceed further!";

        }
        if(showSelectionMessage== ""){
            showSelectionMessage="Please make a choice!";
        }
        JOptionPane.showMessageDialog(this,showSelectionMessage);
    }
    private void createButton(ArrayList<JRadioButton>carRadioButtons,JTextField inputModel) {
        JButton button=new JButton("Show");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                showSelection(carRadioButtons,inputModel);
            }
        });
        add(button);
    }
    private JTextField createinputModel() {
        JLabel labelModel=new JLabel("Model: ");
        JTextField inputModel=new JTextField(15);
        add(labelModel);
        add(inputModel);
        return inputModel;
    }
    private ArrayList<JRadioButton> createButtons (){
        JRadioButton AudiRadio=new JRadioButton("Audi");
        JRadioButton BenzRadio=new JRadioButton("Benz");
        JRadioButton GolfRadio=new JRadioButton("Golf");
        JRadioButton RangeRadio=new JRadioButton("Range");
        add(AudiRadio);
        add(BenzRadio);
        add(GolfRadio);
        add(RangeRadio);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(AudiRadio);
        buttonGroup.add(BenzRadio);
        buttonGroup.add(GolfRadio);
        buttonGroup.add(RangeRadio);

        return new ArrayList<JRadioButton>(Arrays.asList(AudiRadio,RangeRadio,BenzRadio,GolfRadio));
    }
    public static void main(String[] args) {
        CarGUI carGui=new CarGUI();
        carGui.setVisible(true);
    }
}
