package com.terrain.ui;

import com.terrain.generation.GenerationSettings;
import com.terrain.generation.TerrainGenerator;
import com.terrain.model.feature.FeatureType;

// Connects the UI to generation.
public class Controller {
    private final GenerationSettings settings = new GenerationSettings();
    private final TerrainGenerator generator = new TerrainGenerator();
    private final SettingsPanel settingsPanel;
    private final MapView mapView;

    public Controller(SettingsPanel settingsPanel, MapView mapView) {
        this.settingsPanel = settingsPanel;
        this.mapView = mapView;
    }

    // "New feature" button.
    public void onNewFeature(FeatureType type) {
        var feature = settings.addFeature(type);
        // Not sure if this is the best place for setMapSize.
        feature.setMapSize(settings.world.width, settings.world.height);
        settingsPanel.addFeatureSection(feature);
    }

    // Call after the world dimensions change so existing coordinate parameters clamp immediately.
    public void onWorldSizeChanged() {
        settings.features.forEach(feature -> feature.setMapSize(settings.world.width, settings.world.height));
    }

    // "Generate" button.
    public void onGenerate() {
        mapView.display(generator.generate(settings));
    }
}
