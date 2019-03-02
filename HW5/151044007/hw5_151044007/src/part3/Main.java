package part3;

import part4.MergeSortDll;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double start;
        double finish;
        double result;
        LinkedList<Comparable<Integer>> list=new LinkedList();
        Random rand=new Random();
        Integer arr3[] = new Integer[10];
        for (int j = 0; j < 10; j++)
            arr3[j]=rand.nextInt(4521);
        list=new LinkedList<>();
            for(int k=0;k<10;k++)
                list.add(arr3[k]);
        System.out.println("result is---->  "+list.toString());
            start = System.nanoTime();
            MSDLinkedList.mergeSort(list);
            finish = System.nanoTime();
            result = finish - start;
            System.out.println("runtime method is not sorted--->  " + result / 1000000);

        System.out.println("result is---->  "+list.toString());
        LinkedList<Comparable<Double>> list1=new LinkedList();
        double arr4[] = new double[7];
        for (int j = 0; j < 7; j++)
            arr4[j]=rand.nextFloat();
        list=new LinkedList<>();
        for(int k=0;k<7;k++)
            list1.add(arr4[k]);
        System.out.println("result is---->  "+list1.toString());
        start = System.nanoTime();
        MSDLinkedList.mergeSort(list1);
        finish = System.nanoTime();
        result = finish - start;
        System.out.println("runtime method is not sorted--->  " + result / 1000000);

        System.out.println("result is---->  "+list1.toString());

        LinkedList<Comparable<String>> list2=new LinkedList();
        String arr5[] = new String[6];
        arr5[0]="tudors";arr5[1]="cam";arr5[2]="kitap";arr5[3]="defter";arr5[4]="hürriyet";arr5[5]="elma";
        for(int k=0;k<6;k++)
            list2.add(arr5[k]);
        System.out.println("result is---->  "+list2);
        start = System.nanoTime();
        MSDLinkedList.mergeSort(list2);
        finish = System.nanoTime();
        result = finish - start;
        System.out.println("runtime method is not sorted--->  " + result / 1000000);

        System.out.println("result is---->  "+list2);
    }

}
