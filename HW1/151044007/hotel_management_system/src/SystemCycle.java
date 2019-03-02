import java.io.*;
import java.util.Scanner;

/**
 *this class create system life cycle
 */
public class SystemCycle  {


    /**
     * this method is static because to use without creating an object
     * with this we can use test files.
     */
    public static  Scanner  input;
    private static final String RESEPINF = "resepsionists.csv";
    private static final String ROOMFILE = "RoomsInformation.csv";


    /**
     *takes char input from user return it
     * if user guests return G
     * if user resepsionists take information and checks whether resepsionist is
     * if it is true continue
     * else take input again
     * users created by polimorphism
     * @return char
     * @throws IOException
     */
    public char chooseUser() throws  IOException {
        char user;
        int counter=-1;
        do {
            counter++;
            if(counter==3){
                System.out.println("3 faulty trials. Something went wrong.The program is restarting\n");
                chooseUser();
            }
            System.out.println("Enter Guest(G)-Receptionist(R)--> ");
            while(!input.hasNext()) {
                System.out.println("That is not Character! Please Again-->");
                input.next().charAt(0);
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }
            user=input.next().charAt(0);
            if(user=='R'||user=='r'){
                if(loginResepsionist(1))//resepsionists login information is true continue
                    System.out.println("Resepsionist system turned on\n");
                else{//assigns 'a' for take input again
                    user='a';
                    System.out.println("name ,surname or id is wrong. Try again\n");
                }

            }
        }while( user!='G'&&user!='R'&&user!='r'&&user!='g');
        return user;
    }

    /**
     *takes name surname password and checks whether informations and inputs is equal
     * if it is true return true
     * else return false
     * @return boolean
     * @throws IOException
     */
    public boolean loginResepsionist(int c) throws IOException {
        String name;
        String surname;
        String id;
        boolean control=false;
        do {//name
            System.out.println("Resepsionist name--->");
            while (!(input.hasNextLine())) {
                System.out.println("Please Enter the Name");
                input.nextLine();
            }
            if(c==1)
                input.nextLine();
            name = input.nextLine().toUpperCase();
            control=true;
        }while(control==false);

        control=false;
        do {//surname
            System.out.println("Resepsionist surname--->");
            while (!(input.hasNextLine())) {
                System.out.println("Please Enter the Name");
                input.nextLine();
            }
            surname = input.nextLine().toUpperCase();
            control=true;
        }while (control==false);
        control=false;
        do {//password
            System.out.println("Resepsionist password--->");
            while (!(input.hasNextLine())) {
                System.out.println("Please Enter the Password");
                input.nextLine();
            }
            id = input.nextLine();

            control=true;
        }while (control==false);
        BufferedReader reader=new BufferedReader(new FileReader(RESEPINF));
        String control1;
        String [] lines;
        while ((control1=reader.readLine())!=null) {
            lines = control1.split(";");

            if (lines[0].compareTo(name) == 0 && lines[1].compareTo(surname) == 0 && lines[2].compareTo(id) == 0) {//check user is resepsionist
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }


    /**
     * take input from user
     * ask what do you want to the(limited according their user type)
     * @param c
     * @return int
     */
    public int bookOrcancel(int c){
        int bc;
        int counter=0;
        do {
            if(c==4)//if user is guest
                System.out.println("\nEnter BOOK(1) or CANCEL(2) or EXIT(3) or EXITPROGRAM(4-5-6)--> ");
            else//resepsionists
                System.out.println("\nEnter BOOK(1) or CANCEL(2) or CHECKIN(3) or CHECKOUT(4) or EXIT(5) or EXITPROGRAM(6)--> ");

            while(!(input.hasNextInt())) {
                System.out.println("That is not Integer! Please Again-->");
                input.next();
                counter++;
                if(counter==3){
                    System.out.println("3 faulty trials. Something went wrong.The program is restarting\n");
                    throw new IllegalArgumentException();

                }
            }
            bc=input.nextInt();
        }while( bc!=1&&bc!=2&&bc!=3&&bc!=4&&bc!=5&&bc!=6);
        return bc;
    }

    /**
     * hotel management life cycle runnig method
     * @throws IOException
     */
    public void ManagementLifeCycle() throws IOException {
        char user;
        int bc=0;
        input=new Scanner(System.in);
        Hotel hotel = new Hotel(15);//initialize hotel
        WriteReadCsvFile readWrite= new WriteReadCsvFile();//write information in file
        readWrite.writeCsvFile(hotel);
        ResGuestCommonQualifications guest= new Guests();//polimorphism is used this
        ResGuestCommonQualifications reseptionist= new Receptionists();//polimorphism is used this
        user=chooseUser();//takes user type
        if(user=='G'||user=='g'&&checkRooms()==false)//shows guests if there is no empty room
            System.out.println("All rooms are full. You can only book(Guest,Resepsionist) or Checkin-out(Resepsionist)");
        while (true){
            while(user=='G'||user=='g') {//if user guests
                while(bc==0)
                    bc = bookOrcancel(4);//asks what do you want
                if (bc == 1) {//book
                    readWrite.readCsvFile(hotel,'g');//shows rooms' information
                    guest.book(hotel);
                    readWrite.writeCsvFile(hotel);
                    bc = bookOrcancel(4);//asks what do you want
                } else if (bc == 2) {//cancel
                    readWrite.readCsvFile(hotel,'g');
                    guest.cancel(hotel);
                    readWrite.writeCsvFile(hotel);
                    bc = bookOrcancel(4);

                } else if(bc==3) {//exit user to choose new user
                    user = chooseUser();
                    bc=0;
                    break;
                }
                else{//exit program
                    Runtime.getRuntime().exit(1);
                }
            }
            while (user=='R'||user=='r'){
                while(bc==0)
                    bc = bookOrcancel(5);
                 if (bc == 1) {//book
                    readWrite.readCsvFile(hotel,'r');
                    reseptionist.book(hotel);
                    readWrite.writeCsvFile(hotel);
                    bc = bookOrcancel(5);
                } else if (bc == 2) {//cancel
                    readWrite.readCsvFile(hotel,'r');
                    reseptionist.cancel(hotel);
                    readWrite.writeCsvFile(hotel);
                    bc = bookOrcancel(5);
                } else if(bc==3) {//check in
                    readWrite.readCsvFile(hotel,'r');
                    reseptionist.CheckIn(hotel);
                    readWrite.writeCsvFile(hotel);
                    bc = bookOrcancel(5);
                }
                 else if(bc==4) {//check out
                    readWrite.readCsvFile(hotel,'r');
                    reseptionist.CheckOut(hotel);
                    readWrite.writeCsvFile(hotel);
                    bc = bookOrcancel(5);
                }
                else if(bc==5){//exit user to choose new user
                    user=chooseUser();
                    bc=0;
                    break;
                }
                else{//exit program
                    Runtime.getRuntime().exit(1);
                }
            }
        }
    }

    /**
     *checks whether total room are full
     * @return boolean
     * @throws IOException
     */
    public boolean checkRooms() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ROOMFILE));
        String controlLine;
        String[] lines;
        while ((controlLine = reader.readLine()) != null) {
            lines = controlLine.split(";");
            if (lines[4].compareTo("NO BOOK") == 0)
                return true;
        }
        return false;
    }
}
