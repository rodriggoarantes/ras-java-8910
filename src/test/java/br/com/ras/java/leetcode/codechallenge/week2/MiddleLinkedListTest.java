package br.com.ras.java.leetcode.codechallenge.week2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MiddleLinkedListTest {

    private final MiddleLinkedList middleLinkedList = new MiddleLinkedList();

    @Test
    public void solution_teste_1() {
        MiddleLinkedList.ListNode head = MiddleLinkedList.Builder.get().builder(new int[]{1,2,3,4,5});
        MiddleLinkedList.ListNode middle = middleLinkedList.solution(head);
        assertThat(middle.val, equalTo(3));
    }


}