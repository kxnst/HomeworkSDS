package Classes;

import java.io.Serializable;

public class Student implements Serializable {
    public final int GENDER_MALE = 0;
    public final int GENDER_FEMALE = 1;

    private String surname, name, country, performance;
    private int studentBook, course, gender;

    @Override
    public String toString() {
        return "surname='" + surname +
                ", name='" + name +
                ", country='" + country +
                ", performance='" + performance +
                ", studentBook=" + studentBook +
                ", course=" + course +
                ", gender=" + gender;
    }

    public String getSurname() {
        return surname;
    }

    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Student setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPerformance() {
        return performance;
    }

    public Student setPerformance(String performance) {
        this.performance = performance;
        return this;
    }

    public int getStudentBook() {
        return studentBook;
    }

    public Student setStudentBook(int studentBook) {
        this.studentBook = studentBook;
        return this;
    }

    public int getCourse() {
        return course;
    }

    public Student setCourse(int course) {
        this.course = course;
        return this;
    }

    public int getGender() {
        return gender;
    }

    public Student setGender(int gender) {
        this.gender = gender;
        return this;
    }
}
