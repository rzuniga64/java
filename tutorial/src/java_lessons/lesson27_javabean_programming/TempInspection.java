package java_lessons.lesson27_javabean_programming;

import java.beans.*;

/**
 * The type TempInspection.
 */
public class TempInspection {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        try {
            Class c1 = Temperature.class;
            BeanInfo beanInfo = Introspector.getBeanInfo(c1);
            System.out.println("Properties of Temperature class: ");

            PropertyDescriptor propertyDescriptor[] = beanInfo.getPropertyDescriptors();

            for (int i = 0; i < propertyDescriptor.length; i++)
                System.out.println(propertyDescriptor[i].getName());

            System.out.println();
            System.out.println("Methods of Temperature class: ");
            MethodDescriptor methodDescriptor[] =  beanInfo.getMethodDescriptors();

            for (int i = 0; i < methodDescriptor.length; i++)
                System.out.println(methodDescriptor[i].getName());
        }
        catch (Exception e) {
            System.out.println("Exception thrown.");
        }
    }
}
