package com.terrain.model;

import com.terrain.model.feature.parameter.CoordinateParameter;
import java.util.*;


public class Path {
    private final int[] start;
    private final int[] end;
    private int width;

    public Path(int[] start, int[] end, int width) {
        this.start = start;
        this.end = end;
        this.width = width;
    }

    public List<int[]> generate(int seed, TerrainMap map) {
        Random random = new Random();
        random.setSeed(seed);
        int[] curr = start.clone();
        ArrayList<int[]> path = new ArrayList<>();
        while (curr[0] != end[0] || curr[1] != end[1]) {
            int xdir = end[0]-curr[0];
            int ydir = end[1]-curr[1];
            boolean moveX;
            if (xdir == 0) {
                moveX = false;
            } else if (ydir == 0) {
                moveX = true;
            } else {
                moveX = random.nextInt(Math.abs(xdir) + Math.abs(ydir)) < Math.abs(xdir);
            }
            if (moveX) {
                curr[0] += Integer.signum(xdir);
            } else {
                curr[1] += Integer.signum(ydir);
            }
            path.add(curr.clone());
        }
        return path;
    }

    public static void main(String[] args) {
        Path path = new Path(new int[]{0, 0}, new int[]{420, 100}, 3);
        for (int[] p : path.generate(42, new TerrainMap(1024,1024))) {
            System.out.println(Arrays.toString(p));
        }
    }
}
