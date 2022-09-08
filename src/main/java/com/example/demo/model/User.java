package com.example.demo.model;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(name="spring_user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String about;
    private String username;
    private String email;
    private String password;
    private short  pubpin;
    private short  pripin;
    private LocalDate tamp;
    @Transient
    private short  age;

    public User() {
    }

    public User(String name, String about, String username, String email, String password, short pubpin, short pripin, LocalDate tamp) {
        this.name = name;
        this.about = about;
        this.username = username;
        this.email = email;
        this.password = password;
        this.pubpin = pubpin;
        this.pripin = pripin;
        this.tamp = tamp;
    }

    public User(Long id, String name, String about, String username, String email, String password, short pubpin, short pripin, LocalDate tamp) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.username = username;
        this.email = email;
        this.password = password;
        this.pubpin = pubpin;
        this.pripin = pripin;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    private String getPassword() {
        return password;
    }

    public short getAge() {
        if(tamp != null){
            return (short) Period.between(this.tamp, LocalDate.now()).getYears();
        }
        return 0;
    }

    public short getPubpin() {
        return pubpin;
    }

    public short getPripin() {
        return pripin;
    }


    public LocalDate getTamp() {
        return tamp;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public void setPubpin(short pubpin) {
        this.pubpin = pubpin;
    }

    public void setPripin(short pripin) {
        this.pripin = pripin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pubpin=" + pubpin +
                '}';
    }
}
