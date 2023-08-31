package BreakSingleton;

import java.io.Serializable;

public class Singleton  implements Serializable ,Cloneable{
    private static final long serialVersionUID = 1L;//default serial VersionID

    private static Singleton singleton;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();

        }
        return singleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
