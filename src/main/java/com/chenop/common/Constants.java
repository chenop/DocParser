package com.chenop.common;

/**
 * Created by Chen.Oppenhaim on 2/22/2016.
 */
public class Constants {
    public static String DATABASE_URL;
    public static String DATABASE_USER;
    public static String DATABASE_PASSWORD;

    public static Constants INSTANCE = new Constants();

    public Constants() {
        String java_env = System.getenv("JAVA_ENV");
        System.out.println("JAVA_ENV: " + java_env);

//        switch (java_env) {
//            case "production":
//            case "development": {
                DATABASE_URL = "jdbc:postgresql://ec2-107-20-148-211.compute-1.amazonaws.com:5432/devldeksv6pq1h?sslmode=require";
                DATABASE_USER = "pddyczaowlneql";
                DATABASE_PASSWORD = "BN38pmOp7RwlndHguuK4ixn0qV";
//            }
//        }
    }
}
