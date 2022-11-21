package models;
import javafx.beans.property.SimpleStringProperty;

public class Student {

    private SimpleStringProperty SName;
    private SimpleStringProperty SRegNo;

    public Student(String SName,String SRegNo) {
        this.SName = new SimpleStringProperty(SName);
        this.SRegNo = new SimpleStringProperty (SRegNo);
    }

    public String getSName() {
        return SName.get();
    }

    public String getSRegNo() {
        return SRegNo.get();
    }

    public void setSName(String SName) {
        this.SName = new SimpleStringProperty(SName);
    }

    public void setSRegNo(String SRegNo) {
        this.SRegNo =new SimpleStringProperty(SRegNo);
    }



}