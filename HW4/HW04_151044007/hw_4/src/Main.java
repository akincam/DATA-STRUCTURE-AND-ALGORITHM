import java.util.Vector;


/**
 * main method
 */
public class Main {

    public static void main(String[] args)  {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("----------------------------------Part1-Test---------------------------------------\n");

        String a = "william1";
        String b = "robert";
        String c = "williamc";
        String d = "william2";
        String e = "adele";
        String f = "stephen";
        String g = "henry1";
        String h = "william";
        String i = "matilda";
        String j = "henry2";
        String k = "henry";
        String l=  "richard1";
        String m=  "geoffrey";

        GeneralTree<String> generalTree = new GeneralTree();
        System.out.println("\n-----------------------------Add method(root)--------------------------------------\n");
        generalTree.add(a,null);
        System.out.println("\n-----------------------------Add method(2.level after the root)-----------------------------------\n");
        generalTree.add(a,b);
        System.out.println("\n-----------------------------Add method(2.level after the root)----------------------------------\n");
        generalTree.add(a,d);
        System.out.println("\n-----------------------------Add method(2.level after the root)-----------------------------------\n");
        generalTree.add(a,e);
        System.out.println("\n-----------------------------Add method(2.level after the root)------------------------------------\n");
        generalTree.add(a,g);
        System.out.println("\n-----------------------------Add method(3.level)------------------------------------\n");
        generalTree.add(b,c);
        System.out.println("\n-----------------------------Add method(3.level)----------------------------------\n");
        generalTree.add(e,f);
        System.out.println("\n-----------------------------Add method(3.level)----------------------------------\n");
        generalTree.add(g,h);
        System.out.println("\n-----------------------------Add method(3.level)----------------------------------\n");
        generalTree.add(g,i);
        System.out.println("\n-----------------------------Add method(4.level)-----------------------------------\n");
        generalTree.add(i,j);
        System.out.println("\n-----------------------------Add method(5.level)----------------------------------\n");
        generalTree.add(j,k);
        System.out.println("\n-----------------------------Add method(5.level)----------------------------------\n");
        generalTree.add(j,l);
        System.out.println("\n-----------------------------Add method(5.level)-----------------------------------\n");
        generalTree.add(j,m);
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-----------------------------PreOrderTraverse Test---------------------------------");
        StringBuilder sb=new StringBuilder();
        generalTree.preOrderTraverse(generalTree.root,2,sb);
        System.out.println(sb.toString());

        System.out.println("-----------------------------PostOrderSearch Test----------------------------------");
        System.out.println("first item=william1 is searched---->");
        System.out.println("\n"+generalTree.postOrderSearch("william1")+"   returns postOrderSearch");

        System.out.println("----------------------------LevelOrderSearch Test---------------------------------");
        System.out.println("\n\n"+generalTree.levelOrderSearch("henry1")+"   returns levelOrderSearch\n"+"-----------------");

        System.out.println("\n\n"+generalTree.levelOrderSearch("richard1")+"   returns levelOrderSearch");


        System.out.println("----------------------------------Part1-Test2---------------------------------------\n");
        int [] arr={1,2,3,4,5,6,7};
        GeneralTree<Integer> generalTree2 = new GeneralTree();
        System.out.println("\n-----------------------------Add method--------------------------------------\n");
        generalTree2.add(arr[0],null);
        generalTree2.add(arr[0],arr[1]);
        generalTree2.add(arr[0],arr[3]);
        generalTree2.add(arr[0],arr[6]);
        generalTree2.add(arr[1],arr[2]);
        generalTree2.add(arr[1],arr[5]);
        generalTree2.add(arr[2],arr[4]);
        System.out.println("\n-----------------------------PostOrderSearch Test--------------------------------\n\n");
        System.out.println("first item=1 is searched---->");
        generalTree2.postOrderSearch(arr[0]);
        System.out.println("----------------------------LevelOrderSearch Test---------------------------------\n\n");
        generalTree2.levelOrderSearch(5);






        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.println("----------------------------------Part2-Test---------------------------------------\n");
        Vector<Integer> vec=new Vector<>(4);
        vec.add(3);vec.add(6);vec.add(1);vec.add(8);

        Vector<Integer> vec1=new Vector<>(4);
        vec1.add(33);vec1.add(61);vec1.add(12);vec1.add(81);

        Vector<Integer> vec2=new Vector<>(4);
        vec2.add(4);vec2.add(5);vec2.add(61);vec2.add(7);

        Vector<Integer> vec3=new Vector<>(4);
        vec3.add(323);vec3.add(64);vec3.add(14);vec3.add(86);

        Vector<Integer> vec4=new Vector<>(4);
        vec4.add(2);vec4.add(64444);vec4.add(12);vec4.add(81);

        Vector<Integer> vec5=new Vector<>(4);
        vec5.add(36);vec5.add(67);vec5.add(18);vec5.add(82);

        Vector<Integer> vec6=new Vector<>(4);
        vec6.add(333);vec6.add(60);vec6.add(15);vec6.add(87);

        Vector<Integer> vec7=new Vector<>(4);
        vec7.add(32);vec7.add(26);vec7.add(11);vec7.add(83);

        Vector<Integer> vec8=new Vector<>(4);
        vec8.add(2);vec8.add(675);vec8.add(31);vec8.add(78);
        try {
            System.out.println("Add method.");
            MdsBinarySearchTree_part2<Integer> mds = new MdsBinarySearchTree_part2(4);
            mds.add(vec);
            mds.add(vec1);
            mds.add(vec2);
            mds.add(vec3);
            mds.add(vec4);
            mds.add(vec5);
            mds.add(vec6);
            mds.add(vec7);
            mds.add(vec8);
            StringBuilder sb1=new StringBuilder();
            System.out.println("root-->"+mds.root);
            System.out.println("root.right-->"+mds.root.right);
            System.out.println("root.right.left-->"+mds.root.right.left);
            System.out.println("root.right.right-->"+mds.root.right.right);
            System.out.println("root.left-->"+mds.root.left);
            System.out.println("root.right.right.right-->"+mds.root.right.right.right);
            System.out.println("root.right.left.left-->"+mds.root.right.left.left);
            System.out.println("root.right.left.left.left-->"+mds.root.right.left.left.left);
            System.out.println("root.left.left-->"+mds.root.left.left);

            System.out.println("------------------------containsTest---------------");
            System.out.println("num1(451,30) is looked whether if contains..");
            if(mds.contains(vec1)==true)
                System.out.println("Element is finded");
            else
                System.out.println("No element");
            System.out.println("------------------------findTest---------------");
            if(mds.find(vec8)!=null)
                System.out.println(mds.root.left.left+" is try to find. result is-->"+mds.find(vec8));

            System.out.println("------------------------deleteTest---------------");
            System.out.println("root.left.left-->"+mds.root.left.left);
            mds.delete(vec8);
            System.out.println("root.left.left-->"+mds.root.left.left);

            System.out.println("------------------------removeTest---------------");
            System.out.println("root.left.left-->"+mds.root.left.left);
            System.out.println(vec8.toString()+" is searched result is-->"+mds.remove(vec8));

            Vector<Integer> vec9=new Vector<>(5);
            vec9.add(2);vec9.add(675);vec9.add(31);vec9.add(78);vec9.add(45);
            System.out.println("------------------------Exception test----item number(5) is bigger than in node(4)----\n");
            mds.find(vec9);

        }
        catch (Exception ef){
            System.out.println(ef.getMessage());
        }


    }
}
