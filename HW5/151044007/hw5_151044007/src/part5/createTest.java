package part5;

import java.util.LinkedList;
import java.util.Random;

import static part5.QuickSort.*;

/**
 * prepares the test environment
 */
public class createTest {
    /**
     *start time(System.nanotime)
     */
    private double start;
    /**
     *time which is after the sort run(System.nanotime)
     */
    private double finish;

    /**
     *finish time-start time runtime of sorting
     */
    private double result;

    /**
     *initializes the arrays.
     * adds random number no sorted
     */
    private Random rand=new Random();

    /**
     * adds random number in array
     * sorts this and reverse array. Numbers sorted big to small
     * returns sorted(big to small) array to find worst case runtime
     * @param arr no sorted array
     * @param k is number.
     * @return Integer array. returns sorted array
     */
    public Integer[] createArrays(Integer [] arr,int k) {
        //add random number in array
        for (int i = 0; i < 100*k; i++) {
                arr[i] = rand.nextInt(333);
        }
        //sorts array. uses java sorted method
        sort(arr);
        Integer[] sorted=new Integer[100*k];
        //reverse array to do numbers big to small
        for(int i=0,j=100*k-1;i<100*k&&j>-1;i++,j--)
            sorted[j]=arr[i];
        //return sorted array
        return sorted;
    }

    /**
     * no returns.
     * dont to change main array. So assigns main array values another array
     * determine start time
     * runs sort method
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param k is number.to determine array size
     */
    public void quick(Integer[] arr,int k){
        //assings main array value another array.for main array valuse to stay the same position(big to small sorted)
        Integer[] sorted=new Integer[100*k];
        for(int i=0,j=100*k-1;i<100*k&&j>-1;i++,j--)
            sorted[i]=arr[i];
        start=System.nanoTime();
        QuickSort.sort(sorted);
        finish=System.nanoTime();
        result=finish-start;
        System.out.println("runtime method is--->  "+result/1000000);
    }

    /**
     * no returns. void
     * dont to change main array. So assigns main array values another array
     * determine start time
     * runs sort method
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param k is number.to determine array size
     */
    public void heap(Integer[] arr,int k){
        //assings main array value another array.for main array valuse to stay the same position(big to small sorted)
        Integer[] sorted=new Integer[100*k];
        for(int i=0,j=100*k-1;i<100*k&&j>-1;i++,j--)
            sorted[i]=arr[i];
        start=System.nanoTime();
        HeapSort.sort(sorted);
        finish=System.nanoTime();
        result=finish-start;
        System.out.println("runtime method is--->  "+result/1000000);
    }

    /**
     * no returns. void
     * dont to change main array. So assigns main array values another array
     * determine start time
     * runs sort method
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param k is number.to determine array size
     */
    public void insertion(Integer[] arr,int k){
        //assings main array value another array.for main array valuse to stay the same position(big to small sorted)
        Integer[] sorted=new Integer[100*k];
        for(int i=0,j=100*k-1;i<100*k&&j>-1;i++,j--)
            sorted[i]=arr[i];
        start=System.nanoTime();
        InsertionSort.sort(sorted);
        finish=System.nanoTime();
        result=finish-start;
        System.out.println("runtime method is--->  "+result/1000000);
    }

    /**
     * no returns. void
     * dont to change main array. So assigns main array values another array
     * determine start time
     * runs sort method
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param k is number.to determine array size
     */
    public void merge(Integer[] arr,int k){
        //assings main array value another array.for main array valuse to stay the same position(big to small sorted)
        Integer[] sorted=new Integer[100*k];
        for(int i=0,j=100*k-1;i<100*k&&j>-1;i++,j--)
            sorted[i]=arr[i];
        start=System.nanoTime();
        MergeSort.sort(sorted);
        finish=System.nanoTime();
        result=finish-start;
        System.out.println("runtime method is--->  "+result/1000000);
    }

    /**
     * no returns. void
     * dont to change main array. So assigns main array values in linkedlist
     * sorts array with custom merge sorts (with Double linked list)
     * determine start time
     * runs sort method
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param k is number.to determine array size
     */
    public void mergedll(Integer[] arr,int k){
        LinkedList sorted=new LinkedList();
        //assings main array value in linked list.for main array valuse to stay the same position(big to small sorted)
        for(int i=0;i<100*k;i++)
            sorted.add(arr[i]);
        start=System.nanoTime();
        MergeSortDll.mergeSort(sorted);
        finish=System.nanoTime();
        result=finish-start;
        System.out.println("runtime method is--->  "+result/1000000);
    }
}
