package com.pojo;

public class Url {
private int urlid;
private String location;
private String remark;
public int getUrlid() {
	return urlid;
}
public void setUrlid(int urlid) {
	this.urlid = urlid;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((remark == null) ? 0 : remark.hashCode());
	result = prime * result + urlid;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Url other = (Url) obj;
	if (location == null) {
		if (other.location != null)
			return false;
	} else if (!location.equals(other.location))
		return false;
	if (remark == null) {
		if (other.remark != null)
			return false;
	} else if (!remark.equals(other.remark))
		return false;
	if (urlid != other.urlid)
		return false;
	return true;
}
public Url(int urlid, String location, String remark) {
	super();
	this.urlid = urlid;
	this.location = location;
	this.remark = remark;
}
public Url() {
	super();
}
@Override
public String toString() {
	return "Url [urlid=" + urlid + ", location=" + location + ", remark=" + remark + "]";
}

}
