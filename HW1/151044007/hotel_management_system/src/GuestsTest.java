import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class  testing book-cancel-checkroomisBook(Guest's important methods)
 */
class GuestsTest {
    /**
     * book method returns true because choosen room is full assertEquals expected true
     * enter name -surname-id day-month is checked this test methods. this methods include them
     * @throws IOException
     */
    @Test
    void book() throws IOException {
        System.setIn(new FileInputStream("GuestbookUnitTest"));
        Hotel h=new Hotel();
        System.out.println("--------Booked Test----------");
        WriteReadCsvFile wf=new WriteReadCsvFile();
        wf.clearFileToUnitTest(h);
        SystemCycle.input=new Scanner(System.in);
        ResGuestCommonQualifications guestest=new Guests();
        assertEquals(guestest.book(h),true);
        wf.writeCsvFile(h);
        wf.clearFileToUnitTest(h);

    }

    /**
     * there is no booked room so expected value is false
     * twice test should be true because user can do cancel
     * enter name -surname-id is checked this test methods. this methods include them
     */
    @Test
    void cancel() throws IOException {
        System.setIn(new FileInputStream("GuestcancelUnitTest"));
        Hotel h=new Hotel();

        WriteReadCsvFile wf=new WriteReadCsvFile();
        wf.clearFileToUnitTest(h);//to clear implementations in other tests
        SystemCycle.input=new Scanner(System.in);
        ResGuestCommonQualifications guestest=new Guests();
        boolean b=guestest.cancel(h);
        assertEquals(b,false);
        System.out.println("\n--------Booked ----------");
        wf.writeCsvFile(h);
        wf.clearFileToUnitTest(h);
        guestest.book(h);
        System.out.println("\n-----------Cancel -----------------");
        assertEquals(guestest.cancel(h),true);
        wf.writeCsvFile(h);

        wf.readCsvFile(h,'c');
    }

    /**
     * take room number and check whether is empty
     * if empty returns true else false
     * @throws IOException
     */
    @Test
    void checkRoomIsBook() throws IOException{
        Hotel h=new Hotel();
        WriteReadCsvFile wf=new WriteReadCsvFile();
        wf.writeCsvFile(h);
        ResGuestCommonQualifications cntrl=new Guests();
        cntrl.chooseNum=6;
        System.out.println("\n all rooms are empty so returns true");
        assertEquals(cntrl.checkRoomIsBook(h),true);
    }
}