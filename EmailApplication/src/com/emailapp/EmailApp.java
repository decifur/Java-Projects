package com.emailapp;
import java.util.*;
public class EmailApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // User Info
        System.out.println("Enter First Name : ");
        String f_name = s.next();
        System.out.println("Enter Last Name : ");
        String l_name = s.next();

        //creating  object for Email class
        Email em1 = new Email(f_name,l_name);
        int choice = -1;
        do{
            System.out.println("\n********************\nEnter your Choice : \n1. Show Info\n2. Change Password" +
                    "\n3. Change MailBox Capacity\n4. Set Alternative Mail\n5. Store Data in File" +
                    "\n6. Display Data from File\n7. EXIT");
            choice = s.nextInt();
            switch(choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.changePassword();
                    break;
                case 3:
                    em1.set_MailCap();
                    break;
                case 4:
                    em1.alternateEmail();
                    break;
                case 5:
                    em1.storefile();
                    break;
                case 6:
                    em1.readfile();
                    break;
                case 7:
                    System.out.println("Thankyou For Using Application :) ");
                    break;
                default:
                    System.out.println("INVALID CHOICE !!\nEnter a Valid Choice...");
            }
        }while (choice!=7);
    }
}
