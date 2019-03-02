package part2;

public class Main {
    public static void main(String[] args){
       ChainingHashSet<Integer> cs=new ChainingHashSet();
       System.out.println("size---->"+cs.size()+"\n");
       System.out.println("collision 1-->\n");
       cs.add(3); cs.showHashIndex(3);
       cs.add(34); cs.showHashIndex(34);
       System.out.println("\n\n\n");
        System.out.println("collision 2-->\n");
       cs.add(32); cs.showHashIndex(32);
       cs.add(1); cs.showHashIndex(1);
        System.out.println("\n\n\n");
        System.out.println("collision 3-->\n");
       cs.add(7); cs.showHashIndex(7);
       cs.add(38); cs.showHashIndex(38);
        System.out.println("\n\n\n");
       System.out.println("size---->"+cs.size());
        System.out.println("\n\n");
       System.out.println("remove test--->");
       System.out.println("3 is removed result is true----->"+cs.remove(3));
        System.out.println("size---->"+cs.size());
       System.out.println("65 is added  but 65 so new 65 dont assigns index of 3");
       cs.add(65);
       System.out.println("size---->"+cs.size());

        System.out.println("-------------------Test 2----------------------\n\n\n");

        ChainingHashSet<Character> cs1=new ChainingHashSet();
        System.out.println("size---->"+cs1.size()+"\n");
        System.out.println("collision 1-->\n");
        cs1.add('a'); cs1.showHashIndex('a');
        cs1.add('b'); cs1.showHashIndex('b');
        System.out.println("\n\n\n");
        System.out.println("collision 2-->\n");
        cs1.add('d'); cs1.showHashIndex('d');
        cs1.add('e'); cs1.showHashIndex('e');
        System.out.println("\n\n\n");
        System.out.println("Contains--->");
        System.out.println(cs1.contains('d'));
        System.out.println(cs1.contains('f'));
        System.out.println("\n\n\n");
        System.out.println("size---->"+cs1.size());
        System.out.println("\n\n");
        System.out.println("remove test--->");
        System.out.println("3 is removed result is true----->"+cs1.remove('a'));
        System.out.println("size---->"+cs1.size());
    }
}
