package Linear.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    // 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 "인덱스"를 리턴하라
    // nums = [2,6,11,15] target = 8
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = scanner.nextInt();

        System.out.print(Arrays.toString(solution(nums, target)));
    }

    //배열처럼 인덱스를 통하여 값을 접근하려면 인덱스에 집착 -> 이중 for문 사용하게됨(비효율적)
    //값을 통해 인덱스를 알 수는 없을까? -> Map을 통해 값을 key로, value로는 인덱스를 저장하자!
    private static int[] solution(int[] nums, int target) {
        //값을 통해 인덱스를 알 수 있도록 값과 인덱스의 위치 전환
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i <nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i,numsMap.get(target - nums[i])};
            }
        }

        return null;
    }
}
