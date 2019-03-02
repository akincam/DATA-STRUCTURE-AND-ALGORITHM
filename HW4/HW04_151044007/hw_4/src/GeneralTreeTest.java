import static org.junit.jupiter.api.Assertions.*;

class GeneralTreeTest {

    /**
     * add Test
     */
    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("---------------addUnitTest------------");
        String parent="Harry";
        String child="Hermonie";
        String child2="Mary";
        String child3=null;
        GeneralTree<String> add=new GeneralTree<>();
        boolean bool=false;
        System.out.println("Root, before add methods--->"+add.root);
        bool=add.add(parent,null);
        assertEquals(true,bool);
        System.out.println("Root, after add methods--->"+add.root);
        bool=add.add(null,parent);
        System.out.println("if item is null retun null and bool is false");
        assertEquals(false,bool);
        System.out.println("Bool is-->"+bool);
    }
    /**
     * postOrderSearch Test
     */
    @org.junit.jupiter.api.Test
    void postOrderSearch() {
        System.out.println("---------------postOrderSearchUnitTest------------");
        GeneralTree<String> ss=new GeneralTree<>();
        String a = "william1";
        String b = "robert";
        String c = "williamc";
        String d = "william2";
        String e = "adele";
        ss.add(a,null);
        ss.add(a,b); ss.add(a,d); ss.add(a,e);
        ss.add(b,c);
        BinaryTree.Node node=ss.postOrderSearch("william1");
        System.out.println("PostorderResult should be root(william1)");
        assertEquals(ss.root,node);
        System.out.println("PostorderSearch return value--->"+node);
    }

    /**
     * levelOrderSearch
     */
    @org.junit.jupiter.api.Test
    void levelOrderSearch() {
        GeneralTree<String> ss=new GeneralTree<>();

        String a = "william1";
        String b = "robert";
        String c = "williamc";
        String d = "william2";
        String e = "adele";
        ss.add(a,null);
        ss.add(a,b); ss.add(a,d); ss.add(a,e);
        ss.add(b,c);
        System.out.println("When you use add method levelorderSearch is called" +
                "so above the items print");
        System.out.println("---------------levelOrderSearchUnitTest------------");
        System.out.println("levelOrderSearch items orders should be below");
        StringBuilder sb=new StringBuilder();
        sb.append(a);
        sb.append("\n");
        sb.append(b);
        sb.append("\n");
        sb.append(d);
        sb.append("\n");
        sb.append(e);
        System.out.println(sb.toString());
        System.out.println("------------testResult--------------");
        BinaryTree.Node node=ss.levelOrderSearch("adele");
        System.out.println("searched item adele finded item is--->"+node);
        assertEquals(e,node.data);


    }
    /**
     *preOrderTraverseTest
     */
    @org.junit.jupiter.api.Test
    void preOrderTraverse() {
        GeneralTree<Integer> ss=new GeneralTree<>();
        int a=1;
        int b=2;
        int c=3;
        int d=4;
        int e=5;
        int f=6;
        int g=7;
        ss.add(a,null);
        ss.add(a,b); ss.add(a,d); ss.add(a,g);
        ss.add(b,c);
        ss.add(c,e);
        ss.add(b,f);
        System.out.println("When you use add method levelorderSearch is called" +
                "so above the items print");
        System.out.println("---------------preOrderTraverseUnitTest------------");
        System.out.println("result is---->");
        StringBuilder sb=new StringBuilder();
        ss.preOrderTraverse(ss.root,3,sb);
        System.out.println(sb);
    }
}