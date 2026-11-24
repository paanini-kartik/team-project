package com.terrain.entity.model.feature;

import com.terrain.entity.model.TerrainMap;
import com.terrain.entity.model.TileType;
import com.terrain.entity.model.feature.parameter.CoordinateParameter;
import com.terrain.entity.model.feature.parameter.NumberParameter;
import java.util.Random;

public class ForestFeature extends Feature {
    private final NumberParameter radius = number("Radius", 50, 1, 500);
    private final NumberParameter treeDensity = number("Tree Density", 0.5, 0.0, 1.0);
    private final NumberParameter smoothness = number("Smoothness", 0.5, 0.0, 1.0);
    private final CoordinateParameter location = coordinate("Location", 0, 0);

    @Override
    public String getName() {
        return "Forest";
    }

    @Override
    public void apply(TerrainMap map, Random random) {
        double r = radius.getValue();
        double td = treeDensity.getValue();
        double sm = smoothness.getValue();
        double x = location.getX();
        double y = location.getY();
        int width = map.getWidth();
        int height = map.getHeight();

        for (int mapX = 0; mapX < width; mapX++) {
            for (int mapY = 0; mapY < height; mapY++) {
                double distanceFromCenter = getDistance(x, y, mapX, mapY);

                // if the distance from the center is greater than the radius, skip tile
                if (distanceFromCenter > r) {
                    continue;
                }

                if (distanceFromCenter < r) {
                    map.getTile(mapX, mapY).setTreeDensity(td);
                    map.getTile(mapX, mapY).addTileType(TileType.FOREST);
                }
            }
        }
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
