package basic_bean_configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *  Create an XML file that will instantiate a basic_bean_configuration.Person object. In basic_bean_configuration.App.java get a
 *  basic_bean_configuration.Person object (person bean in spring) from the spring container. We need some
 *  Java code which will create a Spring bean container, which will then read the
 *  XML, and instantiate this person object.  We are creating a Java class that is
 *  specified in sping-beans jar file. We're telling that to read some XML that we write
 *  ourselves, and we're doing some stuff with it, using this the spring-context API.
 */
public class App 
{
    public static void main( String[] args ) {
        /** ApplicationContext is a bean container that can instantiate beans
         * and we can fetch those beans on this container. We can choose varieties
         * of this container.
         */
        ApplicationContext context = new FileSystemXmlApplicationContext("src\\main\\java\\beans\\bean.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("src\\main\\java\\beans\\bean.xml");

        Person person = (Person) context.getBean("person");
        person.speak();

        System.out.println(person);

        ((FileSystemXmlApplicationContext)context).close();
        //((ClassPathXmlApplicationContext)context).close();

    }
}
