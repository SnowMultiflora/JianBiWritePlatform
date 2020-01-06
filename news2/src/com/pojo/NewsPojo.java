package com.pojo;

public class NewsPojo {
	private String nid;
	private String ntitle;
	private String ndate;
	private String ncontent;
	private String cid;
	private String cname;
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public NewsPojo(String nid, String ntitle, String ndate, String cname) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ndate = ndate;
		this.cname = cname;
	}
	public NewsPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
