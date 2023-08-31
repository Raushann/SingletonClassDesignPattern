package BreakSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WaysTOBreak {
    public static void main(String[] args) throws Exception {
        Singleton originalSingletonInstance =  Singleton.getInstance();
        Singleton duplicateSingletonInstance =  Singleton.getInstance();
        
        System.out.println("Hash Code for originalSingletonInstance is : "+ originalSingletonInstance.hashCode());
        System.out.println("Hash Code for duplicateSingletonInstance is : "+ duplicateSingletonInstance.hashCode());

        System.out.println("---------Breaking Using Reflection---------");

        // Reflection
        
        Class <?> singletonClass = Class.forName("SingletonPractice.Singleton");
        Constructor<Singleton> constructor = (Constructor<Singleton>) singletonClass.getDeclaredConstructor();
        
        constructor.setAccessible(true);
        Singleton brokenSingletonUsingReflection = constructor.newInstance();
        System.out.println("Hash Code for brokenSingletonUsingReflection is : "+ brokenSingletonUsingReflection.hashCode());

        System.out.println("---------Breaking Using Serialization---------");

        //Serialization
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/raushankumar/Downloads/Serialization.ser"));
        objectOutputStream.writeObject(originalSingletonInstance);
        objectOutputStream.close();

        //deserialization
        
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/raushankumar/Downloads/Serialization.ser"));
        Singleton brokenSingletonUsingSerialization = (Singleton) objectInputStream.readObject();

        System.out.println("Hash Code for brokenSingletonUsingSerialization is : "+ brokenSingletonUsingSerialization.hashCode());

        System.out.println("---------Breaking Using Cloning---------");
        Singleton brokenSingletonUsingCloning= (Singleton) originalSingletonInstance.clone();
        System.out.println("Hash Code for brokenSingletonUsingCloning is : "+ brokenSingletonUsingCloning.hashCode());







    }
}
