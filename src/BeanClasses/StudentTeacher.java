package BeanClasses;

import java.sql.Date;

public class StudentTeacher {

    private String IdString;
    private String NameString;
    private String EmailString;
    private String PaswordString;
    private String CNICString;
    private Date DateOfBirthDate;
    private String ContactNoString;
    private String AddressString;
    private Date DateOfAdmission;
    private byte[] picBlob;
    private String DepartmentName;
    private String GenderString;
    private String postString;
    private String DetailsString;

    public StudentTeacher() {

    }

    public StudentTeacher(String IdString, String NameString, String EmailString, String PaswordString, String CNICString, Date DateOfBirthDate, String ContactNoString, String AddressString, Date DateOfAdmission, byte[] picBlob, String DepartmentName, String GenderString, String postString, String DetailsString) {
        this.IdString = IdString;
        this.NameString = NameString;
        this.EmailString = EmailString;
        this.PaswordString = PaswordString;
        this.CNICString = CNICString;
        this.DateOfBirthDate = DateOfBirthDate;
        this.ContactNoString = ContactNoString;
        this.AddressString = AddressString;
        this.DateOfAdmission = DateOfAdmission;
        this.picBlob = picBlob;
        this.DepartmentName = DepartmentName;
        this.GenderString = GenderString;
        this.postString = postString;
        this.DetailsString = DetailsString;
    }

    public String getIdString() {
        return IdString;
    }

    public void setIdString(String IdString) {
        this.IdString = IdString;
    }

    public String getNameString() {
        return NameString;
    }

    public void setNameString(String NameString) {
        this.NameString = NameString;
    }

    public String getEmailString() {
        return EmailString;
    }

    public void setEmailString(String EmailString) {
        this.EmailString = EmailString;
    }

    public String getPaswordString() {
        return PaswordString;
    }

    public void setPaswordString(String PaswordString) {
        this.PaswordString = PaswordString;
    }

    public String getCNICString() {
        return CNICString;
    }

    public void setCNICString(String CNICString) {
        this.CNICString = CNICString;
    }

    public Date getDateOfBirthDate() {
        return DateOfBirthDate;
    }

    public void setDateOfBirthDate(Date DateOfBirthDate) {
        this.DateOfBirthDate = DateOfBirthDate;
    }

    public String getContactNoString() {
        return ContactNoString;
    }

    public void setContactNoString(String ContactNoString) {
        this.ContactNoString = ContactNoString;
    }

    public String getAddressString() {
        return AddressString;
    }

    public void setAddressString(String AddressString) {
        this.AddressString = AddressString;
    }

    public Date getDateOfAdmission() {
        return DateOfAdmission;
    }

    public void setDateOfAdmission(Date DateOfAdmission) {
        this.DateOfAdmission = DateOfAdmission;
    }

    public byte[] getPicBlob() {
        return picBlob;
    }

    public void setPicBlob(byte[] picBlob) {
        this.picBlob = picBlob;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getGenderString() {
        return GenderString;
    }

    public void setGenderString(String GenderString) {
        this.GenderString = GenderString;
    }

    public String getPostString() {
        return postString;
    }

    public void setPostString(String postString) {
        this.postString = postString;
    }

    public String getDetailsString() {
        return DetailsString;
    }

    public void setDetailsString(String DetailsString) {
        this.DetailsString = DetailsString;
    }

    @Override
    public String toString() {
        return "StudentTeacher{" + "IdString=" + IdString + ", NameString=" + NameString + ", EmailString=" + EmailString + ", PaswordString=" + PaswordString + ", CNICString=" + CNICString + ", DateOfBirthDate=" + DateOfBirthDate + ", ContactNoString=" + ContactNoString + ", AddressString=" + AddressString + ", DateOfAdmission=" + DateOfAdmission + ", picBlob=" + picBlob + ", DepartmentName=" + DepartmentName + ", GenderString=" + GenderString + ", postString=" + postString + ", DetailsString=" + DetailsString + '}';
    }
    
}
