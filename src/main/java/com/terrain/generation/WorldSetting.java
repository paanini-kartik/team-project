package com.terrain.generation;

// All the non-feature settings for a map; also contains default values for the map generation.
public class WorldSetting {
    public int width = 256;
    public int height = 256;
    public boolean islandMode;
    // Island mode would be a setting that makes the map generate as an island, with water around the edges.

    // Things such as water level, temperature range, moisture range, etc. can be added here as needed.
}
