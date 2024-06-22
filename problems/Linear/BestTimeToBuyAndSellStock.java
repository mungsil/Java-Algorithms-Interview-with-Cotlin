package Linear;

import java.util.*;

/**
 * 한 번의 거래로 낼 수 있는 최대 이익을 산출하라
 * 입력 [8,1,5,3,6,4]
 * 출력 5
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] prices = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(prices));
    }

    public static int solution(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
