package source_code;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    //Array must be Sorted
    public static void searchElement(int a[] , int start , int end , int target){
        int mid = (start+end)/2;

        while (start <= end) {

            if(a[mid]==target) {
                System.out.println("Element " + target + " found at index : " + mid);
                break;
            } else if(a[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
            mid =(start+end)/2;
        }
        if(start>end){
            System.out.println("Element is not found");
        }
    }
    public static void main(String[] args) {
        int a[] = {10, 20, 30, 70, 100, 120, 500};
        System.out.println("Array Elements: "+Arrays.toString(a));
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Target Element To Search : ");
        int target = sc.nextInt();
        int end = a.length-1;
        System.out.println();
        searchElement(a, 0, end, target);
    }
}