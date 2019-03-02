import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *Created general tree.
 * extends BinaryTree<E> and implements interface CustomTree<E>
 * @param <E> class type is generics.
 */
public class GeneralTree<E> extends BinaryTree<E> implements CustomTree<E> {
    /**
     * this instance variable is used for levelOrderSearch method. To search level by level
     */
    private Queue<Node<E>> items=new LinkedList<>();
    /**
     * this instance variable is used for postOrderSearch method. To search first last add element
     */
    private Stack<Node<E>> items1= new Stack<>();

    /**
     * this instance variable is used for postOrderSearch method.
     */
    private Stack<Node<E>> post= new Stack<>();
    /**
     * this instance variable is used for levelOrderSearch method.
     */
    private Queue<Node<E>> levelOrder[]=new LinkedList[30];
    /**
     * this instance variable is used for levelOrderSearch method. to add element  levelOrder array relative index
     */
    private int size=0;

    /**
     * calls superclass' constructor and takes field levelOrder array to use levelOrderSearch method.
     */
    public GeneralTree() {
        super();
        for(int ii=0;ii<30;ii++) {
            levelOrder[ii] = new LinkedList<>();
        }
    }

    /**
     * calls super class' constructor
     * takes Node paremetr and initiliaze root of tree.
     * @param root is assigned tree of node for initialize it.
     */
    protected GeneralTree(Node<E> root) {
        super(root);
    }

    /**
     * add items tree.
     * if root is null assigns parentItem to root and returns root.
     * if parentItem is null returns false.
     * else calls levelorderSearch method. searches parentITem level by level and if find it
     * return the node else return false.
     * if node is null return false
     * if node not null adds childItem to parent item's left.
     * if there is parentItem's child add childItem the rightest siblings
     * @param parentItem is searched whether is in tree
     * @param childItem is added if there is parentItem
     * @return true if there is parenItem of childItem else return false there is no parentItem
     */
    @Override
    public boolean add(E parentItem, E childItem) {
        if(root==null) {
            root = new Node<>(parentItem);
            levelOrder[0].add(root);
            return true;
        }
        if(parentItem==null)//if parent item is false return false
            return false;
        Node<E> node=levelOrderSearch(parentItem);
        if(node==null)//if levelOrder return value is null return false
            return false;
        else{
            if(node.left==null)
                node.left=new Node<>(childItem);
            else{
                node=node.left;
                while(node.right!=null){//if parentItem has child, childItem is added the rightest of parentItem's childs.

                    node=node.right;
                }
                node.right=new Node<>(childItem);

            }
            return true;
        }
    }

    /**
     * if root is null(tree is empty) returns null
     * else calls private postOrderSearch method.
     * @param item is taken by parametr to search item whether is in tree
     * @return node of item if node of item is in tree else returns null
     */
    @Override
    public Node<E> postOrderSearch(E item) {
        items=new LinkedList<>();
        if(root==null)
            return null;
        else {
            Node<E> node= postOrderSearch(item, post, root);
            if(root.data.equals(item)) {
                return root;
            }
            return node;

        }
    }

    /**
     * iki tane stack kullanılır. eger eleman root ise en sola kadar ilerleyecek her ilerlemesinde ilk stack e elemanı ekler ve solu ile
     * fonkisyion tekrar çagrılır en sona kadar ilerler. eger elemanın solunda eleman yoksa diğer stack e eklenir ve bu aranan eleman olup olmadığına bakılır.
     * o ise return node değil se ve sagı var ise sgı ile devam edilir.
     * geri dönerken aynı elemanlara denk gelecegi için items1 içinde olup olmadıgı kontrol edilir içinde var ise bir üste dönülür
     * sagı yok ise bi üst node olarak ilk stackten alınır bi üst seviyeye ge.ilir
     * if root is null returns null
     * else first adds elements stack and if added node left and right null compare it
     * if equals return root else stack.pop and calls method again recursively node is stack.peek();
     * @param item is search for whether is in tree
     * @param stack to add nodes stack to do postOrderSearch
     * @param node is takes root of tree.
     * @return node of item if node of item is in tree else returns null
     */
    private Node<E> postOrderSearch(E item, Stack stack,Node<E> node) {
        if(node==null&&stack.size()==0){//if root is null returns null
            return null;
        }
        else if(node==null&stack.size()!=0){//if root is null returns null
            return postOrderSearch(item,stack, (Node<E>) stack.peek());
        }
        //if parametr node is root and if lastly method calls(stack.size=0 because all items searched and remove)
        else if(node==root&&stack.size()==1){
            items1.add(node);//add items stack and checks whether if is item
            System.out.println(items1.peek());
            if(items1.peek().data.equals(item))//if true returns node else returns false
                return node;
            else
                return null;
        }
        //if parametr node is root and if firtly method calls(items1(stack) size=0 because no item added and searched)
        //add stacks item of node and calls function node.left
        else if(node==root&&items.contains(node)==false&&stack.size()==0&&items1.size()==0){
            stack.add(node);
            node = node.left;
            if(node==null)
                return null;
            return postOrderSearch(item, stack,node);
        }
        //if item is in items1 stack checks it.
        else if(node==root&&items.contains(node)==true){
            items1.add(node);
            System.out.println(items1.peek());
            if(items1.peek().data.equals(item))
                return node;
            else
                return null;
        }
        //if all elements are compared there is no element is in stack
        else if(stack.size()==0)
            return null;
        //if node left and node right is null and item isn't in comparable stack(items1)
        //item of node adds comparable item. checks is whether if items.peek
        //if items of node is not true true continue first stack.peek
        else if(node.left==null&&node.right==null&&items1.contains(node)==false){
            stack.add(node);
            items1.add(node);
            System.out.println(items1.peek());
            if(items1.peek().data.equals(item))
                return node;
            stack.pop();
            if(stack.size()==0)
                return null;
            else
                return postOrderSearch(item,stack, (Node<E>) stack.peek());
        }
        //if node left not null and node isnt in items1
        //added first stack returns left of node
        else if(node.left!=null&&node.right==null&&items1.contains(node.left)==false){
            stack.add(node);
            node = node.left;
            return postOrderSearch(item, stack,node);
        }
        else if(node.left!=null&&node.right!=null&&items1.contains(node.left)==true&&items1.contains(node.right)==true&&items1.contains(node)==false){
            items1.add(node);
            if(items1.peek().data.equals(item))
                return node;
            stack.pop();
            if(stack.size()==0)
                return null;
            else
                return postOrderSearch(item,stack, (Node<E>) stack.peek());
        }
        //if node left not null and node isnt in items1
        //added first stack returns left of node
        else if(node.left!=null&&node.right!=null&&items1.contains(node.left)==false){
            stack.add(node);
            node = node.left;
            return postOrderSearch(item, stack,node);
        }
        //if node left not null and node is in items1
        //compare item second stack of last element if false
        //returns right of node
        else if(node.left!=null&&node.right!=null&&items1.contains(node.left)==true){
            if(items1.contains(node)==false) {
                items1.add(node);
                System.out.println(items1.peek());
                if (items1.peek().data.equals(item))
                    return node;
                node = node.right;
                return postOrderSearch(item, stack, node);
            }
            else {
                return postOrderSearch(item, stack, (Node<E>) stack.pop());
            }
        }
        //if left is null continue right of node
        else if(node.left==null&&node.right!=null&&items1.contains(node)==false){
            stack.add(node);
            items1.add(node);
            System.out.println(items1.peek());
            if(items1.peek().data.equals(item))
                return node;
            stack.pop();
            if(stack.size()==0)
                return null;
            else
                return postOrderSearch(item,stack, (Node<E>) node.right);
        }
        //if node is in item pop it first stack calls method with stack.peek;
        else if(node.left!=null&&node.right==null&&items1.contains(node.left)==true){
            stack.pop();
            items1.add(node);
            System.out.println(items1.peek());
            if(items1.peek().data.equals(item))
                return node;
            return postOrderSearch(item, stack, (Node<E>) stack.peek());
        }
        //there is no matched condition returns null
        else
            return null;

    }

    /**
     * if root is null(tree is empty) returns null
     * else calls private levelOrderSearch method.
     * @param item is taken by parametr to search item whether is in tree
     * @return node of item if node of item is in tree else returns null
     */
    @Override
    public Node<E> levelOrderSearch(E item) {
        items=new LinkedList<>();
        if(root.data.equals(item)) {
            System.out.println(root.data);
            return root;
        }
        if(root==null)
            return null;
        else
            return levelOrderSearch(item,items,root);
    }

    /**
     *
     * root un sibling i var ise saga dogru gider giderken queue ye ekler ve kontrol eder.
     * bu arada levelOrder arrayinin ilgili level indexine ekler.
     * root kontrol edilir.
     * eger queue ya hiç eleman eklenmediyse return null olur
     * 2. level de sagda eleman esleşmiyorsa ikinci level in en soluna gider kardeslerne bakar ve bunu bütün o leveldakilere yapar
     * bu queue size 0 olana ya da eleman bulunana kadar devam eder
     * @param item is search for whether is in tree
     * @param q to checks level by level(because queue is first in first out(fifo))
     * @param node is takes root of tree.
     * @return node of item if node of item is in tree else returns null
     */
    private Node<E> levelOrderSearch(E item,Queue q,Node<E> node){
        if(node==root&&node.left!=null) {
            System.out.println(root.data);
            node = node.left;
            System.out.println();
            size++;
            while (node != null) {
                q.add(node);
                levelOrder[size].add(node);
                System.out.print(node.data+" ");
                if (node.data.equals(item)) {
                    return node;
                }
                node = node.right;
            }
            return levelOrderSearch(item, q, root.left);
        }
        //if node is root adds it first index of levelOrder
        else if(node==root) {
            levelOrder[0].add(root);
            size++;
            return root;
        }
        //if queue size is 0 return null
        else if(q.size()==0){
            return null;
        }
        //node left isnt null pop first element of queue,makes node=node.left
        //add elements queue and arr and makes node=node.right for same level
        else if(node.left!=null){
            if(findindex(node)>0)
                size=findindex(node);
            node= (Node<E>) ((Node<E>) q.peek()).left;
            q.remove();

            while (node!=null){
                q.add(node);
                levelOrder[size].add(node);
                System.out.print(node.data+" ");
                if(node.data.equals(item))
                    return node;
                node=node.right;
            }
            return levelOrderSearch(item,q, (Node<E>)q.peek());
        }
        else{
            q.remove();
            return levelOrderSearch(item,q, (Node<E>) q.peek());
        }
    }

    /**
     * when node is left node depth  is increase other condition is same is super class
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    @Override
    public void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("----\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 2, sb);
            preOrderTraverse(node.right, depth, sb);
        }

    }

    /**
     * find item's level to levelOrderSearch
     * @param item
     * @return index of item
     */
    private int findindex(Node<E> item){
        for(int i=0;i<levelOrder.length;i++) {
            if ((levelOrder[i].contains(item)))
                return i+1;
        }
        return -5;
    }
}
