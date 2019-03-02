/**
 *
 * @param <E>
 */
public  class NewCustomList_part3<E> implements NewList_part3<E> {
    /**
     *the head of node
     */
    protected Node<E> head;
    /**
     *the size of list
     */
    protected int size;

    protected E getNext;
    /**
     * to make next and nextSemester method
     */
    protected int nextNum;
    /**
     *Constructor
     * initialized instance variable
     */
    public NewCustomList_part3(){
        head=null;
        getNext=null;
        size=0;
        nextNum=0;
    }

    /**
     *
     * @return head of node
     */
    public Node<E> getHead() {
        return head;
    }
    /**
     *
     * @return size of list
     */
    @Override
    public int size() {
        return size;
    }
    /**
     *
     * Add new item lastStuation to compare items find old location or nearest location.
     * @param data takes generic type.
     * @return true if methods can add else return false
     */
    @Override
    public void add(int i, E data) {
        if(i<0)//if i<0 wrong index throw execption
            throw new IllegalArgumentException("The index " + i
                    + "is lower than the size "+ 0 +".");
        else if(i>size)//if i>size wrong index throw execption
            throw new IllegalArgumentException("The index " + i
                    + "is greater than the size "+ size +".");
        else if(this.size()==0){//if size=0
            head=new Node<E>(data,head);
            size++;
        }
        else{//takes node and add it.
            Node<E> current=gnode(i-1);
            current.next=new Node<E>(data,current.next);
            size++;
        }
    }
    /**
     *
     * Add new item lastStuation to compare items find old location or nearest location.
     * @param data takes generic type.
     * @return true if methods can add else return false
     */
    @Override
    public boolean add(E data) {
        this.addLast(data);
        return true;
    }
    /**
     * add first index of list
     * @param data takes generic type.
     * @return true if methods can add else return false
     */
    @Override
    public boolean addFirst(E data) {
        head= new Node<E>(data,head);
        size++;
        return true;
    }
    /**
     * add last index of list
     * @param data takes generic type.
     * @return true if methods can add else return false
     */
    @Override
    public boolean addLast(E data) {
        if(size==0) {//if size 0 add first index
            addFirst(data);
            return true;
        }
        Node<E> current = gnode(size() - 1);
        current.next = new Node<E>(data, current.next);
        size++;
        return true;

    }
    /**
     *clear the lists
     */
    @Override
    public void clear() {
        size=0;
        this.head=null;
        System.gc();
    }
    /**
     * if there is matching item return true else false
     * @param o omparable object
     * @return
     */
    @Override
    public boolean contains(Object o) {
        Node<E> compare=head;
        for(int i=0;i<size;i++)
            if (this.get(i).equals(o))
                return true;
        return false;
    }

    /**
     * return item of given index
     * @param index
     * @return generic type
     */
    @Override
    public E get(int index) {
        if(index<0)//if index<0 wrong index throw execption
            throw new IllegalArgumentException("The index " + index
                    + "is lower than the size "+ 0 +".");
        else if(index>=size)//if index>=size wrong index throw execption
            throw new IllegalArgumentException("The index " + index
                    + "is greater than the size "+ size +".");
        Node<E> current=gnode(index);
        return current.data;
    }

    /**
     * looks first index
     * @return generic type
     */
    @Override
    public E peek() {
        if(size==0)
            return null;
        E data= (E) this.get(0);
        return data;
    }

    /**
     * remove item
     * @return removed item
     */
    @Override
    public E remove() {
        return removeFirst();
    }

    /**
     * remove item given index if illegal
     * @param index
     * @return removed item
     */
    @Override
    public E remove(int index) {
        if(index==0)
            remove();
        else if(index<0)//if index<0 wrong index throw execption
            throw new IllegalArgumentException("The index " + index
                    + "is lower than the size "+ 0 +".");
        else if(index>=size)//if index>=size wrong index throw execption
            throw new IllegalArgumentException("The index " + index
                    + "is greater than the size "+ size +".");
        Node<E> current = gnode(index-1);
        Node<E> currentDelete=gnode(index);
        current.next=currentDelete.next;
        size--;
        return currentDelete.data;
    }


    /**
     * remove item of first index given index if illegal
     * @return removed item
     */
    @Override
    public E removeFirst() {
        if(size==0)
            return null;
        E ret=get(0);
        Node<E> node=head;
        this.head=node.next;
        --size;
        return ret;
    }

    /**
     * /if there is no element return null
     * //if size=1 return first element
     * @return passed generic item
     */
    public E next() {
        Node<E> current;
        if(size==0)//if there is no element return null
            return null;
        else if(size==1) {//if size=1
            return null;
        }
        else if((nextNum+1)==size)
            return null;
        else{
            nextNum+=1;
            current=gnode(nextNum-1);
            return current.data;

        }
    }

    /**
     * /if there is no element return null
     * //if size=1 return first element
     * @return passed generic item
     */
    public E previous() {
        if(size==0)
            return null;
        else if(size==1){
            if(nextNum!=1)
                nextNum=0;
            return get(0);
        }
        else if(size>0&&nextNum!=0){
            nextNum--;
            return get(nextNum);

        }
        else
            return null;
    }
    protected Node<E> connectSemesters(int semester1,int totalNumber[]) {
        if (semester1 == 1) {
            Node<E> current = gnode(totalNumber[0]);
           return current.circular = new Node<E>(head.data, current.circular);
        } else {
            Node<E> current = gnode(totalNumber[semester1 - 1]);
           return current.circular=new Node<E>(gnode(totalNumber[semester1 - 1] - totalNumber[semester1 - 2]).data, current.circular);

        }

    }


    /**
     * returns given index's node
     * @param i index
     * @return Node<E></E>
     */
    protected Node<E> gnode(int i){
        Node<E> current=head;
        if(i==0)//if index is 0 return head
            return current;
        for(int ii=0;ii<i&&current!=null;ii++) {
            current = current.next;
        }
        return current;
    }


    /**
     * static because in the class header indicates that the Node<E> class wont reference its outer class.
     * @param <E>
     */
    public static class Node<E>{
        protected Node<E> next;
        protected Node<E> circular;
        protected E data;
        private Node(E data){
            this.data=data;
            next=null;
            circular=null;
        }
        private Node(E data,Node<E> node){
            this.data=data;
            this.next=node;
        }

    }


}
