
package javaapplication13;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class JavaApplication13 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        
        boolean exit = true;
        
        do{
            System.out.println("\n1.Insert Student");
            System.out.println("2.View All Students");
            System.out.println("3.Update Student by ID");
            System.out.println("4.Delete Student by ID");
            System.out.println("5.Search Student by Email");
            System.out.println("6.Exit");
            System.out.print("Option: ");
            int option= sc.nextInt();
            sc.nextLine();
            
            
            switch(option){
                case 1:{
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String mail = sc.nextLine();
                    System.out.print("Enter course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Fee: ");
                    double fee = sc.nextDouble();
                    
                    StudentModal modal = new StudentModal(name,mail,course,fee);
                    service.insertStudent(modal);
                    break;
                }
                case 2:{
                    ArrayList<StudentModal> m = service.viewAll();
                    
                    System.out.println("\nID\tname\t"+"\temail"+"\t"+"\tcourse"+"\tfee");
                    for(StudentModal s:m){
                        System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+s.getMail()+"\t"+s.getCourse()+"\t"+s.getFee());
                    }
                    break;
                }
                case 3:{
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter New Mail: ");
                    String mail = sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter New Fee: ");
                    double fee = sc.nextDouble();
                    
                    StudentModal modal = new StudentModal(id,name,mail,course,fee);
                    service.updateStudent(modal);
                    break;
                }
                case 4:{
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    
                    service.deleteStudent(id);
                    break;
                }
                case 5:{
                    System.out.print("Enter mail Id: ");
                    String mail = sc.next();
                    
                    service.searchStudent(mail);
                    break;
                }
                case 6:{
                    System.out.print("Exiting...");
                    exit = false;
                    break;
                }
                default:{
                    System.out.println("Invalid Option");
                }
            }
            
        }while(exit);
    }
    
}
