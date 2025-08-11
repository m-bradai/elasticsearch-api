package com.bradai.elasticsearch.entity;

public class City {
    private String id;
    private String city;
    private String country;
    private String fullName;

    public City() {}

    public City(String id, String name, String country, String fullName) {
        this.id = id;
        this.city = name;
        this.country = country;
        this.fullName = fullName;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCity() { return city; }
    public void setName(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
