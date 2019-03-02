package part4;

import java.util.LinkedList;
import java.util.Random;

/**
 * prepares the test environment
 */
public class createTest {
    /**
     *initializes the arrays.
     * adds random number no sorted
     */
    private  Random rand=new Random();
    /**
     *start time(System.nanotime)
     */
    double start;
    /**
     *time which is after the sort run(System.nanotime)
     */
    double finish;

    /**
     *finish time-start time runtime of sorting
     */
    double result;

    /**
     * adds random number in array
     * @param arr no sorted array
     * @param k is number.
     */
    public void createArrays(Integer [][] arr,int k){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100 * k; j++)
                arr[i][j]=rand.nextInt(4521);
        }
    }

    /**
     * no returns.
     * dont to change main array. So assigns main array values another array
     * runs sort method for 10 array same size
     * determine start time
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param l is number.to determine array size
     */
    public void heap(Integer [][] arr,int l){
        Integer arr1[][]=new Integer[10][100*l];
        for(int j=0;j<10;j++)
            for(int k=0;k<100*l;k++)
                arr1[j][k]=arr[j][k];

        for(int i=0;i<10;++i){
            start=System.nanoTime();
            HeapSort.sort(arr1[i]);
            finish=System.nanoTime();
            result=finish-start;
            System.out.println("runtime method is--->  "+result/1000000);
        }
    }
    /**
     * no returns.
     * dont to change main array. So assigns main array values another array
     * runs sort method for 10 array same size
     * determine start time
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param l is number.to determine array size
     */
    public void insertion(Integer [][] arr,int l){
        Integer arr1[][]=new Integer[10][100*l];
        for(int j=0;j<10;j++)
            for(int k=0;k<100*l;k++)
                arr1[j][k]=arr[j][k];

        for(int i=0;i<10;++i){
            start=System.nanoTime();
            InsertionSort.sort(arr1[i]);
            finish=System.nanoTime();
            result=finish-start;
            System.out.println("runtime method is--->  "+result/1000000);
        }
    }
    /**
     * no returns.
     * dont to change main array. So assigns main array values another array
     * runs sort method for 10 array same size
     * determine start time
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param l is number.to determine array size
     */
    public void merge(Integer [][] arr,int l){
        Integer arr1[][]=new Integer[10][100*l];
        for(int j=0;j<10;j++)
            for(int k=0;k<100*l;k++)
                arr1[j][k]=arr[j][k];

        for(int i=0;i<10;++i){
            start=System.nanoTime();
            MergeSort.sort(arr1[i]);
            finish=System.nanoTime();
            result=finish-start;
            System.out.println("runtime method is--->  "+result/1000000);
        }
    }
    /**
     * no returns.
     * dont to change main array. So assigns main array values another array
     * runs sort method for 10 array same size
     * determine start time
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param l is number.to determine array size
     */
    public void quick(Integer [][] arr,int l){
        Integer arr1[][]=new Integer[10][100*l];
        for(int j=0;j<10;j++)
            for(int k=0;k<100*l;k++)
                arr1[j][k]=arr[j][k];

        for(int i=0;i<10;++i){
            start=System.nanoTime();
            QuickSort.sort(arr1[i]);
            finish=System.nanoTime();
            result=finish-start;
            System.out.println("runtime method is--->  "+result/1000000);
        }
    }

    /**
     * no returns. void
     * dont to change main array. So assigns main array values in linkedlist
     * sorts array with custom merge sorts (with Double linked list)
     * determine start time
     * runs sort method for 10 array same size
     * determine finish time
     * calculates result time(finish-start)
     * prints result.
     * @param arr sorted array(big to small)
     * @param l is number.to determine array size
     */
    public void mergeDll(Integer [][] arr,int l){
        LinkedList ls[];
        ls=new LinkedList[10];
        for(int i=0;i<10;i++)
            ls[i]=new LinkedList();
        for(int j=0;j<10;j++)
            for(int k=0;k<100*l;k++)
                ls[j].add(arr[j][k]);

        for(int i=0;i<10;++i) {
                start = System.nanoTime();
                MergeSortDll.mergeSort(ls[i]);
                finish = System.nanoTime();
                result = finish - start;
                System.out.println("runtime method is--->  " + result / 1000000);
            }
    }
}
