import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class ThreeSum {

  private static List<Integer[]> findThreeSum_BruteForce(int[] nums, int target) {
    List<Integer[]> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == target) {
            result.add(new Integer[] { nums[i], nums[j], nums[k] });
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int n = keyboard.nextInt();
    int[] nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = keyboard.nextInt();
    }
    int target = keyboard.nextInt();

    keyboard.close();

    List<Integer[]> result = findThreeSum_Sorting(nums, target);

    for(Integer[] triplets: result) {
      for(int num: triplets) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}