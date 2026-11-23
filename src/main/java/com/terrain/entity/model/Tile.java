package com.terrain.entity.model;
import java.util.List;

public class Tile {
    private double elevation;
    private String color; // color of grass? format will be in hex codes but this can change
    private double treeDensity;
    private List<TileType> type; // TODO: Make it possible for a tile to have multiple types
    private TileType finalType; // Type after elevation has been considered.

    public Tile() {
        elevation = 0;
        color = "008000";
        treeDensity = 0.0;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTreeDensity() {
        return treeDensity;
    }

    public void setTreeDensity(double treeDensity) {
        this.treeDensity = treeDensity;
    }

    public void addTileType(TileType type) {
        this.type.add(type);
    }

    public List<TileType> getTileType() {
        return type;
    }

    // TODO: MAYBE: Add other properties like moisture, temperature, etc. depending on the needs of the terrain
    //  generation. or, Tile.type could use an enum that includes different types of terrain (e.g., water, grass,
    //  stone, etc.)
}
