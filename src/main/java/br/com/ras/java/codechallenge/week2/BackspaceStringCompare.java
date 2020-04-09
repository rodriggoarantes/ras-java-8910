package br.com.ras.java.codechallenge.week2;

import java.util.Stack;

/**
 * Backspace String Compare
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 *     1 <= S.length <= 200
 *     1 <= T.length <= 200
 *     S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 *     Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {

    public boolean solution(String S, String T) {
        S = this.empilharLetras(S);
        T = this.empilharLetras(T);
        return (S).equals(T);
    }

    public String empilharLetras(String texto) {
        final Stack<Character> pilha = new Stack();
        for (char c: texto.toCharArray()) {
            if (c != '#') {
                pilha.push(c);
            } else if (!pilha.empty()) {
                pilha.pop();
            }
        }
        return String.valueOf(pilha);
    }

    public boolean alternative(String S, String T) {
        if (S.length() < 1 || S.length() > 200 || T.length() < 1 || T.length() > 200) {
            return false;
        }

        S = backspace(S);
        T = backspace(T);
        return S.equals(T);
    }

    public static String backspace(String str) {
        while (str.contains("#"))
            str = str.replaceAll("^#+|[^#]#", "");
        return str;
    }
}
