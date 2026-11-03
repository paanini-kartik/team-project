package com.terrain.model.feature;

import com.terrain.model.TerrainMap;
import com.terrain.model.feature.parameter.BooleanParameter;
import com.terrain.model.feature.parameter.NumberParameter;

import java.util.Random;

public class MountainFeature extends Feature {
    private final NumberParameter height = number("Height", 100, 10, 1000);
    private final NumberParameter radius = number("Radius", 50, 1, 500);
    private final BooleanParameter snowCap = bool("Snow cap", true);
    // I actually don't like the idea of snow caps being a boolean, but it's a simple example for now.

    @Override
    public String getName() {
        return "Mountain";
    }

    @Override
    public void apply(TerrainMap map, Random random) {
        // TODO: raise elevation around the peak
    }
}
