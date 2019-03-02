import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewCustomList_part3Test {

    @Test
    void size() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        System.out.println("size() test: 3 item added and checked it");
        assertEquals(3,ns.size());
    }

    @Test
    void add() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        System.out.println("add() test: a item added if item can add return true");
        assertEquals(true,ns.add(1));
    }


    @Test
    void addFirst() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.addFirst(2);
        ns.add(3);
        System.out.println("addFirst() test: a item added first index");
        assertEquals(2,ns.get(0).intValue());
    }

    @Test
    void addLast() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(3);
        ns.addLast(2);

        System.out.println("addFirst() test: a item added last index");
        assertEquals(2,ns.get(ns.size()-1).intValue());
    }

    @Test
    void clear() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        System.out.println("List's first size--->"+ns.size());
        ns.clear();
        System.out.println("clear() test: a item added and clear:all items are remove and size is initializes again");
        assertEquals(0,ns.size);

    }

    @Test
    void contains() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        System.out.println("contains() test: checks whether given item is in list if there return true else false");
        assertEquals(false,ns.contains(24));
    }

    @Test
    void get() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        System.out.println("get item from list.test index is -1 so throw exception!!!");
        try {
            ns.get(-1).intValue();
        }
        catch (Exception e){
            assertEquals("The index " + -1
                    + "is lower than the size "+ 0 +".",e.getMessage());
        }

    }

    @Test
    void peek() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        System.out.println("peek(): test: looks there is element index of 0");
        assertEquals(1,ns.peek().intValue());
    }

    @Test
    void remove() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        System.out.println("remove item from list.");
        assertEquals(3,ns.remove(2).intValue());
    }

    @Test
    void next() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        System.out.println("next() test:.");
        assertEquals(1,ns.next().intValue());
    }

    @Test
    void previous() {
        NewCustomList_part3<Integer> ns=new NewCustomList_part3<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        ns.next();
        ns.next();
        System.out.println("previous() test:.");
        assertEquals(2,ns.previous().intValue());
        System.out.println("test2----if index=0 previous return null");
        ns.previous();
        assertEquals(null,ns.previous());

    }
}