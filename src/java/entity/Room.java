/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Room  {
    private Integer roomId;
 
    private String roomName;
    
    private String bedNumber;
    
    private String note;
   
    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    
    public Room() {
    }

    public Room(Integer roomId, String roomName, String bedNumber, String note, Area khuCachLy) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.bedNumber = bedNumber;
        this.note = note;
        this.area = khuCachLy;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Phong{" + "roomId=" + roomId + ", roomName=" + roomName + ", bedNumber=" + bedNumber + ", note=" + note + ", khuCachLy=" + area + '}';
    }

    
}
