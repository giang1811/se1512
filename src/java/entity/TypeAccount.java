
package entity;

public class TypeAccount  {

  
    private Integer idLoaiTaiKhoan;
    
    private String tenLoaiTaiKhoan;

    public TypeAccount() {
    }

    public TypeAccount(Integer idLoaiTaiKhoan) {
        this.idLoaiTaiKhoan = idLoaiTaiKhoan;
    }

    public Integer getIdLoaiTaiKhoan() {
        return idLoaiTaiKhoan;
    }

    public void setIdLoaiTaiKhoan(Integer idLoaiTaiKhoan) {
        this.idLoaiTaiKhoan = idLoaiTaiKhoan;
    }

    public String getTenLoaiTaiKhoan() {
        return tenLoaiTaiKhoan;
    }

    public void setTenLoaiTaiKhoan(String tenLoaiTaiKhoan) {
        this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
    }

    @Override
    public String toString() {
        return "entity.LoaiTaiKhoan[ idLoaiTaiKhoan=" + idLoaiTaiKhoan + " ]";
    }
    
}
