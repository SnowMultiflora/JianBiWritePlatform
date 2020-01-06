package com.pojo;

public class News {
	private String nid;
	private String ntitle;
	private String ndate;
	private String ncontent;
	private String cid;
	private String author;
	private String  result;
	private String tex;
	private String teacher;
	
	public News(String nid, String ntitle, String ndate, String ncontent, String cid, String author, String result,
			String tex, String teacher) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ndate = ndate;
		this.ncontent = ncontent;
		this.cid = cid;
		this.author = author;
		this.result = result;
		this.tex = tex;
		this.teacher = teacher;
	}


	public String getTeacher() {
		return teacher;
	}


	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}


	public String getTex() {
		return tex;
	}


	public void setTex(String tex) {
		this.tex = tex;
	}


	public String getNid() {
		return nid;
	}
	

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public News(String nid, String ntitle, String ndate, String ncontent, String cid, String author,String result) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ndate = ndate;
		this.ncontent = ncontent;
		this.cid = cid;
		this.author = author;
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((ncontent == null) ? 0 : ncontent.hashCode());
		result = prime * result + ((ndate == null) ? 0 : ndate.hashCode());
		result = prime * result + ((nid == null) ? 0 : nid.hashCode());
		result = prime * result + ((ntitle == null) ? 0 : ntitle.hashCode());
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
		News other = (News) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (ncontent == null) {
			if (other.ncontent != null)
				return false;
		} else if (!ncontent.equals(other.ncontent))
			return false;
		if (ndate == null) {
			if (other.ndate != null)
				return false;
		} else if (!ndate.equals(other.ndate))
			return false;
		if (nid == null) {
			if (other.nid != null)
				return false;
		} else if (!nid.equals(other.nid))
			return false;
		if (ntitle == null) {
			if (other.ntitle != null)
				return false;
		} else if (!ntitle.equals(other.ntitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", ntitle=" + ntitle + ", ndate=" + ndate + ", ncontent=" + ncontent + ", cid="
				+ cid + ", author=" + author + "]";
	}

	public News(String ntitle, String ndate, String cid) {
		super();
		this.ntitle = ntitle;
		this.ndate = ndate;
		this.cid = cid;
	}
	
	public News(String ntitle, String ndate) {
		super();
		this.ntitle = ntitle;
		this.ndate = ndate;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
