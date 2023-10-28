package com.alimama.mealgpt.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fitness_info")
public class FitnessInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userName")
    private String userName;
    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "goal")
    private String goal;

    @Column(name = "bio_gender")
    private String bioGender;

    @Column(name = "age")
    private int age;

    @Column(name = "activity_level")
    private String activityLevel;

    // Constructor
    public FitnessInfo () {}

    public FitnessInfo(String userName, double height, double weight, String goal,
                       String bioGender, int age, String activityLevel) {
        this.userName = userName;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
        this.bioGender = bioGender;
        this.age = age;
        this.activityLevel = activityLevel;
    }

    // Getter Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getBioGender() {
        return bioGender;
    }

    public void setBioGender(String bioGender) {
        this.bioGender = bioGender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }


    // toString

    @Override
    public String toString() {
        return "FitnessInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", goal='" + goal + '\'' +
                ", bioGender='" + bioGender + '\'' +
                ", age=" + age +
                ", activityLevel='" + activityLevel + '\'' +
                '}';
    }
}
