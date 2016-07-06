package java_lessons.lesson27_javabean_programming;

/*
 import needed because a javabean has to be a persistent class.
 That means we have to save the state of an object at any particular
 time. We might write out the fields of a class to disk. By that we are
 saving the state of an object.
*/
import java.io.Serializable;
/*
    A javabean is a class that exposes its methods and properties_binding to
    other programs and applications. With javabean programming we can
    do component based software design. That means we can write
    independent components and then have each component look at other
    components to determine whether or not that particular component
    has method or data via a property that the component can use to
    get it's own work done. By being able to write components we can
    simply plug components in when we need them and simplify the sw
    development process.
 */
public class Temperature implements Serializable {
    public double temp;

    public Temperature() { temp =  0.0; }
    public double getTemp() { return temp; }
    public void setTemp(double t) { temp = t; }
    public void cToF() { temp = temp * (9.0/5.0) + 32.0; }
    public void fToC() { temp = (temp - 32.0) * (5.0/9.0); }
}


