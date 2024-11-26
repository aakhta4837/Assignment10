import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BubblesortMergesortGeneric {

    public static <E extends Comparable<E>> void mergeSort(E[] list){
        mergeSort(list, 0, list.length);
    }

    public static <E extends Comparable<E>> void mergeSort(E[] list, int start, int end) {
        if (end - start <= 1)
            return;
        int middle = (start + end) / 2;
        mergeSort(list, start, middle);
        mergeSort(list, middle, end);
        merge(list, start, middle, end);
    }

    public static <E extends Comparable<E>> void merge(E[] list, int start, int middle, int end){
        int i=start, j=middle;
        List<E> tempArr = new ArrayList<E>();
        while(i < middle && j < end) {
            if (list[i].compareTo(list[j]) <= 0) {
                tempArr.add(list[i]);
                i++;
            } else {
                tempArr.add(list[j]);
                j++;
            }
        }

        while(i < middle){
            tempArr.add(list[i]);
            i++;
        }

        while(j < end) {
            tempArr.add(list[j]);
            j++;
        }

        for (i=start; i<end; i++){
            list[i]= tempArr.get(i-start);
        }


    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
    boolean swapped;
    for (int i = 0; i < list.length - 1; i++) {
        swapped = false;
        for (int j = 0; j < list.length - 1 - i; j++) {
            if (list[j].compareTo(list[j + 1]) > 0) {
                
                E temp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break;
    }
}


public static Integer[] RandArray (int size){
    Random random = new Random();
    Integer[] arr = new Integer[size];
    for (int i = 0; i < size; i++){
        arr[i] = random.nextInt(100);
    }
    return arr;
}



    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array you want to be sorted: ");
        int size = scanner.nextInt();
        Integer[] arr = RandArray(size);
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        Integer [] bubbleArr = arr.clone();
        Integer [] mergeArr = arr.clone();
        System.out.println("The sorted array using bubble sort is: ");
        bubbleSort(bubbleArr);
        System.out.println(Arrays.toString(bubbleArr));

        System.out.println("The sorted array using merge sort is: ");
        mergeSort(mergeArr);
        System.out.println(Arrays.toString(mergeArr));

        scanner.close();

    }
}
