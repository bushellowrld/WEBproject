package entity;

import java.io.Serializable;

//用户实体类

public class Users implements Serializable {
	private static final long serialVersionUID = -8636725672050581611L;
	private int mid;
	private String mname;
	private String msex;
	private String mcity;
	private String maddress;
	private String mpostcode;
	private String mphone;
	private String memail;
	private String maccount;
	private String mpassword;
	
	public Users() {
	}

	
	
	
	public Users(String maccount, String mpassword, String mname, String msex,String mcity,String maddress,String mpostcode, String mphone, String memail) {
		super();
		this.maccount = maccount;
		this.mpassword = mpassword;
		this.mname = mname;
		this.msex = msex;
		this.mcity = mcity;
		this.maddress = maddress;
		this.mpostcode = mpostcode;
		this.mphone = mphone;
		this.memail = memail;

	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid=mid;
	}

	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname=mname;
	}
	
	public String getMsex() {
		return msex;
	}
	public void setMsex(String msex) {
		this.msex=msex;
	}
	
	public String getMcity() {
		return mcity;
	}
	public void setMcity(String mcity) {
		this.mcity=mcity;
	}
	
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress=maddress;
	}
	
	public String getMpostcode() {
		return mpostcode;
	}
	public void setMpostcode(String mpostcode) {
		this.mpostcode=mpostcode;
	}
	
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone=mphone;
	}
	
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail=memail;
	}
	
	public String getMaccount() {
		return maccount;
	}
	public void setMaccount(String maccount) {
		this.maccount=maccount;
	}
	
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword=mpassword;
	}

	@Override
	public String toString() {
		return "Users [id=" + mid + ", LoginId=" + maccount + ", LoginPwd=" + mpassword + ", name=" + mname + ",sex="+ msex+",city= "+ mcity+ ", address="
				+ maddress + ",postcode= "+ mpostcode+ ", phone=" + mphone + ", mail=" + memail + "]";
	}
	
}
