import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 *Generic Class
 * Keeps a lot of element a node.
 * <E extends Comparable> extends BinaryTree implements SearchTree
 * @param <E>
 */
public class MdsBinarySearchTree_part2<E extends Comparable> extends BinaryTree implements SearchTree  {
    /**
     *to return some methods which are returns boolean
     */
    private boolean bool;
    /**
     *element number in a node
     */
    private int size;

    /**
     * when node is deleted to create new tree
     */
    private Queue <Vector<E>> levelOrder=new LinkedList<>();
    /**
     *Constructor.
     * @param num takes elements number in a node
     */
    public MdsBinarySearchTree_part2(int num) {

        size=num;
    }

    /**
     *if item is null return false else creates inner node object and cast item
     * calls private add method
     * @param item The item to be inserted
     * @return true if item is added else returns false
     * @throws Exception if element number in a node is not equals throws exception
     */
    @Override
    public boolean add(Object item) throws Exception {
        bool=false;
        if(item==null)
            return false;
        Mds mds=new Mds((Vector<E>) item);
        if(((Vector<E>) item).size()!=this.size)
            throw new Exception("Input size not equal other items(add method)");
        root = add(root, mds,size);
        return bool;
    }

    /**
     * to compare element use mod first level is first item
     * second is second item
     * last item+1 is equal first item compare
     *if root is null creates root
     * size%totalsize elements compares.
     * if big right else add left child.
     * @param localRoot root.
     * @param item casted item(inner class)
     * @param size elements in a node
     * @return
     */
    private Node<Vector<E>> add(Node<Vector<E>> localRoot, Mds item,int size){
        if(localRoot==null){
            bool = true;
            return new Node<Vector<E>>(item.data);
        }
        else if(item.data.get(size%this.size).compareTo(localRoot.data.get(size%this.size))==0){
            bool=true;
            return  localRoot;
        }
        else if(item.data.get(size%this.size).compareTo(localRoot.data.get(size%this.size))<0){
            size++;
            localRoot.left=add(localRoot.left,item,size);
            return localRoot;
        }
        else{
            size++;
            localRoot.right=add(localRoot.right,item,size);
            return localRoot;
        }

    }

    /**
     *if item is in tree returns true else returns false.
     * @param target Item being sought in tree
     * @return if there is item return true else false.
     * @throws Exception if element number in a node is not equals throws exception
     */
    @Override
    public boolean contains(Object target) throws Exception {
        bool=false;
        Mds mds=new Mds((Vector<E>) target);
        if(((Vector<E>) target).size()!=this.size)
            throw new Exception("Input size not equal other items(contains method)");
        find(root, mds,size);
        return bool;
    }

    /**
     *if item is in tree returns finded item else returns null.
     * @param target The item being sought
     * @return finded item else returns null.
     * @throws Exception if element number in a node is not equals throws exception
     */
    @Override
    public Object find(Object target) throws Exception {
        Mds mds=new Mds((Vector<E>) target);
        if(((Vector<E>) target).size()!=this.size)
            throw new Exception("Input size not equal other items(find method)");
        return find(this.root, mds,size);

    }

    /**
     *if target is null return null and boo is false because contains use find method.
     * compares elements is in node if equal return node else if small continue left node else right node.
     * @param target root of tree
     * @param item cast searched item to inner class and send private find method.
     * @param size element number size in a node
     * @return finded item else returns null.
     */
    private Node<Vector<E>> find(Node<Vector<E>> target, Mds item,int size){
        int count=0;
        if(target==null){
            bool=false;
            return null;
        }
        for(int i=0;i<this.size;i++) {
            if (target.data.get(i).compareTo(item.getData().get(i))==0)
                count++;
        }
        if(count==this.size){
            bool=true;
            return target;
        }
        int control=target.data.get(size%this.size).compareTo(item.getData().get(size%this.size));
        if(control<0) {
            return find(target.right, item, ++size);
        }
        else {
            return find(target.left, item, ++size);
        }

    }

    /**
     * uses find method and calls levelordermethod
     * level order method add all elements (fifo) in list
     * and creates node again but if levelorder.peek is deleted element pass it
     * @param target Item to be removed
     * @return deleted item or null
     */
    @Override
    public Object delete(Object target) throws Exception {
        Mds mds=new Mds((Vector<E>) target);
       Node<Vector<E>> current=(Node<Vector<E>>) find(target);
        Node<Vector<E>> current1= (Node<Vector<E>>) find(target);
        levelorder(root);
       if(current==null){
           bool=false;
           return null;
        }if(levelOrder.size()==0)
            return null;
       else{
           root.left=null;
           root.right=null;

           root=null;
           int count=0;
           while (levelOrder.size() != 0) {
               count=0;
               for(int i=0;i<this.size;i++) {
                   if (levelOrder.peek().get(i).compareTo(current.data.get(i))==0)
                       count++;
               }
               if(count!=this.size)
                    add(levelOrder.remove());
                else
                    levelOrder.remove();
               }
           return current1;
       }
    }

    /**
     * adds all element in queue
     * @param target takes root
     */
    private void levelorder(Node<Vector<E>> target){
        if(target!=null){
            levelOrder.add((Vector<E>) target.data.clone());
            levelorder(target.left);
            levelorder(target.right);
        }
        else
            return;
    }

    /**
     * uses delete method look element is in tree if is in calls delete else return false
     * @param target Item to be removed
     * @return true if item can be deleted else return false
     */
    @Override
    public boolean remove(Object target) throws Exception {
        if (contains(target)==true){
            delete(target);
            return true;
        }
        else
            return false;
    }
    /**
     *inner class to keep lots of element in a node
     */
    public class Mds{

        /**
         * keeps datas
         */
        private Vector<E> data;

        /**
         * takes data.clone of vector
         * @return Vector
         */
        public Vector getData() {
            return (Vector<E>) data.clone();
        }

        /**
         *sets data.clone of vector
         * @param data
         */
        public void setData(Vector<E> data) {
            this.data = (Vector<E>) data.clone();
        }

        /**
         * initializes vector of data and vector.
         * @param data1
         */
        public Mds(Vector<E> data1){
            data=new Vector<>();
            data= (Vector<E>) data1.clone();

        }
    }
}
