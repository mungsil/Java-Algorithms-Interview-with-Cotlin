package Linear.stackAndQueue;

import java.util.*;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        // 열림괄호 저장하는 stack
        Deque<Character> stack = new ArrayDeque<>();
        // 괄호 매핑 table
        Map<Character, Character> table = new HashMap<>();
        table.put(')', '(');
        table.put(']', '[');
        table.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            if (!table.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            // s = "]" or s = "[]]" 인 경우 stack.pop() 호출 시 에러 발생 -> stack.isEmpty()로 핸들링
            else if (stack.isEmpty() || stack.pop() != table.get(s.charAt(i))) {
                return false;
            }
        }

        // 열림괄호가 닫힘 괄호보다 많을 경우 for문이 끝나도 stack.size가 0이 아님
        return stack.size() == 0;
    }
}
