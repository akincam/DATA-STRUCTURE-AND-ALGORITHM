import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class ReceptionistsTest {

    /**
     * Test whether check-in.
     * There is no check in return false
     * else return true
     */
    @Test
    void checkIn() throws IOException {
        Hotel h =new Hotel();
        System.setIn(new FileInputStream("ResCheckinUnitTest"));
        System.out.println("\n-----------Check in-----------");
        ResGuestCommonQualifications res=new Receptionists();
        SystemCycle.input=new Scanner(System.in);
        res.CheckIn(h);


    }

    /**
     *Test whether check-out.
     * There is no check out return false
     */
    @Test
    void checkOut() throws IOException {
        System.setIn(new FileInputStream("ResCheckOutUnit"));
        Hotel h=new Hotel();
        System.out.println("\n-----------Check in-----------");
        WriteReadCsvFile wf=new WriteReadCsvFile();
        wf.clearFileToUnitTest(h);
        SystemCycle.input=new Scanner(System.in);
        ResGuestCommonQualifications res=new Receptionists();
        res.CheckIn(h);
        wf.writeCsvFile(h);
        System.out.println("---------Check out-------------");
        boolean b=res.CheckOut(h);
        wf.writeCsvFile(h);
        assertEquals(b,true);



    }
}