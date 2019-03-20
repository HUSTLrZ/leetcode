package com.lrz.leetcode.solutions;

import com.lrz.leetcode.datatypes.Point;

import java.util.HashMap;

/**
 * 平面上在一条直线上最多的点个数
 */
public class Solution4 {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length < 3) {
            return points.length;
        }

        int count = 0;
        for (int i = 0; i < points.length; i++) {
            int tmpmax = 1;
            HashMap<Double, Integer> map = new HashMap<>();
            int vcnt = 0;
            int dup = 0;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int a = points[i].x - points[j].x;
                    int b = points[i].y - points[j].y;
                    if (a == 0 && b == 0) {
                        dup++;
                    } else if (a == 0) {
                        if (vcnt == 0) {
                            vcnt = 2;
                        } else {
                            vcnt++;
                        }
                        tmpmax = Math.max(tmpmax, vcnt);
                    } else {
                        double k = (double) b / a;
                        if (map.containsKey(k)) {
                            map.put(k, map.get(k) + 1);
                        } else {
                            map.put(k, 2);
                        }
                        tmpmax = Math.max(map.get(k), tmpmax);
                    }
                }
                count = Math.max(count, tmpmax + dup);
            }
        }
        return count;
    }
}
