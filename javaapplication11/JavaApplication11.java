
package javaapplication11;

import java.sql.SQLException;
import java.util.Scanner;


public class JavaApplication11 {

  
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Scanner sc = new Scanner(System.in);
        
        StudentsService ss = new StudentsService();
        
        boolean exit = true;
    do{    
        System.out.println("\n1.Insert");
        System.out.println("2.View All Students");
        System.out.println("3.Update Student by ID");
        System.out.println("4.Delete Student by ID");
        System.out.println("5.Search Student by Email");
         System.out.println("6.Exiting");
        System.out.print("Option: ");
        int option = sc.nextInt();
        sc.nextLine();
        
        switch(option){
            case 1:{
               
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
//                sc.nextLine();
      
                System.out.print("Enter mail ID: ");
                String mail = sc.nextLine();
                
                System.out.print("Enter course: ");
                String cname = sc.nextLine();
                
                System.out.print("Enter fees: ");
                double fee = sc.nextDouble();
                
                StudentsModal sm = new StudentsModal(name,mail,cname,fee);
                
                ss.addStudents(sm);
                
                break;
            }
            
            case 2:{
                ss.viewStudentDetails();
                break;
            }
            case 3:{
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
         
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
      
                System.out.print("Enter New mailID: ");
                String mail = sc.nextLine();
                
                System.out.print("Enter New course: ");
                String cname = sc.nextLine();
                
                System.out.print("Enter New fees: ");
                double fee = sc.nextDouble();
                
                StudentsModal update = new StudentsModal(id,name,mail,cname,fee);
                
                ss.updateStudent(update);
                break;
            }
            
            case 4:{
                System.out.print("Enter Id: ");
                int id = sc.nextInt();
                
                ss.deleteStudent(id);
                break;
            }
            
            case 5:{
                System.out.print("Enter mailId: ");
                String mail = sc.nextLine();
                
                ss.searchStudent(mail);
                break;
            }
            case 6:{
                System.out.println("Exiting...");
                exit = false;
                break;
            }
            default:{
                System.out.println("Invalid optioin!");
            }
            
            
        }
        
    }while(exit);
        
    }
    
}
