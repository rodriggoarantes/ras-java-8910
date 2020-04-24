package br.com.ras.java.leetcode.codechallenge.week4;

import java.util.*;

/**
 * LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 */
public class LRUCache {

    private final Deque<Integer> rank;
    private final Map<Integer, Integer> items;
    private int capacity;

    LRUCache(int capacity) {
        this.items = new HashMap<>(capacity);
        this.rank = new LinkedList<>();
        this.capacity = capacity;
    }

    public int size() {
        return this.rank.size();
    }

    public boolean isFull() {
        return (size() == capacity);
    }

    public void put(int key, int value) {
        this.hit(key);
        items.put(key, value);
    }

    public int get(int key) {
        final Integer item = this.items.get(key);
        if (Objects.isNull(item)) {
            return -1;
        } else {
            this.hit(key);
            return item;
        }
    }

    private void hit(int key) {
        // existe
        if (items.containsKey(key)) {
            rank.remove(key);
        } else if (isFull()) {
            // nao existe // cheio
            final Integer last = rank.getLast();
            rank.removeLast();
            items.remove(last);
        }
        rank.addFirst(key);
    }
}

