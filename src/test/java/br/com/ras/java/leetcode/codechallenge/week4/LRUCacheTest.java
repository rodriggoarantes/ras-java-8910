package br.com.ras.java.leetcode.codechallenge.week4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LRUCacheTest {

    @Test
    public void test_case1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        assertThat(cache.get(2), equalTo(-1));
        cache.put(4, 4);    // evicts key 1
        assertThat(cache.get(1), equalTo(-1));
        assertThat(cache.get(3), equalTo(3));
        assertThat(cache.get(4), equalTo(4));
    }

    @Test
    public void test_case2() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4); // evicts key 1
        assertThat(cache.get(1), equalTo(-1));
        assertThat(cache.get(2), equalTo(2)); // hit 2 - 2 4 3
        cache.put(1, 1); // evicts key 3
        assertThat(cache.get(3), equalTo(-1));
        cache.put(3, 3); // evicts key 4
        assertThat(cache.get(2), equalTo(2)); // hit 2 - 2 1 3
        assertThat(cache.get(1), equalTo(1)); // hit 1 - 1 2 3
        cache.put(0, 0); // evicts key 3
        assertThat(cache.get(3), equalTo(-1));
    }
}