import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CircularCustomList_part3Test {

    @Test
    void nextSemester() throws IOException {
        Curriculum_part1 cr =new Curriculum_part1();
        CircularCustomList_part3<Course_part1> cr1=new CircularCustomList_part3(cr);
        cr1.chooseSemester(2);
        Course_part1 c1=cr1.nextSemester();
        cr1.nextSemester();
        cr1.nextSemester();
        cr1.nextSemester();
        cr1.nextSemester();
        cr1.nextSemester();
        cr1.nextSemester();
        cr1.nextSemester();
        System.out.println("nextSemester(): creates circular list loop continue relative items-same semestr courses");
        Course_part1 c2=cr1.nextSemester();
        assertEquals(c1,c2);

    }

    @Test
    void chooseSemester() throws IOException {
        Curriculum_part1 cr =new Curriculum_part1();
        CircularCustomList_part3<Course_part1> cr1=new CircularCustomList_part3(cr);
        System.out.println("chooseSemester(): if index is legal return true else false");
        assertEquals(false,cr1.chooseSemester(-1));

    }

    @Test
    void next() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        System.out.println("next() test:");
        assertEquals(1,ns.next().intValue());
    }
}