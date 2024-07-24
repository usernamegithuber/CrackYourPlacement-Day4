package CrackYourPlacementDay4;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    static class Solution {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] arr, int low, int high) {
            if (low >= high) {
                return 0;
            }
            int mid = (low + high) / 2;
            int count = mergeSort(arr, low, mid) + mergeSort(arr, mid + 1, high);
            count += countPairs(arr, low, mid, high);
            merge(arr, low, mid, high);
            return count;
        }

        private void merge(int[] arr, int low, int mid, int high) {
            List<Integer> temp = new ArrayList<>(); // temporary array
            int left = low; // starting index of left half of arr
            int right = mid + 1; // starting index of right half of arr

            // storing elements in the temporary array in a sorted manner
            while (left <= mid && right <= high) {
                if (arr[left] <= arr[right]) {
                    temp.add(arr[left]);
                    left++;
                } else {
                    temp.add(arr[right]);
                    right++;
                }
            }

            // if elements on the left half are still left
            while (left <= mid) {
                temp.add(arr[left]);
                left++;
            }

            // if elements on the right half are still left
            while (right <= high) {
                temp.add(arr[right]);
                right++;
            }

            // transferring all elements from temporary to arr
            for (int i = low; i <= high; i++) {
                arr[i] = temp.get(i - low);
            }
        }

        private int countPairs(int[] arr, int low, int mid, int high) {
            int right = mid + 1;
            int count = 0;
            for (int i = low; i <= mid; i++) {
                while (right <= high && arr[i] > 2L * arr[right]) right++;
                count += (right - (mid + 1));
            }
            return count;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums = {1, 3, 2, 3, 1};
            int result = solution.reversePairs(nums);
            System.out.println("Number of reverse pairs: " + result); // Output should be 2
        }
    }
}
