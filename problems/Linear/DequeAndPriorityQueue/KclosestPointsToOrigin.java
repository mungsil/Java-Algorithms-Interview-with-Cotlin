package Linear.DequeAndPriorityQueue;

import java.util.*;

public class KclosestPointsToOrigin {
    static class Point{
        int distance;
        int[] point;

        Point(int distance, int[] point){
            this.distance = distance;
            this.point = point;
        }

    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(p-> p.distance));

        for(int[] point : points){
            int d = point[0]*point[0] + point[1]*point[1];
            pq.add(new Point(d,point));
        }

        int[][] results = new int[k][];
        for(int i=0; i<k; i++){
            results[i] = pq.poll().point;
        }
        return results;
    }


}
