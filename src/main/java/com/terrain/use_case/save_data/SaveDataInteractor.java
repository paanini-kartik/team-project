package com.terrain.use_case.save_data;

import com.terrain.entity.model.TerrainMap;
import com.terrain.interface_adapter.save_data.SaveDataController;

import java.io.File;
import java.io.IOException;

public class SaveDataInteractor implements SaveDataInputBoundary{
    private final DataAccessInterface dataAccess;
    private final SaveDataOutputBoundary saveDataPresenter;

    public SaveDataInteractor(DataAccessInterface dataAccess, SaveDataOutputBoundary saveDataPresenter) {
        this.dataAccess = dataAccess;
        this.saveDataPresenter = saveDataPresenter;
    }

    @Override
    public void save(TerrainMap map, File file) {
        try {
            dataAccess.save(map, file);
            saveDataPresenter.prepareSaveView("File saved successfully");
        } catch (IOException e) {
            saveDataPresenter.prepareSaveView("Error while saving TerrainMap: " + e.getMessage());
        }
    }

    @Override
    public void load(File file) {
        try {
            saveDataPresenter.prepareLoadView(dataAccess.load(file));;
        } catch (IOException e) {
            System.out.println("Error while loading TerrainMap: " + e.getMessage());
            saveDataPresenter.prepareLoadView(null);
        }
    }
}
