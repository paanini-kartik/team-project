package com.terrain.ui;

// Main application window and layout
public class MainView {
    SettingsPanel settingsPanel = new SettingsPanel();
    MapView mapView = new MapView();
    Controller controller = new Controller(settingsPanel, mapView);

    // TODO: Implement the main view layout

    // Will wire UI events to the controller, e.g. "new feature" button calls controller.onNewFeature(...), etc.

}
