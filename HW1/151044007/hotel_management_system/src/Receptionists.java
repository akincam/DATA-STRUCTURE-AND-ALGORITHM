

/**
 *
 */
public class Receptionists extends ResGuestCommonQualifications{

    private static final String NOBOOK = "NO BOOK";
    private static final String NONAME ="NO NAME";
    private static final String NOSURNAME="NO SURNAME";
    private static final String NOID ="NO ID";
    private static final String NOCHECK ="NO CHECK-IN";
    private static final String NODATE ="00/00/0000";

    /**
     *
     * takes room id.
     * checks whether the room is full
     * if room is empty take information and add room with Room class set method
     * else take room number
     * Shows that book operation done by resepsionists(BOOKED(R))
     * @param h
     * @return boolean
     */
    @Override
    public boolean book(Hotel h) {
        chooseRoomId(h);
        if(checkRoomIsBook(h)==true) {
            enterName();
            enterSurname();
            enterId();
            enterDateMonth();
            enterDateDay();
            h.getRooms(chooseNum - 1).setName(name);
            h.getRooms(chooseNum - 1).setSurname(surname);
            h.getRooms(chooseNum - 1).setId(id);
            h.getRooms(chooseNum - 1).setIsBook("BOOKED(R)");
            h.getRooms(chooseNum - 1).setIsDate(day + "/" + month + "/" + "2018");
            h.getRooms(chooseNum - 1).setIsFinishDate(finishday + "/" + finishmonth + "/" + "2018");

            System.out.println("reservation made :)");
            System.out.println("-------------------------------------------------------");
            System.out.println(chooseNum+"|"+name+"|"+surname+"|"+h.getRooms(chooseNum-1).getId()+"|"+h.getRooms(chooseNum-1).getIsBook()+"|"+h.getRooms(chooseNum-1).getIsCheckin()+"|"+
                    h.getRooms(chooseNum-1).getIsDate()+"|"+h.getRooms(chooseNum-1).getIsFinishDate());
            return true;
        }
        else {
            System.out.println("The room is full!!\n");
            return false;
        }
    }

    /**
     *
     * takes room id.
     * checks whether the room is full
     * if room is full take name,surname,id; compare them in choosen room informations if true
     * add room first initial values with Room class set method
     * else take room number
     * @param h
     * @return boolean
     */
    @Override
    public boolean cancel(Hotel h) {
        chooseRoomId(h);
        if(checkRoomIsBook(h)==false){
            enterName();
            enterSurname();
            enterId();
            if(h.getRooms(chooseNum-1).getName().compareTo(name)==0&&h.getRooms(chooseNum-1).getSurname().compareTo(surname)==0&&
                    h.getRooms(chooseNum-1).getId().compareTo(id)==0){
                h.getRooms(chooseNum-1).setName(NONAME);
                h.getRooms(chooseNum-1).setSurname(NOSURNAME);
                h.getRooms(chooseNum-1).setId(NOID);
                h.getRooms(chooseNum-1).setIsBook(NOBOOK);
                h.getRooms(chooseNum-1).setIsDate(NODATE);
                h.getRooms(chooseNum-1).setIsFinishDate(NODATE);
                return true;
            }
            else{
                System.out.println("Not matched informations!!\n");
                return false;
            }
        }
        else {
            System.out.println("No cancel The room is empty!");
            return false;
        }
    }

    /**
     *
     * takes room id.
     * checks whether the room is full
     * if room is empty take information and add room with Room class set method
     * if room is booked take information compare them and if true  add room with Room class set method
     * else take room number
     * Shows that book operation done by resepsionists(BOOKED(R))
     * @param h
     * @return boolean
     */
    public boolean CheckIn(Hotel h){

        chooseRoomId(h);
        if(checkRoomIsBook(h)==true){
            enterName();
            enterSurname();
            enterId();
            enterDateMonth();
            enterDateDay();
            enterLastCheckinMonth();
            enterLastCheckinDay();
            h.getRooms(chooseNum-1).setName(name);
            h.getRooms(chooseNum-1).setSurname(surname);
            h.getRooms(chooseNum-1).setId(id);
            h.getRooms(chooseNum-1).setIsBook("BOOKED(R)");
            h.getRooms(chooseNum-1).setIsCheckin("CHECKED IN");
            h.getRooms(chooseNum-1).setIsDate(day+"/"+month+"/"+"2018");
            h.getRooms(chooseNum-1).setIsFinishDate(finishday+"/"+finishmonth+"/"+"2018");

            System.out.println("check in made :)");
            System.out.println("-------------------------------------------------------");
            System.out.println(chooseNum+"|"+name+"|"+surname+"|"+h.getRooms(chooseNum-1).getId()+"|"+h.getRooms(chooseNum-1).getIsBook()+"|"+h.getRooms(chooseNum-1).getIsCheckin()+"|"+
                    h.getRooms(chooseNum-1).getIsDate()+"|"+h.getRooms(chooseNum-1).getIsFinishDate());
            return true;
        }
        else if(checkRoomIsBook(h)==false){
            enterName();
            enterSurname();
            enterId();
            if(h.getRooms(chooseNum-1).getName().compareTo(name)==0&&h.getRooms(chooseNum-1).getSurname().compareTo(surname)==0&&
                    h.getRooms(chooseNum-1).getId().compareTo(id)==0) {
                enterDateMonth();
                enterDateDay();
                enterLastCheckinMonth();
                enterLastCheckinDay();

                h.getRooms(chooseNum - 1).setName(name);
                h.getRooms(chooseNum - 1).setSurname(surname);
                h.getRooms(chooseNum - 1).setId(id);
                h.getRooms(chooseNum - 1).setIsBook("BOOKED(R)");
                h.getRooms(chooseNum - 1).setIsCheckin("CHECKED IN");
                h.getRooms(chooseNum - 1).setIsDate(day + "/" + month + "/" + "2018");
                h.getRooms(chooseNum - 1).setIsFinishDate(finishday + "/" + finishmonth + "/" + "2018");

                System.out.println("check in made :)");
                System.out.println("-------------------------------------------------------");
                System.out.println(chooseNum+"|"+name+"|"+surname+"|"+h.getRooms(chooseNum-1).getId()+"|"+h.getRooms(chooseNum-1).getIsBook()+"|"+h.getRooms(chooseNum-1).getIsCheckin()+"|"+
                        h.getRooms(chooseNum-1).getIsDate()+"|"+h.getRooms(chooseNum-1).getIsFinishDate());
                return true;
            }
        }
        System.out.println("No check-in!!\n");
        return false;
    }

    /**
     * takes room id.
     * checks whether the room is full
     * if room is full take name,surname,id; compare them in choosen room informations if true
     * add room first initial values with Room class set method
     * else take room number
     * @param h
     * @return boolean
     */
    public boolean CheckOut(Hotel h){
        boolean b=chooseRoomId(h);
        if(checkRoomIsCheckin(h)==true&&b!=false){
            enterName();
            enterSurname();
            enterId();
            if(h.getRooms(chooseNum-1).getName().compareTo(name)==0&&h.getRooms(chooseNum-1).getSurname().compareTo(surname)==0&&
                    h.getRooms(chooseNum-1).getId().compareTo(id)==0){
                h.getRooms(chooseNum-1).setName(NONAME);
                h.getRooms(chooseNum-1).setSurname(NOSURNAME);
                h.getRooms(chooseNum-1).setId(NOID);
                h.getRooms(chooseNum-1).setIsBook(NOBOOK);
                h.getRooms(chooseNum-1).setIsCheckin(NOCHECK);
                h.getRooms(chooseNum-1).setIsDate(NODATE);
                h.getRooms(chooseNum-1).setIsFinishDate(NODATE);

                System.out.println("check out made :)");
                System.out.println("-------------------------------------------------------");
                System.out.println(chooseNum+"|"+NONAME+"|"+NOSURNAME+"|"+h.getRooms(chooseNum-1).getId()+"|"+h.getRooms(chooseNum-1).getIsBook()+"|"+NOCHECK+"|"+
                        h.getRooms(chooseNum-1).getIsDate()+"|"+h.getRooms(chooseNum-1).getIsFinishDate());
                return true;
            }
            System.out.println("Some information can be wrong!");
            System.out.println("No check-out!!\n");
            return false;

        }
        return true;
    }

    /**
     *
     * check whether the room is full
     * if empty return true
     * else return false
     * @param h
     * @return boolean
     */
    @Override
    public boolean checkRoomIsBook(Hotel h) {
        if(h.getRooms(chooseNum-1).getIsBook().compareTo(NOBOOK)==0)
            return true;
        else
            return false;
    }

    /**
     *
     * check whether the room is full(check in)
     * if empty return true
     * else return false
     * @param h
     * @return boolean
     */
    private boolean checkRoomIsCheckin(Hotel h){
        if(h.getRooms(chooseNum-1).getIsCheckin().compareTo(NOCHECK)!=0)
            return true;
        else
            return false;
    }

}
