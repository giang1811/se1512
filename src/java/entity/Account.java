
package entity;
import java.util.Collection;


public class Account {

  
    private Integer accountId;
   
    private String userName;
  
    private String password;
    
    private String avatar;
    
    private TypeAccount type;
  
    private Patient patient;

    public Account() {
    }

    public Account(Integer accountId, String userName, String password, String avatar, TypeAccount type, Patient patient) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
        this.type = type;
        this.patient = patient;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public TypeAccount getType() {
        return type;
    }

    public void setType(TypeAccount type) {
        this.type = type;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", userName=" + userName + ", password=" + password + ", avatar=" + avatar + ", type=" + type + ", patient=" + patient + '}';
    }

    

}
