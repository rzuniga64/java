package interpreter;

import java.lang.reflect.*;
import javax.swing.*;

/**
 * The type Test measurement conversion.
 */
public class TestMeasurementConversion {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String questionAsked = JOptionPane.showInputDialog(frame, "What is your question");

        // Add the question to the context for analysis
        ConversionContext question = new ConversionContext(questionAsked);
        String fromConversion = question.getFromConversion();
        String toConversion = question.getToConversion();
        double quantity = question.getQuantity();

        try {
            Class tempClass = Class.forName(fromConversion);// Get class based on the from conversion string
            Constructor con = tempClass.getConstructor();   // Get the constructor dynamically for the conversion string
            Object convertFrom = con.newInstance();     // Create a new instance of the object you want to convert from

            // Define the method parameters expected by the method that will convert to your chosen unit of measure
            Class[] methodParams = new Class[]{Double.TYPE};

            // Get the method dynamically that will be needed to convert into your chosen unit of measure
            Method conversionMethod = tempClass.getMethod(toConversion, methodParams);

            // Define the method parameters that will be passed to the above method
            Object[] params = new Object[]{new Double(quantity)};

            // Get the quantity after the conversion
            String toQuantity = (String) conversionMethod.invoke(convertFrom, params);

            // Print the results
            String answerToQues = question.getResponse() + toQuantity + " " + toConversion;
            JOptionPane.showMessageDialog(null,answerToQues);
            frame.dispose();    // Closes the frame after OK is clicked

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}