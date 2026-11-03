package com.terrain.generation;

import com.terrain.model.TerrainMap;

import java.util.Random;

public class TerrainGenerator {
    // Same settings and seed always produce the same map.
    public TerrainMap generate(GenerationSettings settings) {
        TerrainMap map = new TerrainMap(settings.world.width, settings.world.height);

        // TODO: base terrain from world settings.

        for (int i = 0; i < settings.features.size(); i++) {
            settings.features.get(i).setMapSize(settings.world.width, settings.world.height);
            // Each feature gets its own Random derived from seed and index, so tweaking one feature
            // doesn't change the randomness other features see.

            // Multiplying by 31 is a cheap way to make the seeds more random. Makes it such that seed 100, feature 1 is
            // different from seed 101, feature 0, etc. 31 is just a prime number, helps with distribution.
            settings.features.get(i).apply(map, new Random(settings.seed * 31 + i));
        }
        return map;
    }
}
