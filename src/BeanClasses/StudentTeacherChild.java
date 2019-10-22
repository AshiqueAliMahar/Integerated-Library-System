package BeanClasses;

import java.io.File;
import java.sql.Date;

public class StudentTeacherChild extends StudentTeacher{

    private File picFile;
    
    public StudentTeacherChild() {
    }

    public StudentTeacherChild(File picFile) {
        this.picFile = picFile;
    }

    public StudentTeacherChild(File picFile, String IdString, String NameString, String EmailString, String PaswordString, String CNICString, Date DateOfBirthDate, String ContactNoString, String AddressString, Date DateOfAdmission, byte[] picBlob, String DepartmentName, String GenderString, String postString, String DetailsString) {
        super(IdString, NameString, EmailString, PaswordString, CNICString, DateOfBirthDate, ContactNoString, AddressString, DateOfAdmission, picBlob, DepartmentName, GenderString, postString, DetailsString);
        this.picFile = picFile;
    }

    
    
    
    public File getPicFile() {
        return picFile;
    }

    public void setPicFile(File picFile) {
        this.picFile = picFile;
    }

}
