
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

    for (int l = 0, e = 0, r = arr.length - 1; e <= r;) {
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

  public static void swap(boolean[] arr, int i, int j) {
    boolean tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /* 
   * Assuming that keys take one of three values, reorder the array so that all objects with
   * the same key appear together. The order of the subarrays is not important.
   */
  public static void variant1(int[] arr) {      // assuming the three values are 0, 1, 2
    for (int l = 0, e = 0, r = arr.length - 1; e < r;) {
      if (arr[e] == 0) {
        swap(arr, e, l);
        l++; e++;
      } else if (arr[e] == 1) {
        e++;
      } else {
        swap(arr, e, r);
        r--;
      }
    }
  }

  /* 
   * Given an array A of n objects with keys that takes one of four values, reorder the array
   * so that all objects that have the same key appear together. Use O(1) additional space and
   * O(n) time
   */
  public static void variant2(int[] arr) {    // assuming the three values are 0, 1, 2, 3
    int p = variant2Helper(arr, 0, arr.length - 1, 1);
    variant2Helper(arr, p, arr.length - 1, 2);
  }

  private static int variant2Helper(int[] arr, int i, int j, int pivot) {
    int l = i, e = i, r = j;
    for (; e <= r;) {
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
    return e;
  }

  /* 
   * Given an array A of n objects with Boolean-valued keys, reorder the array so that objects
   * that have the key false appear first. Use O(1) additional space and O(n) time.
   */
  public static void variant3(boolean[] arr) {
    for (int i = 0, j = arr.length - 1; i < j;) {
      if (arr[j] == false) {
        swap(arr, i++, j);
      } else {
        j--;
      }
    }
  }

  /* 
   * Given an array A of n objects with Boolean-valued keys, reorder the array so that objects
   * that have the key false appear first. The relative ordering of objects with key true should
   * not change. Use O(1) additional space and O(n) time.
   * F F F T F F T
   * T T T F T T F
   * T T T F T T T
   */
  public static void variant4(boolean[] arr) {
    for (int i = arr.length - 1, j = arr.length - 1; j >= 0 && i >= 0;) {
      if (j < i && arr[j] == true && arr[i] == false) {
        swap(arr, i--, j--);
      } else if (arr[i] == true) {
        i--;
      } else {
        j--;
      }
    }
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

    System.out.println("=====================");

    int[] arr3 = new int[]{0,1,2,0,2,1,1};
    variant1(arr3);
    for (int e : arr3) {
      System.out.println(e);
    }

    System.out.println("=====================");

    int[] arr4 = new int[]{0,2,3,1,2,3,0,2,1,0,3,1};
    variant2(arr4);
    for (int e : arr4) {
      System.out.println(e);
    }

    System.out.println("=====================");

    boolean[] arr5 = new boolean[]{true,false,true,false,false,true,false,true,true,false,false,true};
    variant3(arr5);
    for (boolean e : arr5) {
      System.out.println(e);
    }

    System.out.println("=====================");

    boolean[] arr6 = new boolean[]{true,false,true,false,false,true,false,true,true,false,false,true};
    variant4(arr6);
    for (boolean e : arr6) {
      System.out.println(e);
    }

    System.out.println("=====================");

    boolean[] arr7 = new boolean[]{false,false,false,true,false,false,true};
    variant4(arr7);
    for (boolean e : arr7) {
      System.out.println(e);
    }

    System.out.println("=====================");

    boolean[] arr8 = new boolean[]{true,true,true,false,true,true,false};
    variant4(arr8);
    for (boolean e : arr8) {
      System.out.println(e);
    }

    System.out.println("=====================");

    boolean[] arr9 = new boolean[]{true,true,true,false,true,true,true};
    variant4(arr9);
    for (boolean e : arr9) {
      System.out.println(e);
    }
  }
}
