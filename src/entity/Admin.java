package entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = -8636725672050581611L;
	private Integer idstaff;
	private String sname;
	private String saccount;
	private String spassword;
	
	public Admin() {
		
	}
	
	public Admin(int idstaff, String sname, String Saccount, String Spwd ) {
		super();
		this.idstaff = idstaff;
		this.sname = sname;
		saccount = Saccount;
		spassword = Spwd;
	}
	
	public Integer getIdstaff() {
		return idstaff;
	}
	public void setIdstaff(Integer idstaff) {
		this.idstaff = idstaff;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getSaccount() {
		return saccount;
	}
	public void setSaccount(String Saccount) {
		saccount = Saccount;
	}
	
	public String getSpassword() {
		return spassword;
	}
	public void setSpwd(String Spwd) {
		this.spassword = Spwd;
	}
	
	@Override
	public String toString() {
		return "Staff [id=" + idstaff + ", name=" + sname + ", account=" + saccount + ", pwd=" + spassword + "]";
	}

}
