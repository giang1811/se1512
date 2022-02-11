/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Room  {
    private Integer roomId;
 
    private String roomName;
    
    private String badNumber;
    
    private String note;
   
    private Area khuCachLy;

    public Area getKhuCachLy() {
        return khuCachLy;
    }

    public void setKhuCachLy(Area khuCachLy) {
        this.khuCachLy = khuCachLy;
    }

    
    public Room() {
    }

    public Room(Integer roomId, String roomName, String badNumber, String note, Area khuCachLy) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.badNumber = badNumber;
        this.note = note;
        this.khuCachLy = khuCachLy;
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

    public String getBadNumber() {
        return badNumber;
    }

    public void setBadNumber(String badNumber) {
        this.badNumber = badNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Phong{" + "roomId=" + roomId + ", roomName=" + roomName + ", badNumber=" + badNumber + ", note=" + note + ", khuCachLy=" + khuCachLy + '}';
    }

    
}
