package Linear.stackAndQueue;

import java.util.*;

/**
 * 중복된 문자를 제외하고 사전식 순서로 나열하라. ( 중복을 제거해서 가능한만큼 사전식 순서로 나열해라. )
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoveDuplicateLetters problem = new RemoveDuplicateLetters();

        String input = scanner.nextLine();
        System.out.println(problem.solution1(input));
    }


    private String solution1(String s) {
        for (char c : toSortedSet(s)) {
            // c를 포함한 마지막 문자까지 자르기
            String suffix = s.substring(s.indexOf(c));
            // 전체 집합과 suffix 집합이 일치하면 해당 문자를 정답에 추가한다. 이후 해당 문자를 제외하고 재귀호출한다.
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + solution1(suffix.replace(String.valueOf(c), ""));
            }
        }
        return "";
    }

    private Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>((o1, o2) -> {
            if (o1 == o2) {
                return 0;
            } else if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        });

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }
}
