package part2;

public class Main {
    public static void main(String [] args) {
        BTree<Integer> bTree=new BTree<>(6);
        BTree<Character> bTree1=new BTree<>(4);
        try {
            bTree.add(10);
            bTree.add(33);
            bTree.add(22);
            bTree.add(40);
            bTree.add(13);
            bTree.add(41);
            bTree.add(222);
            bTree.add(5);
            bTree.add(113);
            bTree.add(4);
            bTree.add(34);
            bTree.add(62);
            System.out.println("Integer BTree+\n\n");
            System.out.println(bTree.toString());
            bTree1.add('s');
            bTree1.add('i');
            bTree1.add('v');
            bTree1.add('a');
            bTree1.add('d');
            bTree1.add('w');
            bTree1.add('k');
            bTree1.add('t');
            bTree1.add('f');
            bTree1.add('l');
            System.out.println("Character BTree+\n\n");
            System.out.println(bTree1.toString());

        }
        catch (Exception e){
            System.err.println("System Failed");
            System.exit(1);
        }
    }
}
