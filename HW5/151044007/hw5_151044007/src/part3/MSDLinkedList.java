package part3;

import java.util.LinkedList;
public class MSDLinkedList {
    private static int count=0;
    /**
     * Sorts the linked list elements small to big
     * divide list the smallest lists and sorts them(recursively method)
     * @param list comparable and sortable double linked list
     * @param <T> linked list type is generic
     * @return sorted Linked list.
     */
    public static   <T extends Comparable<T>> LinkedList mergeSort(LinkedList<Comparable<T>> list){
        //linked list is empty there is no sorted element
        if(list.size()==0){
            //if main list is empty prints this.
            //to prevent print in divided list recursively. to do only main list
            if(count==0) {
                System.out.println("There is no element in list! No sorting");
            }
            return list;
        }
        //if main list is has a element, prints this.
        //to prevent print in divided list recursively. to do only main list
        else if(list.size()==1){
            if(count==0) {
                System.out.println("There is only one element! No sorting " + "list--> " + list.toString());
            }
            return list;
        }
        else if(list.size()>1){
            count=1;//to prevent in divided list recursively. to do only main list
            int counter=0; //to divide list
            int half=list.size()/2; //finds half of list
            LinkedList<Comparable<T>> leftlist=new LinkedList<>();
            LinkedList<Comparable<T>> rightlist=new LinkedList<>();

            /**
             *assings half of list in another list
             */
            while(counter<half){
                leftlist.add(list.get(counter));
                counter++;
            }

            counter=half;//
            /**
             *assings remain elements another list
             */
            while(counter<list.size()){
                rightlist.add( list.get(counter));
                ++counter;
            }
            /**
             *if half of list can cast Linked list calls method again (recursively
             */
            if(leftlist.clone() instanceof LinkedList)
                leftlist= (LinkedList<Comparable<T>>) mergeSort(leftlist).clone();
            /**
             *if remain of list can cast Linked list calls method again (recursively
             */
            if(rightlist.clone() instanceof LinkedList)
                rightlist= (LinkedList<Comparable<T>>) mergeSort(rightlist).clone();
            list.clear();
            /**
             *if all lists divides the smallest lists calls helperMerge method.
             */
            helperMerge(leftlist, rightlist, list).clone();

        }
        return list;
    }

    /**
     * Static method.
     * sorts the given elements.
     * @param left linked list created recursively
     * @param right linked list created recursively
     * @param reslist add the sorted elements to a list
     * @param <T> generic type method
     * @return sorted list
     */
    private static  <T extends Comparable<T>> LinkedList helperMerge(LinkedList<Comparable<T>> left,
                                                              LinkedList<Comparable<T>> right,LinkedList reslist){
        /**
         *if there are comparable elements whlie loop is continue.
         */
        while(left.size()>0&&right.size()>0){
            // if letf linkedlist's first element is smaller to right linkedlist's first element
            // adds small element in reslist and remove added element
            if(left.getFirst().compareTo((T) right.getFirst())<0) {
                reslist.addLast(left.getFirst());
                left.removeFirst();
            }
            else {
                reslist.addLast(right.getFirst());
                right.removeFirst();
            }
        }
        /**
         *if all elements are sorted and there is still element add this reslist
         * because remain elements are sorted and bigger than list.
         */
        if(left.size()>0) {
            reslist.addAll(left);
        }
        else if(right.size()>0) {
            reslist.addAll(right);
        }
        return reslist;
    }
}
