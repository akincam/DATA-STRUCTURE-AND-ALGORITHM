import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Curriculum_part1Test {

    @Test
    void readCurriculum() throws IOException {
        Curriculum_part1 cr=new Curriculum_part1();
        Curriculum_part1 cr1;
        int size=0;
        System.out.println("readCurriculumTest:returns number of total course");
        assertEquals(54,cr.readCurriculum());
        try {
            cr1 = new Curriculum_part1("aaaa");
            size=cr1.readCurriculum();
        }
        catch (IOException e){
            System.out.println("file name is incorrect"+"--"+"throwing an exception"+"--"+"so course size = 0");
            assertEquals(0,size);
        }
    }

    @Test
    void listSemesterCourses() throws IOException {
        Curriculum_part1 cr=new Curriculum_part1();
        try {
            cr.listSemesterCourses(12);
        }
        catch (Exception e){
            System.out.println("listSemesterCourses() test: input semester num is out of range!! Throws exception. CourseArray cant initialize");
            assertEquals(e.getMessage(),"There is no matching semester");
        }
        System.out.println("listSemesterCourses() test: input semester num is legal! listSemesterCourses. CourseArray size is 8 for semester 1");
        Curriculum_part1 cr1=new Curriculum_part1();
        assertEquals(8,cr.listSemesterCourses(1).length);
    }

    @Test
    void getByRange() throws IOException {
        Curriculum_part1 cr=new Curriculum_part1();
        System.out.println("getByRange() test: input index num is out of range!! Throws exception. CourseArray cant initialize");
        try {
            cr.getByRange(-5,3);
        }
        catch (Exception e){
            assertEquals("Wrong input in getByRange!!!!!!",e.getMessage());
        }
        System.out.println("-----------------------------test2-----------------------------------");
        Curriculum_part1 cr1=new Curriculum_part1();
        assertEquals(4,cr.getByRange(0,3).length);
        System.out.println("True index");
    }
    @Test
    void getByCode() throws IOException {
        Curriculum_part1 cr=new Curriculum_part1();
        System.out.println("getByCode() test: input code is no match anything!! Throws exception. CourseArray cant initialize");
        try{
            cr.getByCode("fsdffs");
        }
        catch (Exception e){
            assertEquals("There is no matching code!!!",e.getMessage());
        }
        System.out.println("-----------------------------test2-------------(CSE 222) matched----------------------");
        assertEquals(1,cr.getByCode("CSE 222").length);
    }
}