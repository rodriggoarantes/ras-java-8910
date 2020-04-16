package br.com.ras.java.codechallenge.week3;

/**
 * Valid Parenthesis String
 *
 *  Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether
 *  this string is valid. We define the validity of a string by these rules:
 *
 *     Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 *     Any right parenthesis ')' must have a corresponding left parenthesis '('.
 *     Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 *     '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 *     An empty string is also valid.
 *
 * Example 1:
 *  Input: "()"
 *  Output: True
 *
 * Example 2:
 *  Input: "(*)"
 *  Output: True
 *
 * Example 3:
 *  Input: "(*))"
 *  Output: True
 *
 * Note:
 *     The string size will be in the range [1, 100].
 */
public class ValidParenthesis {

    public boolean checkValidString(String s) {
        if (("").equals(s) || ("*").equals(s)) {
            return true;
        }
        if (s == null || s.length() <= 1 || s.length() > 100) {
            return false;
        }

        char[] words = s.toCharArray();
        int countOpen = 0;
        int countMaxOpen = 0;

        for (char c : words) {
            if (c == '(') {
                countOpen++;
            } else {
                countOpen--;
            }

            if (c != ')') {
                countMaxOpen++;
            } else {
                countMaxOpen--;
            }

            if (countMaxOpen < 0) {
                return false;
            }
            countOpen = Math.max(0, countOpen);
        }

        return countOpen == 0;
    }

    public boolean best(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
