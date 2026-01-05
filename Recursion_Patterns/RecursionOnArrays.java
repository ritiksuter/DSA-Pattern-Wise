import java.util.ArrayList;
import java.util.List;

public class RecursionOnArrays {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        printArrayInReverse(arr, 0);
    }

    static void print(int[] arr, int index) {
        if(index == arr.length) return ;

        System.out.print(arr[index] + " ");
        print(arr, index + 1);
    }

    static void printArrayInReverse(int[] arr, int index) {
        if(index == arr.length) return ;

        printArrayInReverse(arr, index + 1);
        System.out.print(arr[index] + " ");
    }

    public static int sum(int[] arr, int index) {
        if(index == arr.length) return 0;
        return arr[index] + sum(arr, index+1);
    }

    public static boolean isSorted(int[] arr, int index) {
        if(index == arr.length - 1) return true;

        if(arr[index] > arr[index + 1]) return false;

        return isSorted(arr, index + 1);
    }

    public static boolean search(int[] arr, int index, int target) {
        if (index == arr.length) return false;

        if (arr[index] == target) return true;

        return search(arr, index + 1, target);
    }

    public static int searchIndex(int[] arr, int index, int target) {
        if (index == arr.length) return -1;
        if (arr[index] == target) return index;

        return searchIndex(arr, index + 1, target);
    }

    public static List<Integer> find(int[] arr, int index, int target) {
        List<Integer> list = new ArrayList<>();

        if(index == arr.length) return list;

        if(arr[index] == target) list.add(index);

        list.addAll((find(arr, index+1, target)));
        return list;
    }

    public static void reverseArray(int[] arr, int left, int right) {
        if(left >= right) return ;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArray(arr, left + 1, right - 1);
    }

}