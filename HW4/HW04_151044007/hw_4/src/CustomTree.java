/**
 *
 */
public interface CustomTree<E> {

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
    public boolean add(E parentItem,E childItem);


    /**
     * if root is null returns null
     * else first adds elements stack and if added node left and right null compare it
     * if equals return root else stack.pop and calls method again recursively node is stack.peek();
     * @param item is search for whether is in tree
     * @return node of item if node of item is in tree else returns null
     */
    public BinaryTree.Node<E> postOrderSearch(E item);

    /**
     * if root is null(tree is empty) returns null
     * else calls private levelOrderSearch method.
     * @param item is taken by parametr to search item whether is in tree
     * @return node of item if node of item is in tree else returns null
     */
    public BinaryTree.Node<E> levelOrderSearch(E item);
}