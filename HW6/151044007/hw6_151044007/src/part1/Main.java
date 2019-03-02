package part1;

import java.util.Random;

public class Main {
    public static void main(String [] args){
        System.gc();
        Random random=new Random();
        int added=random.nextInt()/100000;
        added=Math.abs(added);
        RedBlackTree<Integer> redBlackTree=new RedBlackTree<>();
        while(redBlackTree.showHeight()!=6){
            redBlackTree.add(added++);
            System.out.println(redBlackTree.toString());
        }
        RedBlackTree<Character> redBlackTree1=new RedBlackTree();
        Character character='a';
        while(redBlackTree1.showHeight()!=6){
            redBlackTree1.add(character++);
            System.out.println(redBlackTree1.toString());
        }
    }
}
