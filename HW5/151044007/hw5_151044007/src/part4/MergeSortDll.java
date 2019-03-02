package part4;

import java.util.LinkedList;

public class MergeSortDll {
    private static int count=0;

    public static   <T extends Comparable<T>> LinkedList mergeSort(LinkedList<Comparable<T>> list){
        if(list.size()==0){
            if(count==0) {
                System.out.println("There is no element in list! No sorting");
            }
            return list;
        }
        else if(list.size()==1){
            if(count==0) {
                System.out.println("There is only one element! No sorting " + "list--> " + list.toString());
            }
            return list;
        }
        else if(list.size()>1){
            count++;
            int counter=0;
            int half=list.size()/2;
            LinkedList<Comparable<T>> leftlist=new LinkedList<>();
            LinkedList<Comparable<T>> rightlist=new LinkedList<>();

            while(counter<half){
                leftlist.add(list.get(counter));
                counter++;
            }
            counter=half;
            while(counter<list.size()){
                rightlist.add( list.get(counter));
                ++counter;
            }
            if(leftlist.clone() instanceof LinkedList)
                leftlist= (LinkedList<Comparable<T>>) mergeSort(leftlist).clone();
            if(rightlist.clone() instanceof LinkedList)
                rightlist= (LinkedList<Comparable<T>>) mergeSort(rightlist).clone();
            list.clear();
            helperMerge(leftlist, rightlist, list).clone();

        }
        return list;
    }
    private static  <T extends Comparable<T>> LinkedList helperMerge(LinkedList<Comparable<T>> left,
                                                                     LinkedList<Comparable<T>> right,LinkedList reslist){

        while(left.size()>0&&right.size()>0){
            if(left.getFirst().compareTo((T) right.getFirst())<0) {
                reslist.addLast(left.getFirst());
                left.removeFirst();
            }
            else {
                reslist.addLast(right.getFirst());
                right.removeFirst();
            }
        }
        if(left.size()>0) {
            reslist.addAll(left);
        }
        else if(right.size()>0) {
            reslist.addAll(right);
        }
        return reslist;
    }
}
