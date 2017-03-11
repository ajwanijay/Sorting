import java.util.Queue;

public class Sorting {

    private static int k;

    static void bubblesort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {

                if (arr[i] > arr[j]) {
                    swap(arr, i, j);

                }
            }
        }
    }

    static void swap(int[] arr, int x, int y) {
        int temp = 0;
        temp = arr[y];
        arr[y] = arr[x];
        arr[x] = temp;

    }

    // -------------------
    public static void Selectionsort(int[] arr) {

        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minIndex)
                    minIndex = arr[j];

                if (i != minIndex)
                    swap(arr, i, minIndex);
            }
        }
    }

    static void mergesort(int[] arr) {
        mergesortAux(arr, 0, arr.length - 1);
    }

    static void mergesortAux(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        mergesortAux(arr, low, mid);
        mergesortAux(arr, mid + 1, high);
        merge(arr, low, high);

    }

    private static void merge(int[] arr, int low, int high) {
        // TODO Auto-generated method stub
        int mid = (low + high) / 2;
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid = 1;
        int index = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;

            // others
            while (i <= mid)
                temp[index++] = arr[i++];
            while (j <= high)
                temp[index++] = arr[j++];

            i = low;

            for (int k = 0; k < arr.length; k++) {
                arr[i++] = temp[k];
            }

        }
    }

    public static void Quicksort(int[] arr, int i, int j) {

        if (i < j) {
            int pos = partition(arr, i, j);

            Quicksort(arr, i, pos - 1);
            Quicksort(arr, pos + 1, j);

        }
    }

    public static int partition(int[] arr, int i, int j) {
        int pivot = arr[j];
        int wall = i - 1;

        for (int k = i; k < j; k++) {
            if (wall <= pivot) {
                wall++;
                swap(arr, k, wall);
            }
        }
        swap(arr, j, wall++);
        return wall + 1;


    }

    //----------------------------------------------

    static int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
    }

    public static int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }


    static boolean binarysearchrecursive(int[] arr, int x, int low, int high) {

        if (low > high)
            return false;
        int mid = (low + high / 2);

        if (arr[mid] == x)
            return true;
        if (arr[mid] < x) {
            return binarysearchrecursive(arr, x, mid + 1, high);
        } else {
            return binarysearchrecursive(arr, x, low, mid - 1);
        }
    }

    static boolean BinSearchRecursive(int[] arr, int x) {
        return binarysearchrecursive(arr, x, 0, arr.length - 1);
    }

    //---------------------------


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = new int[]{5, 7, 1, 2, 4, 8, 9};
        // bubblesort(arr);
        //Selectionsort(arr);
        //mergesort(arr);
        Quicksort(arr, 5, 9);
        //	findKthLargest(nums , 3);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);


    }


}
