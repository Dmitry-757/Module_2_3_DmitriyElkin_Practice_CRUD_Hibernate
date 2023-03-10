package com.Dmitry_Elkin.PracticeTaskCRUD.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="developers_tbl")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column
    private String firstName;
    @Basic
    @Column
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="developers_skills",
            joinColumns = @JoinColumn( name="developer_ID"),
            inverseJoinColumns = @JoinColumn( name="skill_ID")
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToOne
    private Specialty specialty;

    @Basic
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    public Developer(long id, String firstName, String lastName, HashSet<Skill> skills, Specialty specialty, Status status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.specialty = specialty;
        this.status = status;
    }

    public Developer(String firstName, String lastName, HashSet<Skill> skills, Specialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.specialty = specialty;
        this.status = Status.ACTIVE;
    }

    public Developer(String firstName, String lastName, Specialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.status = Status.ACTIVE;
    }

    public Developer() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(HashSet<Skill> skills) {
        this.skills = skills;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }


    public void setDeleted() {
        status = Status.DELETED;
    }

    public void setUnDeleted() {
        status = Status.ACTIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id && firstName.equals(developer.firstName) && lastName.equals(developer.lastName) && Objects.equals(skills, developer.skills) && specialty.equals(developer.specialty) && status == developer.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, skills, specialty, status);
    }

    @Override
    public String toString() {
        String skillsStr = null;
        if (skills != null){
            skillsStr = skills.stream().map(Object::toString).collect(Collectors.joining(", "));
        }
        return "Developer{" +
                "id=" + id +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", skills = " +
                skillsStr +
                ", specialty = " + (specialty != null ? specialty.getName() : "SpecialtyLess ((") +
                ", status = " + status +
                '}';
    }
}
