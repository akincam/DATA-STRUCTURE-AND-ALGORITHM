package part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainingHashSetTest {

    @Test
    void contains() {
        ChainingHashSet cs=new ChainingHashSet();
        cs.add(3);
        cs.add(5);
        cs.add(2);
        System.out.println("contains method---->");
        System.out.println(cs.contains(3));
        assertEquals(cs.contains(3),true);
        System.out.println("contains method element which is not in set ---->");
        System.out.println(cs.contains(6));
        assertEquals(cs.contains(6),false);
    }

    @Test
    void add() {
        ChainingHashSet cs=new ChainingHashSet();
        System.out.println("add method---->");
        assertEquals(cs.add(12),true);
        System.out.println(cs.add(423));
        System.out.println("add method---->");
        assertEquals(cs.add(12),false);
        System.out.println(cs.add(12));
    }

    @Test
    void remove() {
        ChainingHashSet cs=new ChainingHashSet();
        cs.add(33);
        cs.add(65);
        cs.add(3);
        System.out.println("remove method--->");
        assertEquals(cs.remove(33),true);
        System.out.println("remove method--->");
        assertEquals(cs.remove(33),false);
        System.out.println(cs.remove(33));

    }
}