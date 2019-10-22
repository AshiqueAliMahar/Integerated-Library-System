package BeanClasses;

import Frames.AdminLibrarian.AdminForgotPass;

public class Librarian {

    private String LibId;
    private String LibName;
    private String LibPassword;
    private String LibCNIC;
    private String LibAddress;
    private String LibContactNo;
    private String LibEmail;
    private String LibType;
    private byte[] LibPic;
    private String Gender;
    public static enum LibrarianRoles {Admin,Librarian};
    public Librarian() {

    }

    public Librarian(String LibId, String LibName, String LibPassword, String LibCNIC, String LibAddress, String LibContactNo, String LibEmail, String LibType, byte [] LibPic, String Gender) {
        this.LibId = LibId;
        this.LibName = LibName;
        this.LibPassword = LibPassword;
        this.LibCNIC = LibCNIC;
        this.LibAddress = LibAddress;
        this.LibContactNo = LibContactNo;
        this.LibEmail = LibEmail;
        this.LibType = LibType;
        this.LibPic = LibPic;
        this.Gender = Gender;
    }

    public String getLibId() {
        return LibId;
    }

    public void setLibId(String LibId) {
        this.LibId = LibId;
    }

    public String getLibName() {
        return LibName;
    }

    public void setLibName(String LibName) {
        this.LibName = LibName;
    }

    public String getLibPassword() {
        return LibPassword;
    }

    public void setLibPassword(String LibPassword) {
        this.LibPassword = LibPassword;
    }

    public String getLibCNIC() {
        return LibCNIC;
    }

    public void setLibCNIC(String LibCNIC) {
        this.LibCNIC = LibCNIC;
    }

    public String getLibAddress() {
        return LibAddress;
    }

    public void setLibAddress(String LibAddress) {
        this.LibAddress = LibAddress;
    }

    public String getLibContactNo() {
        return LibContactNo;
    }

    public void setLibContactNo(String LibContactNo) {
        this.LibContactNo = LibContactNo;
    }

    public String getLibEmail() {
        return LibEmail;
    }

    public void setLibEmail(String LibEmail) {
        this.LibEmail = LibEmail;
    }

    public String getLibType() {
        return LibType;
    }

    public void setLibType(String LibType) {
        this.LibType = LibType;
    }

    public byte [] getLibPic() {
        return LibPic;
    }

    public void setLibPic(byte [] LibPic) {
        this.LibPic = LibPic;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return "Librarian{" + "LibId=" + LibId + ", LibName=" + LibName + ", LibPassword=" + LibPassword + ", LibCNIC=" + LibCNIC + ", LibAddress=" + LibAddress + ", LibContactNo=" + LibContactNo + ", LibEmail=" + LibEmail + ", LibType=" + LibType + ", LibPic=" + LibPic + ", Gender=" + Gender + '}';
    }
    
}