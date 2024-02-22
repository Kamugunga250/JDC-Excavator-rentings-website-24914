package Introduction;
import java.util.*;
import java.sql.*;
/**
 *
 * @author VIANNA
 */
public class StudentMGTSystem {
    public static void main(String[] args){
        // variable declaration
        boolean condition = true;
        String studentId;
        String names;
        int age;
        String jdbcURL = "jdbc:mysql://localhost:3306/studentsmgt_db";
        String dbUsername = "root";
        String dbPassword = "";
        while(condition){
            System.out.println("=============================");
            System.out.println("STUDENT MGT SYSTEM");
            System.out.println("----------------------");
            System.out.println("1. Record Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Find a Student");
            System.out.println("5. Select all Students");
            System.out.println("0. Exit");
            System.out.println("-------------------");
            System.out.println("Choose: ");
            int choice;
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Student ID: ");
                    studentId = input.next();
                    System.out.print("Enter Student names: ");
                    names = input.next();
                    System.out.print("Enter Student ages: ");
                    age = input.nextInt();
                    try{
                        //Load and Register Driver
                        //Class.forName("com.mysql.cj.jdbc.Driver");
                        //Create Connection
                        Connection con = DriverManager.getConnection(jdbcURL,dbUsername,dbPassword);
                        //Create Statement
                        Statement st = con.createStatement();
                        //Execute Statement
                        String sql = "INSERT INTO students (student_id,names,age) values ('"+studentId+"','"+names+"',"+age+")";
//                        boolean is Saved = st.execute(sql);
//                        if(isSaved){
//                            System.out.println("Data saved successfully");
//                        }else{
//                            System.out.println("Data not saved");
//                        }
                        int row = st.executeUpdate(sql);
                        if(row > 0){
                            System.out.println("Data has been saved successfully");
                        }else{
                            System.out.println("Data save has been failed");
                        }
                        System.out.println("Do you wish to contue? Enter Yes or No to quit");
                        String answer = input.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition = true;
                        }else{
                            condition = false;
                        }
                        con.close();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentId = input.next();
                    System.out.print("Enter Student names: ");
                    names = input.next();
                    System.out.print("Enter Student ages: ");
                    age = input.nextInt();
                    try{
                        Connection con = DriverManager.getConnection(jdbcURL,dbUsername,dbPassword);
                        Statement st = con.createStatement();
                        String sql = "UPDATE students SET names = '"+names+"',age = "+age+" WHERE student_id = '"+studentId+"'";
                        int row = st.executeUpdate(sql);
                        if(row > 0){
                            System.out.println("The record updated successfully");
                        }else{
                            System.out.println("The record update has been failed");
                        }
                        System.out.println("Do you wish to contue? Enter Yes or No to quit");
                        String answer = input.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition = true;
                        }else{
                            condition = false;
                        }
                        con.close();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentId = input.next();
                    try{
                        Connection con = DriverManager.getConnection(jdbcURL,dbUsername,dbPassword);
                        Statement st = con.createStatement();
                        String sql = "DELETE FROM students WHERE student_id = '"+studentId+"'";
                        int row = st.executeUpdate(sql);
                        if(row > 0){
                            System.out.println("The record deleted successfully");
                        }else{
                            System.out.println("The record deletion has been failed");
                        }
                        System.out.println("Do you wish to contue? Enter Yes or No to quit");
                        String answer = input.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition = true;
                        }else{
                            condition = false;
                        }
                        con.close();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Find a Student Selected");
                    break;
                case 5:
                    System.out.println("Select all Students Selected");
                    break;
                case 0:
                    System.out.println("Thank you for using the system!");
                    System.exit(0);
                default:
                    System.out.println("Wrong choice, do you wish to continue? please type Yes or No to quit");
            }
        }
    }
}
