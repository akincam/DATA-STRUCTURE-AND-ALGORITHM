import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests the methods that make up the program cycle
 */
class SystemCycleTest {

    /**
     * this method takes information for check whether is resepsionists.
     * if true returns true else false
     * this method sould false because input informatons are wrong
     */
    @Test
    void loginResepsionist() throws IOException {
        System.setIn(new FileInputStream("SystemCycleLoginUnitTest"));
        SystemCycle.input=new Scanner(System.in);
        SystemCycle systemCycle= new SystemCycle();

        boolean b=systemCycle.loginResepsionist(2);
        System.out.println("\nRsepsionists enter the system");
        assertEquals(b,true);
    }

    /**
     *this method asks user what do you want to do
     * return an integer and according to integer process is runned
     */
    @Test
    void bookOrcancel() throws IOException {
        System.setIn(new FileInputStream("SystemCycleBookorCancelUnitTest"));
        System.out.println("\n -----Test---------");
        SystemCycle.input=new Scanner(System.in);
        SystemCycle systemCycle= new SystemCycle();


        assertEquals(systemCycle.bookOrcancel(4),3);
    }

    /**
     *this methods check whether if rooms are empty
     * if there is empty rooms returns true
     * else false
     */
    @Test
    void checkRooms() throws IOException {
        SystemCycle systemCycle=new SystemCycle();
        System.out.println("Checks that all rooms are full\n there is a empty room return true");
        assertEquals(systemCycle.checkRooms(),true);
    }
}