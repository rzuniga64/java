package java_lessons.lesson27_javabean_programming;

import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.beans.MethodDescriptor;
import java.lang.reflect.Method;

/**
 * The type TempInfo.
 */
public class TempInfo extends SimpleBeanInfo {

    /**
     * getPropertyDescriptors
     *
     * @return PropertyDescriptor[], a special type used with BeanInfo classes
     */
    public PropertyDescriptor[] getPropertyDescriptors() {

        try {
            // Property descriptor to hold information about the temp property from Temperature class.
            PropertyDescriptor temp = new PropertyDescriptor("temp", Temperature.class);
            PropertyDescriptor pd[] = {temp};
            return pd;
        } catch (Exception e) {
            System.out.println("Exception thrown.");
        }
        return null; // must return something or it won't compile
    }

    /**
     * getMethodDescriptors
     * Add a method descriptor, method so we can get a description of the methods that are part of a javabean class.
     *
     * @return the MethodDescriptor[]
     */
    public MethodDescriptor[] getMethodDescriptors() {

        try {
            Class c1 = Temperature.class;
            // will hold the parameters for our methods. In this case because we have no method parameters it is an
            // empty object.
            Class args[] = {};

            // create a Method object that is obtained by calling the getMethod method of Class object cl
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
