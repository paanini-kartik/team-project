package com.terrain.ui;

import com.terrain.data_access.TerrainBinaryStorage;
import com.terrain.generation.GenerationSettings;
import com.terrain.interface_adapter.Controller;

import com.terrain.interface_adapter.save_data.SaveDataController;
import com.terrain.interface_adapter.save_data.SaveDataPresenter;
import com.terrain.interface_adapter.save_data.SaveDataViewModel;
import com.terrain.use_case.save_data.SaveDataInteractor;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

// Main application window and layout
public class MainView extends SplitPane {
//    Controller controller = new Controller(settingsPanel, mapView);

    private final SettingsPanel settingsPanel;
    private final MapView mapView;

    public MainView() {
        this.settingsPanel = new SettingsPanel();
        this.mapView = new MapView();
        Controller controller = new Controller(settingsPanel, mapView);
        settingsPanel.setOnAddFeature(controller::onNewFeature);
        settingsPanel.setOnRemoveFeature(controller::onRemoveFeature);
        settingsPanel.setOnGenerate(controller::onGenerate);
        TerrainBinaryStorage dataAccess = new TerrainBinaryStorage();
        SaveDataViewModel saveDataViewModel = new SaveDataViewModel();
        SaveDataPresenter saveDataPresenter = new SaveDataPresenter(saveDataViewModel);
        SaveDataInteractor saveDataInteractor = new SaveDataInteractor(dataAccess, saveDataPresenter);
        GenerationSettings settings = new GenerationSettings();
        SaveDataController saveDataController = new SaveDataController(saveDataInteractor, settings);
        settingsPanel.setOnSave(saveDataController::onSave);

        // implicit SplitPane.getItems() ...
        getItems().addAll(settingsPanel, mapView);
        setDividerPositions(0.25);
    }
}
