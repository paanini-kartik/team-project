package com.terrain.ui;

import com.terrain.model.feature.Feature;
import com.terrain.model.feature.FeatureType;
import com.terrain.model.feature.parameter.BooleanParameter;
import com.terrain.model.feature.parameter.CoordinateParameter;
import com.terrain.model.feature.parameter.NumberParameter;
import com.terrain.model.feature.parameter.Parameter;

// A panel that displays the settings for the terrain generator, including the world size and the list of features.
// This setup allows us to keep all toolkit code out of the model, and to keep the model code free of any toolkit
// dependencies. Basically, if we change toolkit, we only have to change this file, the MapView and MainView files,
// and the rest of the code is unaffected.
public class SettingsPanel {
    public void addFeatureSection(Feature feature) {
        // Create a new section in the UI for the feature, with its label and a list of its parameters.

        for (Parameter parameter : feature.getParameters()) {

            // Has some action for each parameter type, e.g. a slider and textbox for NumberParameter, a checkbox for
            // BooleanParameter, etc.
            switch (parameter) {
                case NumberParameter p -> {
                    // p is a NumberParameter, so you can access its methods and properties here.
                    // TODO
                }
                case CoordinateParameter p -> {
                    // TODO
                }
                case BooleanParameter p -> {
                    // TODO
                }
            }
        }
    }

    // TODO: add methods to display the world size settings, and to update the UI when features are added, removed, or
    //  reordered. Also, add methods to get the current settings from the UI and update the model.
}

