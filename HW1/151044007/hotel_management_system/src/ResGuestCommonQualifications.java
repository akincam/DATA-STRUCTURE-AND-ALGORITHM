import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

/**
 *this class is abstract and imlements SystemUsers methods.
 */
public abstract class ResGuestCommonQualifications implements SystemUsers{

    protected Scanner input;
    protected String name;
    protected String surname;
    protected String id;
    protected int chooseNum;
    protected int day;
    protected int month;
    protected int finishday;
    protected int finishmonth;

    /**
     * this method takes information for book,cancel,check in-out
     * take input(String) from user
     * assings it to name
     *return user name.
     * if input is illegal take input again
     * @return String
     */
    @Override
    public String enterName() {
        boolean control=false;
        int counter=-1;
        do {
            counter++;
            if(counter==3){
                throw new IllegalArgumentException();
            }
            System.out.println("Enter the Name--->");
            while (!(input.hasNextLine())) {
                System.out.println("Please Enter the Name");
                input.nextLine();
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }

            input.nextLine();
            name =(String) input.nextLine().toUpperCase();
            control=true;
        }while (control==false);
        return name;
    }
    /**
     * this method takes information for book,cancel,check in-out
     *take input(String) from user
     * assings it to surname
     *return user surname.
     * if input is illegal take input again
     * @return String
     */
    @Override
    public String enterSurname() {
        boolean control=false;
        int counter=-1;
        do {
            counter++;
            if(counter==3){
                throw new IllegalArgumentException();
            }
            System.out.println("Enter the Surname-->");
            while (!(input.hasNextLine())) {
                System.out.println("Please Enter the Surname-->");
                input.nextLine();
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }
            surname =(String) input.nextLine().toUpperCase();
            control=true;
        }while (control==false);
        return surname;
    }

    /**
     * this method takes information for book,cancel,check in-out
     * take input(String) from user
     * assings it to id
     * return user id.
     * if input is illegal take input again
     * @return String
     */
    @Override
    public String enterId() {
        boolean control=false;
        int counter=-1;
        do {
            counter++;
            if(counter==3){
                throw new IllegalArgumentException();
            }
            System.out.println("Enter the Guest's ID-->");
            while (!(input.hasNextLine())) {
                System.out.println("Please Enter the Guest's ID-->");
                input.nextLine();
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }
            id =(String) input.nextLine();
            control=true;
        }while (control==false);
        return id;
    }

    /**
     *
     * this method takes information for book,cancel,check in-out
     * take input(int) from user
     * assings it to id(choosen room id)
     * return boolean.
     * if input is illegal take input again
     * @param h
     * @return boolean
     */
    @Override
    public boolean chooseRoomId(Hotel h) {
        input=SystemCycle.input;
        int counter=-1;
        do {
            counter++;
            if(counter==3){
                throw new IllegalArgumentException();
            }
            System.out.println("Enter The Room Number--> ");
            while(!input.hasNextInt()) {
                System.out.println("That is not Integer! Please Again-->");
                input.next();
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }
            chooseNum=(int)input.nextInt();

        }while(chooseNum>h.getRoomNumber()||chooseNum<1);
        return true;
    }
    /**
     *
     * this method takes information for book and check in
     * take input(int) from user date of day
     * assings it to day(choosen date of day)
     * return int.
     * if input is illegal take input again
     * check that the selected date is whether later than today
     * @return int
     */
    @Override
    public int enterDateDay(){
        Date date=new Date();
        int counter=-1;
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int nowDay = localDate.getDayOfMonth();//takes now Day of Month
        do {
            counter++;
            if(counter==3){
                throw new IllegalArgumentException();
            }
            System.out.println("Choose the day of your desired date--> ");
            while(!input.hasNextInt()) {
                System.out.println("That is not Integer! Please Again-->");
                input.next();
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }
            day=(int)input.nextInt();
            if(month==localDate.getMonthValue()&&day<nowDay){//if month is this month day is should be today or later than today
                day=32;//if true take input again
                counter--;
            }

        }while(day>31||day<1);
        return day;
    }

    /**
     *
     * this method takes information for book and check in
     * take input(int) from user date of month
     * assings it to month(choosen date of month)
     * return int.
     * if input is illegal take input again
     * check that the selected date is whether later than month
     * @return int
     */
    @Override
    public int enterDateMonth(){
        int counter=-1;
        Date date=new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int nowDay = localDate.getMonthValue();
        do {
            counter++;
            if(counter==3){
                throw new IllegalArgumentException();
            }
            System.out.println("Choose the month of your desired date--> ");
            while(!input.hasNextInt()) {
                System.out.println("That is not Integer! Please Again-->");
                input.next();
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }
            month=(int)input.nextInt();

        }while(month>12||month<nowDay);
        return month;
    }

    /**
     *
     * this method takes information for book and check in
     * take input(int) from user date of lastday
     * assings it to finishday(choosen date of finishday)
     * return int.
     * if input is illegal take input again
     * check that the selected date is whether later than today
     * if enterLastCheckinMonth() is this month check that the selected date is whether later than today
     * @return int
     */
    public int enterLastCheckinDay(){
        int counter=-1;
        do {
            counter++;
            if(counter==3){
                throw new IllegalArgumentException();
            }
            System.out.println("Choose the day of your desired finish date--> ");
            while(!input.hasNextInt()) {
                System.out.println("That is not Integer! Please Again-->");
                input.next();
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }
            finishday=(int)input.nextInt();

        }while(finishday>30||finishday<1);
        if(finishmonth==month&&finishday<day) {
            enterLastCheckinDay();
        }
        return finishday;
    }

    /**
     *
     * * this method takes information for book and check in
     * take input(int) from user date of lastmonth
     * assings it to finishmonth(choosen date of finishmonth)
     * return int.
     * if input is illegal take input again
     * check that the selected date is whether later than today
     * @return int
     */
    public int enterLastCheckinMonth(){
        int counter=-1;
        do {
            counter++;
            if(counter==3){
                throw new IllegalArgumentException();
            }
            System.out.println("Choose the month of your desired finish date--> ");
            while(!input.hasNextInt()) {
                System.out.println("That is not Integer! Please Again-->");
                input.next();
                counter++;
                if(counter==3){
                    throw new IllegalArgumentException();
                }
            }
            finishmonth=(int)input.nextInt();

        }while(finishmonth>12||finishmonth<month);
        return finishmonth;
    }


    /**
     *checks whether the room is full
     * @param h
     * @return boolean
     */
    public abstract boolean checkRoomIsBook(Hotel h);

    /**
     *it takes Hotel parametr
     *it controls the reserve status of the room.
     * if room isnt rezervation,takes user's information and reserves else can not reserve the room.
     * abstract because guests and resepsionists has different qualifications
     * @param h
     * @return boolean
     */
    public abstract boolean book(Hotel h);

    /**
     *
     * it takes Hotel parametr
     *it controls the reserve status of the room.
     * if room is rezervationed,takes user's information equal them in room information and cancel it
     * if room isnt rezervationed cant anything
     * abstract because guests and resepsionists has different qualifications
     * @param h
     * @return boolean
     */
    public abstract boolean cancel(Hotel h);

    /**
     *
     * it takes Hotel parametr
     * this method is created for only resepsionists
     *it controls the reserve status of the room.
     * if room is empty or booked,takes user's information equal them in room information and cancel it
     * if room isnt rezervationed cant anything
     * abstract because guests and resepsionists has different qualifications
     * @param h
     * @return boolean
     */
    public abstract boolean CheckIn(Hotel h);

    /**
     *
     * it takes Hotel parametr
     * this method is created for only resepsionists
     *it controls the reserve status of the room.
     * if room is checked in,takes user's information equal them in room information and cancel it
     * if room isnt rezervationed cant anything
     * abstract because guests and resepsionists has different qualifications
     * @param h
     * @return boolean
     */
    public abstract boolean CheckOut(Hotel h);

}
