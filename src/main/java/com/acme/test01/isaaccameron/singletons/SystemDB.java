package com.acme.test01.isaaccameron.classes;

public class SystemDB {
    private static SystemDB ourInstance;
    //protected

    public static SystemDB getInstance() {
        if (ourInstance == null){
            ourInstance = new SystemDB();
        }
        return ourInstance;
    }

    private SystemDB() {
    }
}
