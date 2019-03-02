public interface NewList_part3<E> {
    /**
     * return size of list
     * @return size
     */
    public int size();

    /**
     * Add new item lastStuation to compare items find old location or nearest location.
     * @param data takes generic type.
     * @return true if methods can add else return false
     */
    public boolean add(E data);

    /**
     * add new item lastStuation to compare items find old location or nearest location.
     * @param i index to add
     * @param data takes generic type.
     * throws exception if cant add
     */
    public void add(int i , E data);

    /**
     * add first index of list
     * @param data takes generic type.
     * @return true if methods can add else return false
     */
    public boolean addFirst(E data);

    /**
     * add last index of list
     * @param data takes generic type.
     * @return true if methods can add else return false
     */
    public boolean addLast(E data);

    /**
     * clear the list
     */
    public void clear();

    /**
     * if there is matching item return true else false
     * @param o comparable object
     * @return
     */
    public boolean contains(Object o);

    /**
     * return item of given index
     * @param index
     * @return generic type
     */
    public E get(int index);

    /**
     * looks first index
     * @return generic type
     */
    public E peek();

    /**
     * remove item
     * @return removed item
     */
    public E remove();

    /**
     * remove item given index if illegal
     * @param index
     * @return removed item
     */
    public E remove(int index);

    /**
     * remove item of first index given index if illegal
     * @return removed item
     */
    public E removeFirst();

}
