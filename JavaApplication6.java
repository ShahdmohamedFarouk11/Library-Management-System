/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication6;
import java.util.Scanner;
public class JavaApplication6 {
    public static void main(String[] args) {
    
      Scanner scan=new Scanner(System.in);
		System.out.print("Enter the number of books you have: ");
		int num=scan.nextInt();
		 int[] count=new int[num];
		 String [] bookname= new String [num];
		 String[] bookdescription=new String [num];
		 boolean[]bookissued=new boolean [num];
		 int choice;
                 String avalibility;
                 int i;
		 do{  System.out.println("--------Welcome to the Library Managemant System---------");
        System.out.println("1-Add a Book\n2-Search  for a Book by( ID or Title)\n3-Issue a Book (byID)\n4-Return a Book (by ID)\n5-Delete a Book ( by ID) \n6-Edit Book Details (Title/Description by ID)\n7-View All Books\n8-Exit");
        System.out.print("Enter your choice:");
        choice=scan.nextInt();
        switch(choice){
        case 1:
       boolean add=false;
        for(i=0;i<num;i++){
            if(bookname[i]==null){
        System.out.println("Enter the  title of  the book "+(i+1)+" : ");
        bookname[i]=scan.next();
        System.out.println("Enter the description of thr book "+(i+1)+" : ");
         bookdescription[i]=scan.next();
        bookissued[i]=false; 
        add=true;
        count[i]=i+1;
     }
        }
      if(add!=true){
     System.out.println("------+Error! No space available to add a new book+------");
      }else{
          System.out.println("----+books added successfuly+----");
      }
      break;
     case 2:
                    System.out.println("Choose search method:\n1-ID\n2-Title");
                    int method=scan.nextInt();
                    if(method==1){
                    System.out.println("Enter book ID: ");
                    int id =scan.nextInt();
                    if((id>0)&&id<=num){
                          int index=id-1;
                          if(bookissued[index]==false){
                             avalibility="avalaiable";
                          }else{ 
                             avalibility="unavalaiable";}
                          System.out.println("Book Title: "+ bookname[index]);
                          System.out.println("Book description: "+ bookdescription[index]);
                          System.out.println("Book state: "+ avalibility);
                    }else{
                    System.out.println("Invalid ID");
                    }
                    }
                else if (method == 2) {
            System.out.println("Enter the book title: ");
            String title = scan.next();
            boolean found = false;
            for (i = 0; i < num; i++) {
                if (bookname[i] != null && bookname[i].equalsIgnoreCase(title)) {
                     if(bookissued[i]==false){
                             avalibility="avalaiable";
                          }else{ 
                             avalibility="unavalaiable";}
                    System.out.println("Book Title: " + bookname[i]);
                    System.out.println("Book description: " + bookdescription[i]);
                    System.out.println("Book state: " + avalibility);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid title");
            }
        }
        break;
      case 3:
          System.out.println("Enter book ID: ");
          int id=scan.nextInt();
          if (id>0 && id<=num){
          int index= id-1;
            if(!bookissued[index]){
                bookissued[index]=true;
                System.out.println("Book issued successfully!!");
            }else{
                System.out.println("Book is already issued!!");
            }
          }else{
              System.out.println("Invalid ID!!");
          }
          break;
      case 4:
          System.out.println("Enter book ID to return: ");
           id=scan.nextInt();
           if (id>0 && id<=num){
               int index=id-1;
               if(bookissued[index]){
                   bookissued[index]=false;
                   System.out.println("Book is returned successfully!!");
               }else{
                   System.out.println("Book is already here!!");
               }
           }else{
               System.out.println("Invalid id!!");
           }
           break;
     case 5:
           
            System.out.println("Enter book ID to delete: ");
            id = scan.nextInt();
            if (id > 0 && id <= num) {
                int index = id - 1;
                for (int x = index; x < num - 1; x++) {
                    bookname[x] = bookname[x + 1];
                    bookdescription[x] = bookdescription[x + 1];
                    bookissued[x] = bookissued[x + 1];
                }
                bookname[num - 1] = null;
                bookdescription[num - 1] = null;
                bookissued[num - 1] = false;
                System.out.println("Book deleted successfully!!");
            } else {
                System.out.println("Invalid ID!!");
            }
            break;
      case 6:
          System.out.println("Enter book ID: ");
          id=scan.nextInt();
          if (id>0 && id<=num){
          int index=id-1;
              System.out.println("Choose a method to edit:\n 1-Book Title\n 2-Book Description ");
              int edit=scan.nextInt();
              scan.nextLine();
              if (edit==1){
                  System.out.println("Enter new title: ");
                 String T=scan.nextLine();
                 bookname[index]=T;
                  System.out.println("Book Title updated successfully!!");
              }else if(edit==2){
                  System.out.println("Enter new description: ");
                  String D =scan.nextLine();
                  bookdescription[index]=D;
                  System.out.println("Description updated successfully!!");
              }else {
                  System.out.println("Invalid choice!!");
              }
          }else {
              System.out.println("Invalid ID!!");
          }
          break;
      case 7:
            System.out.println("count\tBook title\tBookdescriptions\tAvailability");
               for(i=0;i<num;i++){
             if(bookname[i] !=null){
                 if(bookissued[i]==false)
                     avalibility="avalaiable";
                 else 
                     avalibility="unavalaiable";
             System.out.println("---------------------------------------------------------");
                                 System.out.println( count[i]+"\t"+bookname[i]+" \t\t"+bookdescription[i]+"\t \t"+avalibility);
              }
               }break;
     case 8:
         System.out.println("Thank You!!");
         break;
     default:
         System.out.println("invalid choice");
         break;
                 }
                 
                 }while(choice!=8);
		 
      }

}
    
    

