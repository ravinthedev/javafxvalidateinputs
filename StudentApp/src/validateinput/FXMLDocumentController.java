package validateinput;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController implements Initializable {
    
    @FXML private Label EmpNameOut;
    @FXML private TextField EmpName;
    @FXML private Button button;  
    @FXML private Label DeptNameOut;
    @FXML private ToggleGroup Department;
    
    @FXML private ChoiceBox EmpType;
    @FXML private Label EmpTypeOut;
    
    @FXML private TextField EmpNo;
    @FXML private Label EmpNoOut;
    
    
    public void ClearLabels(){  
      
      EmpNameOut.setText("");
      DeptNameOut.setText("");
      EmpTypeOut.setText("");
      EmpNoOut.setText("");
      }
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
      
        ClearLabels();
        
        String Ename = EmpName.getText().toString();
       
        
        String ENo = EmpNo.getText().toString();
        RadioButton selectedRadioButton = (RadioButton) Department.getSelectedToggle();
        String Dept = selectedRadioButton.getText();
        String Etype = EmpType.getValue().toString();
       
        Employee emp = new Employee();
    
String status =   emp.Validate(ENo, Ename);

if(status == "valid")
{ 
        ArrayList<String> EmpDetails = emp.GetEmpDetails (ENo, Ename, Dept, Etype);  
             
     EmpNameOut.setText((EmpDetails.get(0)));
      
      
      DeptNameOut.setText((EmpDetails.get(1)));
      EmpTypeOut.setText((EmpDetails.get(2)));
      EmpNoOut.setText((EmpDetails.get(3)));
} 

else {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Validation Errors Detected");
        alert.setContentText("Please fix Validation Errors before continuing");
        alert.showAndWait();
}

}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

EmpType.getItems().addAll("Permanent", "Contract", "Part Time" );
    }   
}
