package com.ProductStore.entity;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clubs")
public class Clubs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "motto", nullable = false)
    private String motto;
    @Column(name = "mission", nullable = false)
    private String mission;
    @Column(name = "presidentName", nullable = false)
    private String presidentName;
    @Column(name = "presidentFacebook", nullable = false)
    private String presidentFacebook;
    @Column(name = "presidentInstagram", nullable = false)
    private String presidentInstagram;
    @Column(name = "presidentEmail", nullable = false)
    private String presidentEmail;
    @Column(name = "vicePresidentName", nullable = false)
    private String vicePresidentName;
    @Column(name = "vicePresidentFacebook", nullable = false)
    private String vicePresidentFacebook;
    @Column(name = "vicePresidentInstagram", nullable = false)
    private String vicePresidentInstagram;
    @Column(name = "vicePresidentEmail", nullable = false)
    private String vicePresidentEmail;
    @Column(name = "eventlink", nullable = false)
    private String eventLink;
    @Column(name = "adminId", nullable = false)
    private Long adminIdd;


     @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "clubs") // Bidirectional mapping with UserEntity
     @JsonIgnore
    private Set<Users> users = new HashSet<>();
    //private list<ClubEntity> clubNameList;

    public Clubs() {
    }

    public Clubs(String name, String motto, String mission, String presidentName, String presidentFacebook, String presidentInstagram, String presidentEmail, String vicepresidentName, String vicepresidentFacebook, String vicepresidentInstagram, String vicepresidentEmail, String eventLink, Long adminIdd) {
        this.name = name;
        this.motto = motto;
        this.mission = mission;
        this.presidentName = presidentName;
        this.presidentFacebook = presidentFacebook;
        this.presidentEmail = presidentEmail;
        this.vicePresidentName = vicepresidentName;
        this.vicePresidentFacebook = vicepresidentFacebook;
        this.vicePresidentInstagram = vicepresidentInstagram;
        this.vicePresidentEmail = vicepresidentEmail;
        this.eventLink = eventLink;
        this.adminIdd = adminIdd;
    }

    // Getters and setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }

    public String getPresidentFacebook() {
        return presidentFacebook;
    }

    public void setPresidentFacebook(String presidentFacebook) {
        this.presidentFacebook = presidentFacebook;
    }

    public String getPresidentInstagram() {
        return presidentInstagram;
    }

    public void setPresidentInstagram(String presidentInstagram) {
        this.presidentInstagram = presidentInstagram;
    }

    public String getPresidentEmail() {
        return presidentEmail;
    }

    public void setPresidentEmail(String presidentEmail) {
        this.presidentEmail = presidentEmail;
    }

    public String getVicePresidentName() {
        return vicePresidentName;
    }

    public void setVicePresidentName(String vicePresidentName) {
        this.vicePresidentName = vicePresidentName;
    }

    public String getVicePresidentFacebook() {
        return vicePresidentFacebook;
    }

    public void setVicePresidentFacebook(String vicePresidentFacebook) {
        this.vicePresidentFacebook = vicePresidentFacebook;
    }

    public String getVicePresidentInstagram() {
        return vicePresidentInstagram;
    }

    public void setVicePresidentInstagram(String vicePresidentInstagram) {
        this.vicePresidentInstagram = vicePresidentInstagram;
    }

    public String getVicePresidentEmail() {
        return vicePresidentEmail;
    }

    public void setVicePresidentEmail(String vicePresidentEmail) {
        this.vicePresidentEmail = vicePresidentEmail;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }

    public Long getadminIdd() {
        return adminIdd;
    }

    public void setadminIdd(Long adminIdd) {
        this.adminIdd = adminIdd;
    }

    @Override
    public String toString() {
        return "Clubs [id=" + id + ", name=" + name + ",motto=" + motto + ", mission=" + mission + ", presidentName=" + presidentName + ", presidentFacebook=" + presidentFacebook + ", presidentInstagram=" + presidentInstagram + ", presidentEmail=" + presidentEmail + ", vicePresidentName=" + vicePresidentName + ", vicePresidentFacebook=" + vicePresidentFacebook + ", vicePresidentInstagram=" + vicePresidentInstagram + ", vicePresidentEmail=" + vicePresidentEmail + ", eventLink=" + eventLink + ", adminIdd = " + adminIdd + "]";
    }
}
