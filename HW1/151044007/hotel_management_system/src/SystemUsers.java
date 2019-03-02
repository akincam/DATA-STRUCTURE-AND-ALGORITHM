import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *this class interface.
 * this methods implements from ResGuestCommonQualifications(abstract)
 */
public interface SystemUsers {
    /**
     * it takes Hotel parametr
     * it controls the reserve status of the room.
     * if room isnt rezervation,takes user's information and reserves else can not reserve the room.
     * @param h
     * @return boolean
     */
    public boolean book(Hotel h);

    /**
     * it takes Hotel parametr
     *it controls the reserve status of the room.
     * if room is rezervationed,takes user's information equal them in room information and cancel it
     * if room isnt rezervationed cant anything
     * @param h
     * @return boolean
     */
    public boolean cancel(Hotel h);

    /**
     *it takes Hotel parametr.
     * takes room id input from user and return true
     * @param h
     * @return boolean
     */
    public boolean chooseRoomId(Hotel h);

    /**
     *take user name input from user and return it to book,cancel,check in-out
     * @return String
     */
    public String enterName();

    /**
     *take user surname input from user and return it to book,cancel,check in-out
     * @return String
     */
    public String enterSurname();

    /**
     *take user id input from user and return it to book,cancel,check in-out
     * @return String
     */
    public String enterId();

    /**
     *check whether the room is full.
     * @param h
     * @return boolean
     */
    public boolean checkRoomIsBook(Hotel h);

    /**
     *take day for book or check in
     * check whether the date is apprioate
     * @return int
     */
    public int enterDateDay();

    /**
     *take month for book or check in
     * check whether the date is apprioate
     * @return int
     */
    public int enterDateMonth();
}
