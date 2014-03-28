package com.example;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.annotations.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Theme("mytheme")
@SuppressWarnings("serial")
@StyleSheet({"//cdnjs.cloudflare.com/ajax/libs/select2/3.4.5/select2.css"})
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.example.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        final Select2Component selectComponent = new Select2Component();
        selectComponent.setWidth("400px");
        JSONArray stuff = new JSONArray();
        try {
            stuff.put(new JSONObject() {
                {
                    put("text", "GSM");
                    put("children", new JSONArray() {
                        {
                            put(new JSONObject() {
                                {
                                    put("id", "1");
                                    put("text", "900");
                                }
                            });
                            put(new JSONObject() {
                                {
                                    put("id", "2");
                                    put("text", "1800");
                                }
                            });
                        }
                    });
                }
            });

            stuff.put(new JSONObject() {
                {
                    put("text", "UMTS");
                    put("children", new JSONArray() {
                        {
                            put(new JSONObject() {
                                {
                                    put("id", "3");
                                    put("text", "1900");
                                }
                            });
                            put(new JSONObject() {
                                {
                                    put("id", "4");
                                    put("text", "2100");
                                }
                            });
                        }
                    });
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

        selectComponent.setData(stuff);

        selectComponent.addSelectionChangeListener(
            new Select2Component.SelectionChangeListener() {
                @Override
                public void selectionChange() {
                    Notification.show("Value: " + selectComponent.getCurrentSelection().toString());
                }
            }
        );

        layout.addComponent(selectComponent);
    }

}
