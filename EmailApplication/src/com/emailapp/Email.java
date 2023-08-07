package com.emailapp;

import java.util.*;
import java.io.*;
public class Email {
    public Scanner s = new Scanner(System.in);
    String firstName,lastName,dept,email,password,alterEmail;
    int mailCapacity = 500;

    //Constructor to receive First Name and Last Name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee : "+this.firstName+" "+this.lastName);

        //calling methods
        this.dept = this.SetDept(); // Department
        this.password = this.GeneratePassword(8); // Password
        this.email = this.GenerateEmail(); // Email Generation
    }

    //Asking Dept
    String SetDept(){
        System.out.println("Department code: \n1 for Sales \n2 for Development \n3 for Accounting \n4 for None");
        boolean flag = true;
        do {
            System.out.println("Enter Department Code : ");
            int choice = s.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 4:
                    return "None";
                default:
                    System.out.println("INVALID CHOICE please choose again...");
            }
        }while (!flag);
        return null;
    }

    //Generate Email method
    String GenerateEmail(){
        return this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }

    //Generate Password method
    String GeneratePassword(int length){
        Random r = new Random();
        String CapitalChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SmallChar = "abcdefghijklmnopqrstuvwxyz";
        String Numbers = "0123456789";
        String Symbols = "!@#$?&";
        String values = CapitalChar+SmallChar+Symbols+Numbers;
        String pass = "";
        for(int i=0;i<length;i++){
            pass += values.charAt(r.nextInt(values.length()));
        }
        return pass;
    }

    //Change Password method
    public void changePassword(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password? (Y/N) : ");
            char choice = s.next().charAt(0);
            if(choice=='Y' || choice =='y'){
                flag = true;
                System.out.println("Enter Current Password : ");
                String temp = s.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new Password : ");
                    this.password = s.next();
                    System.out.println("Password Changed Successfully!!");
                }
                else{
                    System.out.println("Incorrect Password!");
                }
            }
            else if (choice=='N' || choice =='n') {
                flag = true;
                System.out.println("Password is unchanged");
            }
            else{
                System.out.println("Enter a Valid Choice!!");
            }
        }while(!flag);
    }

    //Set mailbox capacity Method
    public void set_MailCap(){
        System.out.println("Current Capacity = "+this.mailCapacity+"MB");
        System.out.println("Enter new MailBox Capacity : ");
        this.mailCapacity = s.nextInt();
        System.out.println("MailBox Capacity Successfully Changed!!");
    }

    //Set Alternate mail
    public void alternateEmail(){
        System.out.println("Enter new Alternate Email : ");
        this.alterEmail = s.next();
        System.out.println("Alternate Email is Set");
    }

    //Display User Information method
    public void getInfo(){
        System.out.println("Name : "+this.firstName+" "+this.lastName);
        System.out.println("Department : "+this.dept);
        System.out.println("Email : "+this.email);
        System.out.println("Password(*for testing) : "+this.password);
        System.out.println("Mailbox Capacity : "+this.mailCapacity+"MB");
        System.out.println("Alternative Email : "+this.alterEmail);
    }

    //Store in File
    public void storefile(){
        try{
            FileWriter in = new FileWriter("./UserInfo.txt");
            in.write("First Name : "+this.firstName);
            in.append("\nLast Name : "+this.lastName);
            in.append("\nEmail : "+this.email);
            in.append("\nPassword : "+this.password);
            in.append("\nCapacity : "+this.mailCapacity);
            in.append("\nAlternative Email : "+this.alterEmail);
            in.close();
            System.out.println("----------Data Stored in UserInfo----------");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Reading file method
    public void readfile(){
        System.out.println("Opening UserInfo...");
        try {
            FileReader f1 = new FileReader("./UserInfo.txt");
            int i;
            while((i= f1.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println();
            f1.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
