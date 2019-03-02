package part3;

/*<listing chapter="9" section="2">*/
/**
 * Self-balancing binary search tree using the algorithm defined
 * by Adelson-Velskii and Landis.
 * @author Koffman and Wolfgang
 */
public class AVLTree<E extends Comparable<E>>
         extends BinarySearchTreeWithRotate<E> {


    // Insert nested class AVLNode<E> here.
    /*<listing chapter="9" number="2">*/

    /**
     * Class to represent an AVL Node. It extends the
     * BinaryTree.Node by adding the balance field.
     */
    private static class AVLNode<E> extends Node<E> {

        /**
         * Constant to indicate left-heavy
         */
        public static final int LEFT_HEAVY = -1;
        /**
         * Constant to indicate balanced
         */
        public static final int BALANCED = 0;
        /**
         * Constant to indicate right-heavy
         */
        public static final int RIGHT_HEAVY = 1;
        /**
         * balance is right subtree height - left subtree height
         */
        private int balance;
        // Methods

        /**
         * Construct a node with the given item as the data field.
         *
         * @param item The data field
         */
        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }


        /**
         * Return a string representation of this object.
         * The balance value is appended to the contents.
         *
         * @return String representation of this object
         */
        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }
    /*</listing>*/
    // Data Fields
    /**
     * Flag to indicate that height of tree has increased.
     */
    private boolean increase;
    private int control = 0;


    private Node<E> rotateLeftRight(Node<E> node) {

        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    private Node<E> rotateRightLeft(AVLNode<E> node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    /**
     * add starter method.
     *
     * @param item The item being inserted.
     * @return true if the object is inserted; false
     * if the object already exists in the tree
     * @throws ClassCastException if item is not Comparable
     * @pre the item to insert implements the Comparable interface.
     */
    @Override
    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        return addReturn;
    }


    /**
     * Recursive add method. Inserts the given object into the tree.
     *
     * @param localRoot The local root of the subtree
     * @param item      The object to be inserted
     * @return The new local root of the subtree with the item
     * inserted
     * @post addReturn is set true if the item is inserted,
     * false if the item is already in the tree.
     */
    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }
        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add((AVLNode<E>) localRoot.left, item);
            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        } else { // item > data
            localRoot.right = add((AVLNode<E>) localRoot.right, item);
            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    increase = false;
                    return rebalanceRight(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        }
    }

    /**
     * @param localRoot
     * @return
     */
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {
        AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
        if (rightChild.balance < AVLNode.BALANCED) {
            AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
            if (rightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else if (rightLeftChild.balance < AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            } else {
                rightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            localRoot.right = rotateRight(rightChild);
        } else {
            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        return (AVLNode<E>) rotateLeft(localRoot);
    }

    /*<listing chapter="9" number="3">*/

    /**
     * Method to rebalance left.
     *
     * @param localRoot Root of the AVL subtree
     *                  that needs rebalancing
     * @return a new localRoot
     * @pre localRoot is the root of an AVL subtree that is
     * critically left-heavy.
     * @post Balance is restored.
     */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
        // Obtain reference to left child.
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child.
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            // Adjust the balances to be their new values after
            // the rotations are performed.
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.left = rotateLeft(leftChild);
        } else { //Left-Left case
            // In this case the leftChild (the new root)
            // and the root (new right child) will both be balanced
            // after the rotation.
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate the local root right.
        return (AVLNode<E>) rotateRight(localRoot);
    }
    /*</listing>*/

// Insert solution to programming exercise 1, section 2, chapter 9 here

    /**
     * Method to decrement the balance field and to reset the value of
     * increase.
     *
     * @param node The AVL node whose balance is to be incremented
     * @pre The balance field was correct prior to an insertion [or
     * removal,] and an item is either been added to the left[
     * or removed from the right].
     * @post The balance is decremented and the increase flags is set
     * to false if the overall height of this subtree has not
     * changed.
     */
    private void decrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not increased.
            increase = false;
        }
    }

    private void incrementBalance(AVLNode<E> node) {
        // Increment the balance.
        node.balance++;
        if (node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not decreased.
            increase = false;
        }
    }
    public E delete(E item) {
        control=2;
        root = delete((AVLNode<E>) root, item);
        return deleteReturn;
    }

    /**
     *eger bos node ise null return eder
     * verilen eleman sol tarafta ise methodu tekrar çagırır
     * recursive olduğu icin eleman silinecek ve burdan devam edecektir eleman soldan silindigi için balance degişecektir
     * eger denge saga kaymısşsa soldan sildigi ve bir yukarı kayacagı icin nodeu un sagındakinin balance durumu 0 olur.
     * Eğer aranan eleman bulunduysa
     *Return etmek icin kaydedilir.
     *Eger solu yada sagı null ise node null olur
     *Sagda en büyük eleman olduğu için eger bir alt node un sagı varsa ola-bildigince en saga gidip(while döngüsü) o node
     *u silinen node un yerine koyar aksi takdirde bir solundaki elemanı kendine atar ve kendini siler.
     *Bu durumda Solda yük dengesizligi olacağı için solu yeniden dengeler.
     * Ama olabildiğince sağa gittiği durumda denge işlemini uygulamaz çünkü sola doğru denge bozulmaz.
     * @param node local root
     * @param item is wanted to deleted
     * @return null if item is mot found else return item
     */
    private AVLNode<E> delete(AVLNode<E> node, E item) {
        //eğer boş node ise null return eder
        if (node == null) {
            deleteReturn = null;
            return node;
        }
        //verilen eleman sol tarafta ise
        if(item.compareTo(node.data) < 0) {
            //methodu tekrar çağırır
            node.left = delete((AVLNode<E>) node.left, item);
            //recursive olduğu için eleman silinecek ve burdan devam edecektir eleman soldan silindiği için balance değişecektir
            if (control == 1){
                //balance artar soldan sildiğimiz için
                node.balance=node.balance+1;
                if (node.balance >0)
                    control = 2;
                else
                    control = 1;
                //eğer denge sağa kaymışşsa
                if (node.balance >1) {
                    //soldan sildiği ve bir yukarı kayacağı için nodeu un sağındakinin balance durumu 0 olur.
                    if (node.right!=null&&((AVLNode<E>) node.right).balance >0) {
                        ((AVLNode<E>) node.right).balance =0;
                        node.balance = 0;
                        control=1;
                    }
                    //rebalanceRight çağrılır.
                    return rebalanceRight(node);
                }
                else
                    return (AVLNode<E>) rotateLeft(node);
            } else
                return node;
            //soldaki işlemin tam tersi uygulanır.
        } else if (item.compareTo(node.data) > 0){
            node.right = delete((AVLNode<E>) node.right, item);
            if (control == 1){
                node.balance=node.balance-1;
                if (node.balance < -1) {
                    if (node.left!=null&&((AVLNode<E>) node.left).balance <0) {
                        ((AVLNode<E>) node.left).balance =0;
                        node.balance = 0;
                        control=1;
                    }
                    return rebalanceLeft(node);
                }
                else
                    return (AVLNode<E>) rotateRight(node);
            } else
                return node;
            //eğer aranan eleman bulunduysa
        } else {
            //return etmek için atama yapılır.
            deleteReturn=node.data;
            // Eger solu yada sagı null ise node null olur cunkü bir alttaki node dan devam edecektir ve atama olacağı icin null olur
            if (node.left == null||node.right == null) {
                control=1;
                node=null;
            }
            //node un solu mevcut ise en büyük cocuğun node un yerini alması gerekir.
            else {
                E data=null;
                if ((node.left.right == null)) {
                    node.balance++;
                    data = node.left.data;
                    node.left = node.left.left;
                    if (node.balance >0)
                        control = 2;
                    else
                        control = 1;
                    node.data=data;
                } else {
                    AVLNode<E> avlNode= (AVLNode<E>) node.left;
                    E value;
                    //sagda en büyük eleman olduğu için eger bir alt node un sagı varsa ola-bildigince en saga gidip(while döngüsü) o
                    //node u silinen node un yerine koyar
                    while (true) {
                        //sagin sagi yoksa bi öncekini atama yapar
                        if (avlNode.right.right == null) {
                            value = avlNode.right.data;
                            avlNode.right = avlNode.right.left;
                            avlNode.balance--;
                            break;
                        } else {
                            if (((AVLNode<E>) avlNode.right).balance <-1) {
                                avlNode.right = rebalanceLeft((AVLNode<E>) avlNode.right);
                            }
                            if (control == 1) {
                                avlNode.balance--;
                            }
                            else{
                                avlNode= (AVLNode<E>) avlNode.right;
                            }
                        }
                    }
                    node.data=value;
                    //saga gittigi icin denge azalacak ve saga denge yapacaktır
                    if ( ( (AVLNode < E > ) node.left).balance < -1) {
                        node.left = rebalanceLeft( (AVLNode < E > ) node.left);
                    }
                    if (control==1) {
                        node.balance++;
                        if (node.balance >0)
                            control = 2;
                        else
                            control = 1;
                    }
                    return node;
                }
            }
        }
        return node;
    }
}