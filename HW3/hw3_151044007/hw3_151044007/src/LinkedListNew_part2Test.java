import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListNew_part2Test {

    @Test
    void add() {
        System.out.println("add() test: add 3 item in list so list size 3 assertEquals(3,size())==true");
        LinkedListNew_part2<String > ls=new LinkedListNew_part2<>();
        ls.add("akin");
        ls.add("cam");
        ls.add("151044007");
        assertEquals(3,ls.size());
    }

    @Test
    void disabled() {
        LinkedListNew_part2<String > ls=new LinkedListNew_part2<>();
        ls.add("akin");
        ls.add("cam");
        ls.add("151044007");
        System.out.println("disabled() test: add 3 item in list a element which is in list disabled so return true");
        assertEquals(true,ls.disabled("akin"));
        System.out.println("------------test2--------------------------------------");
        System.out.println("disabled() test: add 3 item in list a element which isnt in list disabled so return false");
        assertEquals(false,ls.disabled("aaa"));

    }

    @Test
    void enabled() {
        LinkedListNew_part2<String > ls=new LinkedListNew_part2<>();
        ls.add("akin");
        ls.add("cam");
        ls.add("151044007");
        System.out.println("disabled() : add 3 item in list a element which (akin)");
        ls.disabled("akin");
        System.out.println("enabled() test :(akin) is try to enabled the item is in the list so return true");
        assertEquals(true,ls.enabled("akin"));
        System.out.println("------------test2--------------------------------------");
        System.out.println("enabled() test :(aaa) is try to enabled the item isnt in the list so return false");
        assertEquals(false,ls.enabled("aaa"));
    }

    @Test
    void showDisabled() {
        LinkedListNew_part2<String > ls=new LinkedListNew_part2<>();
        ls.add("akin");
        ls.add("cam");
        ls.add("151044007");
        System.out.println("disabled() : add 3 item in list a element which (akin)");
        ls.disabled("akin");
        System.out.println("showDisabled() test :(akin) is so returns true");
        assertEquals(true,ls.showDisabled());
        ls.enabled("akin");
        System.out.println("------------test2--------------------------------------");
        System.out.println("showDisabled() test :there is no disabled element  so returns false");
        assertEquals(false,ls.showDisabled());
    }

    @Test
    void enabledOrDisabled() {
        LinkedListNew_part2<String > ls=new LinkedListNew_part2<>();
        ls.add("akin");
        ls.add("cam");
        ls.add("151044007");
        System.out.println("disabled() : add 3 item in list a element which (akin)");
        ls.disabled("akin");
        System.out.println("------------test1--------------------------------------");
        System.out.println("akin is disable item so return 2");
        assertEquals(2,ls.EnabledOrDisabled("akin"));
        System.out.println("------------test2--------------------------------------");
        System.out.println("cam is enable item so return 1");
        assertEquals(1,ls.EnabledOrDisabled("cam"));
        System.out.println("------------test3--------------------------------------");
        System.out.println("derin isnt item of list item so return 3");
        assertEquals(3,ls.EnabledOrDisabled("derin"));



    }
}