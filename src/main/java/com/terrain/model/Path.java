package com.terrain.model;

import com.terrain.model.feature.parameter.CoordinateParameter;
import java.util.*;


public class Path {
    private int[] start;
    private int[] end;
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
        System.out.println(map.getTile(curr[0], curr[1]).getElevation());
        while (curr[0] != end[0] || curr[1] != end[1]) {
            path.add(curr.clone());
            int dir = random.nextInt(100);
            int xdir = end[0]-curr[0];
            int ydir = end[1]-curr[1];
            if (xdir > 0) {
                curr[0] += 1;
            }
            if (ydir > 0) {
                curr[1] += 1;
            }
        }
        for (int[] p : path) {
            System.out.println(Arrays.toString(p));
        }
        return path;
    }

    public static void main(String[] args) {
        Path path = new Path(new int[]{0, 0}, new int[]{420, 10}, 3);
        System.out.println(path.generate(42, new TerrainMap(1024,1024)));
    }
}
