package Linear.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * 매일의 온도 리스트 temperatures를 입력받아서, 더 따뜻한 날씨를 위해서는 며칠을 더 기다려야 하는지를 출력해라.
 * 입력: temperatures = [23,24,25,21,19,22,26,23]
 * 출력: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] temperatures = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] days = solution(temperatures);
        for (int day : days) {
            System.out.print(day+" ");
        }
    }

    public static int[] solution(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();
                result[last] = i - last;
            }
            stack.push(i);
        }
        return result;
    }
}
