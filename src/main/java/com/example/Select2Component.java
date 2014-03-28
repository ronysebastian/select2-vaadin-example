package com.example;

import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.annotations.*;
import com.vaadin.ui.JavaScriptFunction;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;

@JavaScript({"//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js",
    "//cdnjs.cloudflare.com/ajax/libs/select2/3.4.5/select2.min.js", "select2-connector.js"})
public class Select2Component extends AbstractJavaScriptComponent {

    public Select2Component() {
        addFunction("onChange", new JavaScriptFunction() {
            @Override
            public void call(JSONArray arguments)
                throws JSONException {
                getState().setCurrentSelection(arguments);
                for (SelectionChangeListener listener : listeners)
                    listener.selectionChange();
            }
        });
    }

    public interface SelectionChangeListener extends Serializable {
        void selectionChange();
    }

    ArrayList<SelectionChangeListener> listeners =
        new ArrayList<SelectionChangeListener>();

    public void addSelectionChangeListener(SelectionChangeListener listener) {
        listeners.add(listener);
    }

    public void setData(JSONArray data) {
        getState().setData(data);
    }

    public JSONArray getCurrentSelection() {
        return getState().getCurrentSelection();
    }

    @Override
    public Select2State getState() {
        return (Select2State) super.getState();
    }
}
