package properties_binding;

/**
 * JavaFX properties_binding store the inner state of a control and allows us to listen to state change from JavaFX UI controls.
 * That means you will be able to perform an action when the value changes.
 * Types
 * Read/Writable
 * Read-only
 *
 * This whole class is a java bean which is a concept for declaring properties_binding.
 */

import javafx.beans.property.*;

public class MyNumber {

    private DoubleProperty number;

    public final double getNumber() {
        if (number != null)
            return number.get();
        return 0;
    }

    public final void setNumber(double number) {
        this.numberProperty().set(number);
    }

    public final DoubleProperty numberProperty() {
        if (number == null) {
            number = new SimpleDoubleProperty(0);
        }
        return number;
    }
}
