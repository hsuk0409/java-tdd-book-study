package com.tdd.money.singleton;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Queue;

public class TestSingleton {

    @Test
    public void testSingleton() {
        AController aController = new AController();
        BController bController = new BController();
    }

    @Test
    public void testCoding() {
        int[][] queries = new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {-1, -1}, {2, 5}, {4, 2}, {-1, -1}};
        int[][] queues = new int[4][];
        int[] flag = new int[4];
        ArrayList<Integer> result = new ArrayList<>();
        int popIndex = 0;

        for (int i = 0; i < queries.length; ++i) {
            for (int k = 0; k < queries[i].length; ++k) {
                if (queries[i][1] > 0) {
                    int flagIndex = flag[queries[i][0]]++;
                    queues[queries[i][0]][flagIndex] = queries[i][1];
                } else {
                    result.add(queues[popIndex][1]);
                    removeIndex(queues[popIndex]);
                }
            }
        }

        for (int i = 0; i < queries.length; ++i) {
            System.out.print(result.get(i) + " ");
        }
    }

    private void removeIndex(int[] queue) {
        int index = 1;

        for (int i = 0; i < queue.length; ++i) {
            queue[i] = queue[index++];
        }
    }
}
