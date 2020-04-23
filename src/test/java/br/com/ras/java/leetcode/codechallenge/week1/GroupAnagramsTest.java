package br.com.ras.java.leetcode.codechallenge.week1;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupAnagramsTest {

    private final GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    public void test_solution() {
        final String[] palavras = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> resposta = groupAnagrams.solution(palavras);
        resposta.sort((e1, e2) -> e2.size() - e1.size() );

        assertThat(resposta.size(), equalTo(3));
        assertThat(resposta.get(0), hasItems("ate","eat","tea"));
        assertThat(resposta.get(1), hasItems("nat","tan"));
        assertThat(resposta.get(2), hasItem("bat"));
    }
}