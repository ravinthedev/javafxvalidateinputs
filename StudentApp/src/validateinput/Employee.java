package validateinput;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author admin
 */
public class Employee {
   
   private String EmpNum; 
   private String Department;
   private String EmpName;
   private String EmpType;
    
    

    public String Validate(String EmpNo, String EName) 
    
    {

    if (!Pattern.matches("EMP[0-9]{3}?", EmpNo))

      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Employee Number");
        alert.setContentText("Employee number should be EMP followed by 3 digits");
        alert.showAndWait();
        return "invalid";
      }

    else if (!Pattern.matches("^[a-zA-Z0-9]+$", EName))

      {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Employee Name");
        alert.setContentText("Please Enter a Valid Value for First Name");
        alert.showAndWait();
        return "invalid";
      }

    else
      {
        return "valid";        
      }
     
    }
    
    

    
    
    public  String GetEmpName(String Ename)
    {
    this.EmpName =  Ename;  
    return (EmpName);
    }
    
    public  String GetDept(String Dept)
    {
    this.Department =  Dept;  
    return (Department);
    }
    
    public  String GetEtype(String Etype)
    {
    this.EmpType =  Etype;  
    return (EmpType);
    
    }
    
    
public ArrayList<String> GetEmpDetails( String Enum, String Ename, String Dept, String Etype)
{    
   
    this.EmpNum = Enum;
    this.EmpName =  Ename;  
    this.Department =  Dept;  
    this.EmpType =  Etype;  

    ArrayList<String> EmpDetails = new ArrayList<String>();       

EmpDetails.add(this.EmpNum);
EmpDetails.add(EmpName);
EmpDetails.add(Department);    
EmpDetails.add(EmpType);



return (EmpDetails);

}


}
