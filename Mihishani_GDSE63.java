import java.util.*;
class Student{
   String id;
   String name;
   int prf;
   int dbms;
   double total;
   public Student(){
       this.id = null;
       this.name = null;
       this.prf = -1;
       this.dbms = -1;
       this.total = -1;
   }
   public void setID(String id){
       this.id = id;
   }
   public void setName(String name){
       this.name = name;
   }
   public void setPrfMarks(int prf){
       this.prf = prf;
   }
   public void setDbmsMarks(int dbms){
       this.dbms = dbms;
   }
   public String getIdName(int key){
       return (key==0)? id:name;
   }
   public int getMarks(int key){
       return (key==0)? prf:dbms;
   }
   public double getTotal(){
       return total=prf+dbms;
   }
}



class Mihishani_GDSE63{
   static Scanner input=new Scanner(System.in);
   static String op = " ";
   static Student[] stArray = new Student[0];

   public static boolean isExists(String key){
       for (int i = 0; i < stArray.length; i++){
           if(stArray[i].getIdName(0).equals(key))
               return false;
       }
       return true;
   }

   public static void increment(){
       Student [] temp = new Student[stArray.length+1];
       for (int i = 0; i < stArray.length; i++){
           temp [i] = stArray[i];
       }
       temp [stArray.length] = new Student();
       stArray = temp;
   }


   public final static void clearConsole(){
       try{
           final String os=System.getProperty("os.name");
           if (os.contains ("Window")){
               new ProcessBuilder("cmd" ,"/c","cls").inheritIO().start().waitFor();
           }else{
               System.out.print("\003[H\033[2J");
               System.out.flush();
           }
       }catch (final Exception e){
           e.printStackTrace();
       }
   }

   public static void updateMarks(){
       Scanner input=new Scanner(System.in);
       line();
       System.out.println("|         UPDATE MARKS           |");
       line();
       l1:
       do{
           System.out.print("Input Student ID: ");
           String id = input.next();
           if(!isExists(id)){
               System.out.print("Student name :  ");
               int key = printName(id);
               if(stArray[key].getMarks(0) != -1){
                   System.out.printf("Programming Fundamentals marks: %d\nDatabase MAnagement Systems marks: %d\n",stArray[key].getMarks(0),stArray[key].getMarks(1));
                   addMarks(key);
                   System.out.print("\nMarks added successfully. ");
               }else{
                   System.out.print("This student's marks yet to be added. ");
               }
           }else{
               System.out.println("\nInvalid Student ID");
               continue l1;
           }
           System.out.print("Do you want to add another student(Y/N): ");
           op = input.nextLine();
       }while(!op.equals("N") && !op.equals("n") );

   }

   public static void updateStudentDetails(){
       Scanner input=new Scanner(System.in);
       line();
       System.out.println("|        UPDATE STUDENT DETAILS          |");
       line();
       System.out.println();

       l1:
       do{
           System.out.print("\nInput Student ID: ");
           String id = input.nextLine();
           if(!isExists(id)){
               System.out.print("Student Name :  ");
               int key = printName(id);
               System.out.print("Enter the new student name : ");
               String newName = input.nextLine();  //assigning name
               stArray[key].setName(newName);
               System.out.print("Student details has been updated successfully. ");
           }else{
               System.out.println("Invalid Student ID. ");
           }
           System.out.print("Do you want to update another student details (Y/N): ");
           op = input.nextLine();
       }while(!op.equals("N") && !op.equals("n"));
   }

   public static void addMarks (){
       Scanner input=new Scanner(System.in);
       line();
       System.out.println("|           ADD  MARKS          |");
       line();
       l1:
       do{
           System.out.print("\nInput Student ID: ");
           String id = input.next();
           if(!isExists(id)){
               System.out.print("Student Name :  ");
               int key = printName(id);
               if(stArray[key].getMarks(0)!=-1){
                   System.out.println("Student Marks Already Added. ");
               }else{
                   addMarks(key);
                   System.out.println("Marks added succssfully. ");
               }
           }else{
               System.out.println("Invalid Student ID. ");
               continue l1;
           }
           System.out.print("\nDo you want to add another student(Y/N): ");
           op = input.next();
       }while(!op.equals("N") && !op.equals("n") );
   }

   public static int printName(String id){
       for (int i = 0; i < stArray.length; i++){
           if(stArray[i].getIdName(0).equals(id)){
               System.out.println(stArray[i].getIdName(1)+"\n");
               return i;
           }
       }
       return -1;
   }

   public static void addNewStudentWithMarks(){
       Scanner input=new Scanner(System.in);
       line();
       System.out.println("|        ADD NEW STUDENT WITH MARKS       |");
       line();
       System.out.println();

       do{
           int size = stArray.length;
           System.out.print("Input Student ID: ");
           String id = input.nextLine();
           if(isExists(id)){
               increment();
               stArray[stArray.length-1].setID(id);
               System.out.print("Input Student Name: ");
               stArray[stArray.length-1].setName(input.next());
               System.out.println(" ");
               addMarks(stArray.length-1);
               System.out.print("\nStudent succssfully added. ");
           }else{
               System.out.print("Student Already Exists. ");
           }
           System.out.print("Do you want to add another student(Y/N): ");
           op = input.next();
       }while(!op.equals("N") && !op.equals("n") );
   }

   public static void addMarks(int key){
       Scanner input=new Scanner(System.in);
       l1: while(true){
           System.out.print("Input Programming Fundamentals marks: ");
           int prf = input.nextInt();
           if(prf<=100 & prf>=0){
               stArray[key].setPrfMarks(prf);
               break  l1;
           }else{
               System.out.print("Invalid Marks. ");
               continue l1;
           }
       }
       l2: while(true){
           System.out.print("Input Database Management Systems marks: ");
           int dbms = input.nextInt();
           if(dbms<=100 & dbms>=0){
               stArray[key].setDbmsMarks(dbms);
               break l2;
           }else{
               System.out.print("Invalid Marks. ");
               continue l2;

           }
       }
   }

   public static void addNewStudent(){

       line();
       System.out.println("|        ADD NEW STUDENT                |");
       line();
       System.out.println();

       do{
           System.out.print("\nInput Student ID: ");
           Scanner in=new Scanner(System.in);
           String id = in.nextLine();
           if(isExists(id)){
               increment();
               stArray[stArray.length-1].setID(id);
               System.out.print("Input Student Name: ");
               Scanner n=new Scanner(System.in);
               stArray[stArray.length-1].setName(n.next());
               System.out.println("Student successfully added.");
           }else{
               System.out.println("Student Already Exists.");
           }
           System.out.print("\nDo you want to add another student(Y/N): ");
           op = input.nextLine();
       }while(!op.equals("N") && !op.equals("n") );
   }

   public static void line(){
       for (int i = 0; i <72; i++){
           System.out.print("-");
       }
       System.out.println();
   }
   public static String topic(){
       clearConsole();
       line();
       System.out.println("|     WELCOME TO GDSE MARKS MANAGEMENT SYSTEM              |");
       line();

       System.out.println();

       System.out.println("[1] Add New Student                      [2] Add New Student With Marks");
       System.out.println("[3] Add Marks                       		[4] Update Student Details");
       System.out.println("[5] Update Marks                     	[6] Delete Student");
       System.out.println("[7] Print Student Details                 [8] Print Student Ranks");
       System.out.println("[9] Best in the Programming Fundamental                [10] Best in the Management System");
       System.out.println();
       System.out.print("Enter an option to continue : ");
       String condition=input.nextLine();
       clearConsole();
       op = "Y";
       return condition;
   }


   public static void main(String args[]){
       l1:
       while(true){
           String condition = topic();
           switch (condition){
               case "1":addNewStudent();
                   break;
               case "2":addNewStudentWithMarks();
                   break;
               case "3":addMarks();
                   break;
               case "4":updateStudentDetails();
                   break;
               case "5":updateMarks();
                   break;
        /*case 6:deleteStudent ();
        break;
        case 7:printStudentDetails ();
        break;
        case 8:printStudentRanks ();
        break;
        case 9:bestInTheProgrammingFundamental ();
        break;
        case 10:bestInTheManagementSystem ();
        break; */
           }

       }
   }
}


