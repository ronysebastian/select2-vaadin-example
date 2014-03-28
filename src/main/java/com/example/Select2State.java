package com.example;

import com.vaadin.shared.ui.JavaScriptComponentState;
import org.json.JSONArray;

public class Select2State extends JavaScriptComponentState {
    private JSONArray data;
    private JSONArray currentSelection;

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    public JSONArray getCurrentSelection() {
        return currentSelection;
    }

    public void setCurrentSelection(JSONArray currentSelection) {
        this.currentSelection = currentSelection;
    }
}
