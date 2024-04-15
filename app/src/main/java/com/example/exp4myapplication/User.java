//package com.example.exp4myapplication;
//
//public class User {
//    private final String name;
//    private final String email;
//    private final int age;
//    private final String country;
//    private final String dateOfBirth;
//    private final String gender;
//    private final boolean agreeTerms;
//
//    public User(String name, String email, int age, String country, String dateOfBirth, String gender, boolean agreeTerms) {
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.country = country;
//        this.dateOfBirth = dateOfBirth;
//        this.gender = gender;
//        this.agreeTerms = agreeTerms;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public boolean isAgreeTerms() {
//        return agreeTerms;
//    }
//}
package com.example.exp4myapplication;
public class User {
    private String name;
    private String email;
    private int age;
    private String country;
    private String dateOfBirth;
    private String gender;
    private boolean agreeTerms;
    public User(String name, String email, int age, String country, String dateOfBirth, String gender, boolean agreeTerms) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.agreeTerms = agreeTerms;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public String getCountry() {
        return country;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getGender() {
        return gender;
    }

    public boolean isAgreeTerms() {
        return agreeTerms;
    }
}
