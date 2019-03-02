package part5;

/**
 * MergeSortDll is implement by me.
 *
 */
public class Main {
    public static void main(String[] args) {
        Integer arr0[] = new Integer[100];
        Integer arr1[] = new Integer[1000];
        Integer arr2[] = new Integer[5000];
        Integer arr3[] = new Integer[10000];

        createTest test = new createTest();
        arr0 = test.createArrays(arr0, 1);
        arr1 = test.createArrays(arr1, 10);
        arr2 = test.createArrays(arr2, 50);
        arr3 = test.createArrays(arr3, 100);
        System.out.println("----------quick sort----------");
        test.quick(arr0, 1);
        test.quick(arr1, 10);
        test.quick(arr2, 50);
        test.quick(arr3, 100);
        System.out.println("\n\n\n");
        System.out.println("----------heap sort----------");
        test.heap(arr0, 1);
        test.heap(arr1, 10);
        test.heap(arr2, 50);
        test.heap(arr3, 100);
        System.out.println("\n\n\n");
        System.out.println("----------insertion sort----------");
        test.insertion(arr0, 1);
        test.insertion(arr1, 10);
        test.insertion(arr2, 50);
        test.insertion(arr3, 100);
        System.out.println("\n\n\n");
        System.out.println("----------merge sort----------");
        test.merge(arr0, 1);
        test.merge(arr1, 10);
        test.merge(arr2, 50);
        test.merge(arr3, 100);
        System.out.println("\n\n\n");
        System.out.println("----------mergedll sort----------");
        test.mergedll(arr0, 1);
        test.mergedll(arr1, 10);
        test.mergedll(arr2, 50);
        test.mergedll(arr3, 100);

    }
}
