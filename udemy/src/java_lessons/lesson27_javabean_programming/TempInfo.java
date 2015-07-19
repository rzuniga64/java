package java_lessons.lesson27_javabean_programming;

import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.beans.MethodDescriptor;
import java.lang.reflect.Method;

public class TempInfo extends SimpleBeanInfo {
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor temp = new PropertyDescriptor("temp", Temperature.class);
            PropertyDescriptor pd[] = {temp};
            return pd;
        } catch (Exception e) {
            System.out.println("Exception thrown.");
        }
        return null;
    }

    /*
        Add a method descriptor, method so we can get a description
        of the methods that are part of a javabean class.
     */
    public MethodDescriptor[] getMethodDescriptors() {
        try {
            Class c1 = Temperature.class;
            // will hold the parameters for our methods. In this case because we
            // have to method parameters it is an empty object.
            Class args[] = {};
            Method cToF = c1.getMethod("cToF", args);
            MethodDescriptor cToFDesc = new MethodDescriptor(cToF);
            // add a method description to our MethodDescriptor object.
            cToFDesc.setShortDescription("Convert Celsius to Fahrenheit");

            Method fToC = c1.getMethod("fToC", args);
            MethodDescriptor fToCDesc = new MethodDescriptor(fToC);
            fToCDesc.setShortDescription("Convert Fahrenheit to Celsius");

            MethodDescriptor[] md = {cToFDesc, fToCDesc};
            return md;
        } catch (Exception e) {
            System.out.println("Exception thrown.");
        }
        return null;
    }
}
