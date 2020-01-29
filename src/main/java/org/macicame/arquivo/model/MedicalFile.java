package org.macicame.arquivo.model;

import org.hibernate.envers.Audited;
import org.macicame.arquivo.model.base.Identifiable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by acacio on 16/03/19.
 */

@Audited
@Entity
public class MedicalFile extends Identifiable {

    @Column(nullable = false, unique = true)
    private String nid;

    @Column(nullable = false)
    private Date issueDateProcessNid;

    @Column(nullable = false)
    private String sureName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Breed breed;

    @Column(nullable = false)
    private String filiation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(nullable = false)
    private String documentNumber;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Province local;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Province naturalness;

    @Column(nullable = false)
    private String residence;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String profession;

    @Column(nullable = false)
    private String workplace;

    @Column(nullable = false)
    private String remarks;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public Date getIssueDateProcessNid() {
        return issueDateProcessNid;
    }

    public void setIssueDateProcessNid(Date issueDateProcessNid) {
        this.issueDateProcessNid = issueDateProcessNid;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getFiliation() {
        return filiation;
    }

    public void setFiliation(String filiation) {
        this.filiation = filiation;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Province getLocal() {
        return local;
    }

    public void setLocal(Province local) {
        this.local = local;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Province getNaturalness() {
        return naturalness;
    }

    public void setNaturalness(Province naturalness) {
        this.naturalness = naturalness;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
