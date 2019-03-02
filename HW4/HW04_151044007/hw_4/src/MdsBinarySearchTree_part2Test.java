import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class MdsBinarySearchTree_part2Test {

    /**
     * add UnitTest
     * @throws Exception
     */
    @Test
    void add() throws Exception {
        System.out.println("------------------------addUnitTest---------------");
        Vector<Integer> num = new Vector<Integer>(2);
        num.add(45);
        num.add(55);
        Vector<Integer> num1 = new Vector<Integer>(2);
        num1.add(451);
        num1.add(30);
        MdsBinarySearchTree_part2<Integer> mds = new MdsBinarySearchTree_part2(2);
        mds.add(num1);
        System.out.println("if item isn null adds and return true-->test1  +mds.add(num1)-->"+mds.add(num1)+"\n  if items " +
                "is null return false test2--->+mds.add(null)--> "+mds.add(null));
        assertEquals(true,mds.add(num1));
        assertEquals(false,mds.add(null));
    }

    /**
     * contains UnitTest
     */
    @Test
    void contains() throws Exception {
        System.out.println("------------------------containsUnitTest---------------");
        Vector<Integer> num = new Vector<Integer>(2);
        num.add(45);
        num.add(55);
        Vector<Integer> num1 = new Vector<Integer>(2);
        num1.add(451);
        num1.add(30);

        Vector<Integer> num2 = new Vector<Integer>(2);
        num2.add(3);
        num2.add(4);

        MdsBinarySearchTree_part2<Integer> mds = new MdsBinarySearchTree_part2(2);
        mds.add(num1);
        mds.add(num);
        System.out.println("num1(451,30) is looked whether if contains..");
        assertEquals(true,mds.contains(num1));
        System.out.println("return value---->"+mds.contains(num1));
        System.out.println("num2(3,6) is looked whether if contains..");
        System.out.println("num2 isnt it in tree so returns false");
        assertEquals(false,mds.contains(num2));
        System.out.println("return value---->"+mds.contains(num2));
    }

    /**
     * find UnitTest
     */
    @Test
    void find()  {
        System.out.println("------------------------findUnitTest---------------");
        Vector<Integer> num = new Vector<Integer>(2);
        num.add(45);
        num.add(55);
        Vector<Integer> num1 = new Vector<Integer>(2);
        num1.add(451);
        num1.add(30);

        Vector<Integer> num2 = new Vector<Integer>(3);
        num2.add(3);
        num2.add(4);
        num2.add(5);

        MdsBinarySearchTree_part2<Integer> mds = new MdsBinarySearchTree_part2(2);
       try {
           mds.add(num1);
           mds.add(num);
           System.out.println(num.toString()+"  is searched result is-->");
           System.out.println("finded item is--->"+mds.find(num));
           assertEquals(num.toString(),mds.find(num).toString());
           System.out.println("searched item is is bigger than in tree items--> so throws exception");
           mds.find(num2);
       }
       catch (Exception e){
           System.out.println("Exception is throwned---->       "+ e.getMessage());
       }
    }

    /**
     * delete UnitTest
     */
    @Test
    void delete() throws Exception {
        System.out.println("------------------------deleteUnitTest---------------");
        Vector<Integer> num = new Vector<Integer>(4);
        num.add(45);
        num.add(55);
        num.add(4522);
        num.add(5534);
        Vector<Integer> num1 = new Vector<Integer>(4);
        num1.add(451);
        num1.add(30);
        num1.add(23);
        num1.add(24);
        Vector<Integer> num2 = new Vector<Integer>(4);
        num2.add(3);
        num2.add(4);
        num2.add(5);
        num2.add(344);
        Vector<Integer> num3 = new Vector<Integer>(4);
        num3.add(322);
        num3.add(454);
        num3.add(566);
        num3.add(3474);
        MdsBinarySearchTree_part2<Integer> mds = new MdsBinarySearchTree_part2(4);
        mds.add(num);
        mds.add(num1);
        mds.add(num2);
        mds.add(num3);
        System.out.println("num3(322,454,566,3474) is wanted to delete. Test result is--->");
        System.out.println(mds.root);
        System.out.println(mds.root.left);
        System.out.println(mds.root.right);
        System.out.println(mds.root.right.right);
        System.out.println("--------------------------------------------------");
        mds.delete(num1);
        System.out.println(mds.root);
        System.out.println(mds.root.left);
        System.out.println(mds.root.right);
        System.out.println(mds.root.right.right);
    }

    /**
     * remove UnitTest
     */
    @Test
    void remove() throws Exception {
        System.out.println("------------------------removeUnitTest---------------");
        Vector<Integer> num = new Vector<Integer>(4);
        num.add(45);
        num.add(55);
        num.add(4522);
        num.add(5534);
        Vector<Integer> num1 = new Vector<Integer>(4);
        num1.add(451);
        num1.add(30);
        num1.add(23);
        num1.add(24);

        Vector<Integer> num2 = new Vector<Integer>(4);
        num2.add(3);
        num2.add(4);
        num2.add(5);
        num2.add(344);
        Vector<Integer> num3 = new Vector<Integer>(4);
        num3.add(322);
        num3.add(454);
        num3.add(566);
        num3.add(3474);
        MdsBinarySearchTree_part2<Integer> mds = new MdsBinarySearchTree_part2(4);
        mds.add(num);
        mds.add(num1);
        mds.add(num2);
        mds.add(num3);
        System.out.println("num3(322,454,566,3474) is wanted to remove. Test result is--->");
        assertEquals(true,mds.remove(num3));
        System.out.println(mds.remove(num3));
        System.out.println(mds.remove(num1));
    }
}