package com.terrain.use_case.save_data;

import com.terrain.entity.model.TerrainMap;
import com.terrain.use_case.terrain_cleanup.TerrainCleanupOutputData;

public interface SaveDataOutputBoundary {
    void prepareSaveView(String saveMessage);
    void prepareLoadView(TerrainMap loadedMap);
}
