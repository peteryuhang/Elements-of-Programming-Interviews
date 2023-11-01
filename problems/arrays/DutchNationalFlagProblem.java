
/* 
 * Write a program that takes an array A and an index i into A, and rearranges the
 * elements such that all elements less than A[i] (the "pivot") appear first, followed
 * by elements equal to the pivot, followed by elements greater than the pivot
 */
public class DutchNationalFlagProblem {
  public static void partitioned(int[] arr, int i) {
    int pivot = arr[i];

    int l = 0, r = arr.length - 1;

    // first pass: move the smaller items to the head
    for (; l < r;) {
      if (arr[l] >= pivot) {
        swap(arr, l, r);
        r--;
      } else {
        l++;
      }
    }

    // second pass: move the larger items to the tail
    for (r = arr.length - 1; l < r;) {
      if (arr[l] > pivot) {
        swap(arr, l, r);
        r--;
      } else {
        l++;
      }
    }
  }

  public static void partitionedOnePass(int[] arr, int i) {
    int pivot = arr[i];

    for (int l = 0, e = 0, r = arr.length - 1; e < r;) {
      if (arr[e] < pivot) {
        swap(arr, e, l);
        l++; e++;
      } else if (arr[e] == pivot) {
        e++;
      } else {
        swap(arr, e, r);
        r--;
      }
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[]{0,1,2,0,2,1,1};
    partitioned(arr1,3);
    for (int e : arr1) {
      System.out.println(e);
    }

    System.out.println("=====================");

    int[] arr2 = new int[]{0,1,2,0,2,1,1};
    partitioned(arr2,2);
    for (int e : arr2) {
      System.out.println(e);
    }
  }
}
