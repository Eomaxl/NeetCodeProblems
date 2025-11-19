package org.neetcode.graph.shorestpathfinding;

import java.util.*;

/**
 * There are n airports, labeled from 0 to n - 1, which are connected by some flights. You are given an array flights where flights[i] = [from_i, to_i, price_i]
 * represents a one-way flight from airport from_i to airport to_i with cost price_i.
 * You may assume there are no duplicate flights and no flights from an airport to itself.
 *
 * You are also given three integers src, dst, and k where:
 * src is the starting airport
 * dst is the destination airport
 * src != dst
 * k is the minimum number of stops you can make (not include src and dst)
 *
 * Return the cheapest price from src to dst with at most k stops, or return -1 if it is impossible.
 *
 * Input: n = 4, flights = [[0,1,200],[1,2,100],[1,3,300],[2,3,100]], src = 0, dst = 3, k = 1
 * Output: 500
 * */

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] flight: flights) {
            edges.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1],flight[2]});
        }

        int minPrice = 0;
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0,src,0});


        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int dist = curr[0], node = curr[1], steps = curr[2];

            if(steps >= stops[node] || steps > k + 1){
                continue;
            }

            stops[node] = steps;
            if (node == dst){
                return dist;
            }
            if (!edges.containsKey(node)){
                continue;
            }
            for(int[] a: edges.get(node)){
                minHeap.offer(new int[]{dist + a[1], a[0], steps + 1});
            }
        }
        return -1;
    }
}
