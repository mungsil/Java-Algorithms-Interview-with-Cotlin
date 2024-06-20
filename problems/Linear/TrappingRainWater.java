package Linear;

import java.util.Arrays;
import java.util.Scanner;

class TrappingRainWater{
    //높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산하라.
    //1 1 0 2 1 0 1 3 2 1 2 1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력:");

        /*
        //한 줄로 입력 받기
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        //convert String array to int array
        int[] height = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            height[i] = Integer.parseInt(inputArray[i]);
        }*/

        String input = scanner.nextLine();
        int[] height = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution1(height));

    }

    /**
     * 투포인터를 이용한 풀이
     */
    private static int solution1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int volume = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) { //[1,2,2,1]과 같이 고점이 두 개 이상인 상황에서 left 포인터를 먼저 이동시킴
                volume += leftMax - height[left];
                left++;
            }else {
                volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}