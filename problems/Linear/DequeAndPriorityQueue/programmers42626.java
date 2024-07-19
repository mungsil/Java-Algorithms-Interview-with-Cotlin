package Linear.DequeAndPriorityQueue;

import java.util.*;


public class programmers42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scv : scoville){
            pq.add(scv);
        }

        while(pq.size() >= 2 ){
            if(pq.peek() >= K ){ pq.poll(); }
            else{
                // 우선 순위 큐이므로 자동 정렬됨
                pq.add(pq.poll() + pq.poll() * 2);
                answer ++;
            }
        }

        // 항상 pq의 size는 1
        if(pq.poll() < K){
            return -1;
        }

        return answer;
    }
}
