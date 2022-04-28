package eu.ensup.demospringsecurity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;

@Entity
@JsonRootName("student")
public class Student
{
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastname;
    private String firstname;

    @JsonIgnore
    public Student(){}

    @JsonIgnore
    public Student(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    @JsonIgnore
    public Student(Integer id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    @JsonProperty("id")
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @JsonProperty("lastname")
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    @JsonProperty("firstname")
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    @JsonIgnore
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
