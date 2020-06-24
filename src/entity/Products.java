package entity;

import java.io.Serializable;

public class Products implements Serializable {
	
	
	private static final long serialVersionUID = -8202437908910310631L;
	private String pid;
	private String type;
	private String pname;
	private int pprice;
	private int discount;
	private String origin;
	private String director;
	private String act;
	private String pdate;
	private String explain;
	
	public Products() {
		
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid=pid;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname=pname;
	}
	
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice=pprice;
	}
	
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount=discount;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin=origin;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director=director;
	}
	
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act=act;
	}
	
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate=pdate;
	}
	
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain=explain;
	}
	
	@Override
	public String toString() {
		return "Books [id=" + pid + ", type=" + type + ", name=" + pname + ", price=" + pprice
				+ ", discount=" + discount + ", origin=" + origin + ", director=" + director + ", act="
				+ act + ", date=" + pdate + ", explain=" + explain + "]";
	}


}
