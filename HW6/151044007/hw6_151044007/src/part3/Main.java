package part3;

public class Main {

    public static void main(String[] args){
        try {
            AVLTree<Integer> avl = new AVLTree<>();
            avl.add(50);
            avl.add(60);
            avl.add(25);
            avl.add(22);
            avl.add(26);
            System.out.println(avl.toString());
            avl.delete(60);
            System.out.println(avl.toString());


            AVLTree<Character> avl1 = new AVLTree<>();
            avl1.add('a');
            avl1.add('k');
            avl1.add('i');
            avl1.add('n');
            avl1.add('t');
            System.out.println(avl1.toString());
            avl1.delete('a');
            System.out.println(avl1.toString());
        }
        catch (Exception e){
            System.out.println("Beklenmedik bir durumla karşılaşıldı.");
            System.exit(1);
        }

    }
}
