package entity;

import java.util.Date;

public class Patient {

    private Integer patientId;

    private String patientName;

    private Integer age;

    private String passPort;

    private String gender;

    private String addree;

    private Integer phoneNumber;

    private String region;

    private String suspicionLevel;

    private Date timeIn;

    private Date timeOut;

    private Room room;

    private Area area;

    public Patient() {
    }

    public Patient(Integer patientId, String patientName, Integer age, String passPort, String gender, String addree, Integer phoneNumber, String region, String suspicionLevel, Date timeIn, Date timeOut, Room phong, Area khuCachLy) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.passPort = passPort;
        this.gender = gender;
        this.addree = addree;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.suspicionLevel = suspicionLevel;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.room = phong;
        this.area = khuCachLy;
    }

    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassPort() {
        return passPort;
    }

    public void setPassPort(String passPort) {
        this.passPort = passPort;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddree() {
        return addree;
    }

    public void setAddree(String addree) {
        this.addree = addree;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSuspicionLevel() {
        return suspicionLevel;
    }

    public void setSuspicionLevel(String suspicionLevel) {
        this.suspicionLevel = suspicionLevel;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room phong) {
        this.room = phong;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area khuCachLy) {
        this.area = khuCachLy;
    }

    @Override
    public String toString() {
        String result = "Patient ID = " + patientId + "\n"
                + "Patient Name = " + patientName + "\n"
                + "Patient Phone = " + age + "\n"
                + "Patient Fullname = " + passPort + "\n"
                + "Patient Account_Id = " + gender + "\n"
                + "Patient Address = " + addree + "\n"
                + "Patient Phone Number = " + phoneNumber + "\n"
                + "Patient Region = " + region + "\n"
                + "Patient Suspicion Level = " + suspicionLevel + "\n"
                + "Patient Time In = " + timeIn + "\n"
                + "Patient Time Out = " + timeOut + "\n"
                + "Patient Room Name = " + room.getRoomName() + "\n"
                + "Patient Area Name = " + area.getAreaName() + "\n";
        return result;
    }

}
