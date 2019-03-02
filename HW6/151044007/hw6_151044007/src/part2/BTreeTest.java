package part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTreeTest {

    @Test
    void binarySearch() {
        BTree<Integer> bTree=new BTree<>(5);
        bTree.add(10);
        bTree.add(33);
        bTree.add(22);
        bTree.add(40);
        bTree.add(41);
        bTree.add(42);
        bTree.add(43);
        System.out.println(bTree.toString());
        System.out.println("10 searchs.. index must be 0");
        bTree.binarySearch(10);
        assertEquals(0,bTree.getIndex());
        System.out.println("42 searchs.. index must be 2");
        bTree.binarySearch(42);
        assertEquals(2,bTree.getIndex());

        System.out.println("133 searchs.. index must be -1");
        bTree.binarySearch(133);
        assertEquals(-1,bTree.getIndex());

    }
}