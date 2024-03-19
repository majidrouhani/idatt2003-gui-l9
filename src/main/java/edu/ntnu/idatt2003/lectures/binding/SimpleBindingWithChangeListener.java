package edu.ntnu.idatt2003.lectures.binding;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SimpleBindingWithChangeListener {

    public static void main(String[] args) {

        // Define properties
        StringProperty property1 = new SimpleStringProperty("Ola");
        StringProperty property2 = new SimpleStringProperty("Martin");

        // Add change listener to property1
        property1.addListener((observable, oldValue, newValue) -> {SimpleBindingWithChangeListener.changed(property1, oldValue, newValue);});
        
        
        // Print properties
        System.out.println(property1.get() + " " + property2.get());

        // Unidirectional binding
        // property1 observes property2
        property1.bind(property2);        

        // Change property2
        property2.set("Johansen");

        // property1 cannot be changed since it is unidirectional bound to property2
        //property1.set("Kari");

        // Property1 gets same value as property2
        System.out.println(property1.get() + " " + property2.get());

        // Unbind unidirectional binding
        property1.unbind();

        // Bidirectional binding 
        // Both properties are listening to each other       
        property2.bindBidirectional(property1);

        // change property1
        property1.set("Hans");
        System.out.println(property1.get() + " " + property2.get());

        // change property2
        property2.set("Hansen");
        System.out.println(property1.get() + " " + property2.get());
    }

    public static void changed(StringProperty prop, String oldValue, String newValue) {
        System.out.println("Property changed: old = " + oldValue + ", new = " + newValue);
    }
}
