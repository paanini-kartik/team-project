package com.terrain.interface_adapter.save_data;

import com.terrain.entity.model.TerrainMap;
import com.terrain.entity.model.feature.FeatureType;
import com.terrain.generation.GenerationSettings;
import com.terrain.generation.TerrainGenerator;
import com.terrain.ui.MapView;
import com.terrain.ui.SettingsPanel;
import com.terrain.use_case.save_data.SaveDataInputBoundary;
import com.terrain.use_case.save_data.SaveDataOutputBoundary;

import java.io.File;

public class SaveDataController {
    private final SaveDataInputBoundary saveDataInteractor;
    private final TerrainGenerator generator = new TerrainGenerator();
    private final TerrainMap map;

    public SaveDataController(SaveDataInputBoundary saveDataInteractor, GenerationSettings settings) {
        this.saveDataInteractor = saveDataInteractor;
        generator.generate(settings);
        this.map = generator.map;
    }

    public void onSave(File file) {
        saveDataInteractor.save(map, file);
    }

    public void onLoad(File file) {
        saveDataInteractor.load(file);
    }
}
