package com.terrain.interface_adapter.save_data;

import com.terrain.entity.model.TerrainMap;
import com.terrain.use_case.save_data.SaveDataInputBoundary;
import com.terrain.use_case.save_data.SaveDataOutputBoundary;

public class SaveDataPresenter implements SaveDataOutputBoundary {
    private final SaveDataViewModel saveDataViewModel;

    public SaveDataPresenter(SaveDataViewModel saveDataViewModel) {
        this.saveDataViewModel = saveDataViewModel;
    }

    @Override
    public void prepareSaveView(String saveMessage) {
        saveDataViewModel.displayMessage(saveMessage);
    }

    public void prepareLoadView(TerrainMap loadedMap) {
        if (loadedMap == null) {
            saveDataViewModel.displayMessage("It's bwoken");
        } else {
            saveDataViewModel.displayMessage("It work");
        }
    }
}
