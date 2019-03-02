package part4;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Integer[][] arr0 = new Integer[10][100];
        Integer arr1[][] = new Integer[10][200];
        Integer arr2[][] = new Integer[10][300];
        Integer arr3[][] = new Integer[10][400];
        Integer arr4[][] = new Integer[10][500];
        Integer arr5[][] = new Integer[10][600];
        Integer arr6[][] = new Integer[10][700];
        Integer arr7[][] = new Integer[10][800];
        Integer arr8[][] = new Integer[10][900];
        Integer arr9[][] = new Integer[10][1000];
        createTest test = new createTest();
        test.createArrays(arr0, 1);
        test.createArrays(arr1, 2);
        test.createArrays(arr2, 3);
        test.createArrays(arr3, 4);
        test.createArrays(arr4, 5);
        test.createArrays(arr5, 6);
        test.createArrays(arr6, 7);
        test.createArrays(arr7, 8);
        test.createArrays(arr8, 9);
        test.createArrays(arr9, 10);
        System.out.println("-------------------------heap sort--------------------------------\n\n");
        System.out.println("-----------------size 100------------------------\n\n");
        test.heap(arr0,1);
        System.out.println("-----------------size 200------------------------\n\n");
        test.heap(arr1,2);
        System.out.println("-----------------size 300------------------------\n\n");
        test.heap(arr2,3);
        System.out.println("-----------------size 400------------------------\n\n");
        test.heap(arr3,4);
        System.out.println("-----------------size 500------------------------\n\n");
        test.heap(arr4,5);
        System.out.println("-----------------size 600------------------------\n\n");
        test.heap(arr5,6);
        System.out.println("-----------------size 700------------------------\n\n");
        test.heap(arr6,7);
        System.out.println("-----------------size 800------------------------\n\n");
        test.heap(arr7,8);
        System.out.println("-----------------size 900------------------------\n\n");
        test.heap(arr8,9);
        System.out.println("-----------------size 1000------------------------\n\n");
        test.heap(arr9,10);

        System.out.println("-------------------insertion sort--------------------------------------\n\n");


        System.out.println("-----------------size 100------------------------\n\n");
        test.insertion(arr0,1);
        System.out.println("-----------------size 200------------------------\n\n");
        test.insertion(arr1,2);
        System.out.println("-----------------size 300------------------------\n\n");
        test.insertion(arr2,3);
        System.out.println("-----------------size 400------------------------\n\n");
        test.insertion(arr3,4);
        System.out.println("-----------------size 500------------------------\n\n");
        test.insertion(arr4,5);
        System.out.println("-----------------size 600------------------------\n\n");
        test.insertion(arr5,6);
        System.out.println("-----------------size 700------------------------\n\n");
        test.insertion(arr6,7);
        System.out.println("-----------------size 800------------------------\n\n");
        test.insertion(arr7,8);
        System.out.println("-----------------size 900------------------------\n\n");
        test.insertion(arr8,9);
        System.out.println("-----------------size 1000------------------------\n\n");
        test.insertion(arr9,10);


        System.out.println("-------------------merge sort--------------------------------------\n\n");

        System.out.println("-----------------size 100------------------------\n\n");
        test.merge(arr0,1);
        System.out.println("-----------------size 200------------------------\n\n");
        test.merge(arr1,2);
        System.out.println("-----------------size 300------------------------\n\n");
        test.merge(arr2,3);
        System.out.println("-----------------size 400------------------------\n\n");
        test.merge(arr3,4);
        System.out.println("-----------------size 500------------------------\n\n");
        test.merge(arr4,5);
        System.out.println("-----------------size 600------------------------\n\n");
        test.merge(arr5,6);
        System.out.println("-----------------size 700------------------------\n\n");
        test.merge(arr6,7);
        System.out.println("-----------------size 800------------------------\n\n");
        test.merge(arr7,8);
        System.out.println("-----------------size 900------------------------\n\n");
        test.merge(arr8,9);
        System.out.println("-----------------size 1000------------------------\n\n");
        test.merge(arr9,10);


        System.out.println("-------------------mergedll sort--------------------------------------\n\n");

        System.out.println("-----------------size 100------------------------\n\n");
        test.mergeDll(arr0,1);
        System.out.println("-----------------size 200------------------------\n\n");
        test.mergeDll(arr1,2);
        System.out.println("-----------------size 300------------------------\n\n");
        test.mergeDll(arr2,3);
        System.out.println("-----------------size 400------------------------\n\n");
        test.mergeDll(arr3,4);
        System.out.println("-----------------size 500------------------------\n\n");
        test.mergeDll(arr4,5);
        System.out.println("-----------------size 600------------------------\n\n");
        test.mergeDll(arr5,6);
        System.out.println("-----------------size 700------------------------\n\n");
        test.mergeDll(arr6,7);
        System.out.println("-----------------size 800------------------------\n\n");
        test.mergeDll(arr7,8);
        System.out.println("-----------------size 900------------------------\n\n");
        test.mergeDll(arr8,9);
        System.out.println("-----------------size 1000------------------------\n\n");
        test.mergeDll(arr9,10);



        System.out.println("-------------------quick sort--------------------------------------\n\n");

        System.out.println("-----------------size 100------------------------\n\n");
        test.quick(arr0,1);
        System.out.println("-----------------size 200------------------------\n\n");
        test.quick(arr1,2);
        System.out.println("-----------------size 300------------------------\n\n");
        test.quick(arr2,3);
        System.out.println("-----------------size 400------------------------\n\n");
        test.quick(arr3,4);
        System.out.println("-----------------size 500------------------------\n\n");
        test.quick(arr4,5);
        System.out.println("-----------------size 600------------------------\n\n");
        test.quick(arr5,6);
        System.out.println("-----------------size 700------------------------\n\n");
        test.quick(arr6,7);
        System.out.println("-----------------size 800------------------------\n\n");
        test.quick(arr7,8);
        System.out.println("-----------------size 900------------------------\n\n");
        test.quick(arr8,9);
        System.out.println("-----------------size 1000------------------------\n\n");
        test.quick(arr9,10);
    }
}
