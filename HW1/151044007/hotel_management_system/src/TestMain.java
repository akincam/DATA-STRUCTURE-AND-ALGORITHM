import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 *
 */
public class TestMain {

    public static void main(String args[]) throws IOException {
        SystemCycle system = new SystemCycle();

        try {


            System.setIn(new FileInputStream("all_methods_test_maintests"));

            system.ManagementLifeCycle();
        }
        catch (IllegalArgumentException e){
            SystemCycle system1 = new SystemCycle();
            System.exit(1);
        }
        catch (FileNotFoundException e){
            System.err.println("File can't found.. The program is shutting down");
            System.exit(1);
        }
        catch (IOException i){
            System.err.println(" File can't create or read!!! he program is shutting down");
            System.exit(1);
        }
        catch (NoSuchElementException e){
            System.err.println(" Wrong input Type he program is shutting down");
            System.exit(1);
        }

        catch(Exception e) {
            System.err.println("Something went wrong. the program is shutting down");
            System.exit(1);
        }


        finally {
            System.err.println("Something went wrong.The program is shutting down");
            System.exit(1);
        }



    }


}
