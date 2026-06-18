
package javaapplication9;

import java.sql.SQLException;
import java.util.Scanner;


public class JavaApplication9 {

  
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        
        Database d = new Database();
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
       
        do{
            System.out.println("\n1.Insert");
            System.out.println("2.Display");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.Exit");
            System.out.print("Option: ");
            int option = sc.nextInt();
            
            switch(option){
                
                case 1:{
                    d.insert();
                    break;
                }
                case 2:{
                    d.display();
                    break;
                }
                
                case 3:{
                    d.update();
                    break;
                }
                case 4:{
                    d.delete();
                    break;
                }
                
                case 5:{
                    System.out.println("Exiting...");
                    exit = false;
                    break;
                }
                
                default:{
                    System.out.println("Invalid choice!");
                }
            }
            
            
        }while(exit);
        
    }
    
}
