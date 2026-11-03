package com.terrain.model.feature;

import com.terrain.model.TerrainMap;
import com.terrain.model.feature.parameter.BooleanParameter;
import com.terrain.model.feature.parameter.CoordinateParameter;
import com.terrain.model.feature.parameter.NumberParameter;
import com.terrain.model.feature.parameter.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// A feature the user added (river, mountain, ...). Each instance owns its own parameters.
// To add a new feature: extend this, declare parameters with number()/coordinate()/bool(), implement apply(),
// then add it to FeatureType.
public abstract class Feature {
    private final List<Parameter> parameters = new ArrayList<>();

    public abstract String getName();

    // Must take all randomness from `random` (never Math.random()) so the same seed gives the same map.
    public abstract void apply(TerrainMap map, Random random);

    public List<Parameter> getParameters() {
        return parameters;
    }

    // Called when the world size changes or is set, so that coordinate parameters can clamp to the new size.
    public void setMapSize(int width, int height) {
        for (Parameter parameter : parameters) {
            if (parameter instanceof CoordinateParameter coordinate) {
                coordinate.setMapSize(width, height);
            }
        }
    }

    // Helper methods for subclasses to declare parameters.
    protected NumberParameter number(String label, double value, double min, double max) {
        return add(new NumberParameter(label, value, min, max));
    }

    protected CoordinateParameter coordinate(String label, double x, double y) {
        return add(new CoordinateParameter(label, x, y));
    }

    protected BooleanParameter bool(String label, boolean value) {
        return add(new BooleanParameter(label, value));
    }

    private <P extends Parameter> P add(P parameter) {
        parameters.add(parameter);
        return parameter;
    }
}
