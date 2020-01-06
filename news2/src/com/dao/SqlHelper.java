package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.db.DbHelper;

import com.pojo.AdminInfo;
import com.pojo.News;
import com.pojo.NewsClass;
import com.pojo.NewsPojo;
import com.pojo.Url;
import com.pojo.User;
import com.tools.DBUtil;

public class SqlHelper {
	private Connection conn=null;
	private int perPage=10;
	public SqlHelper(){
		conn=DbHelper.getConnection();
	}
	public void destroy(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//��ѯ���й���Ա��������Ϣ
	public AdminInfo queryAdminInfoById(String aid){
		String sql="select aid,aname,apwd from admininfo where aid=?";
		AdminInfo adminInfo=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,aid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				adminInfo=new AdminInfo();
				adminInfo.setAid(rs.getString("aid"));
				adminInfo.setAname(rs.getString("aname"));
				adminInfo.setApwd(rs.getString("apwd"));
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminInfo;
	}
	//����Ա��¼
	public AdminInfo checkAdminInfo(AdminInfo u){
    	Connection conn=null;
    	PreparedStatement   pstm=null;
    	ResultSet rs=null;
    	try {
			conn=DbHelper.getConnection();
			String strSQL="select * from adminInfo where aid=? and apwd=?";
			pstm=conn.prepareStatement(strSQL);
			pstm.setString(1,u.getAid() );
			pstm.setString(2, u.getApwd());
			rs=pstm.executeQuery();
			if(rs.next()){
			  String aid=rs.getString("aid");
			  String apwd=rs.getString("apwd");
			  String aname=	rs.getString("aname");
			  AdminInfo  admin=new AdminInfo(aid,apwd,aname);
			  return admin;
			}else{
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
					rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			if(pstm!=null){
				try {
					pstm.close();
					pstm=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
    	
    	return null;
    }
	//��ӹ���Ա
	public boolean insertAdmin(AdminInfo adminInfo){
		String sql="insert into admininfo(aid,aname,apwd)value(?,?,?)";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, adminInfo.getAid());
			ps.setString(2, adminInfo.getAname());
			ps.setString(3, adminInfo.getApwd());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//���������
	public boolean insertClass(NewsClass newsClass){
		String sql="insert into newsclass(cid,cname)value(?,?)";
		//System.out.println(sql);
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, newsClass.getCid());
			ps.setString(2, newsClass.getCname());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//ɾ������Ա
	public boolean deleteAdmin(AdminInfo adminInfo){
		String sql="delete from admininfo where aid=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, adminInfo.getAid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//�޸Ĺ���Ա����
	public boolean updateAdminPwd(AdminInfo adminInfo){
		String sql="update admininfo set apwd =? where aid=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, adminInfo.getApwd());
			ps.setString(2, adminInfo.getAid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//�޸Ĺ���Ա��ʵ����
	public boolean updateAdminName(AdminInfo adminInfo){
		String sql="update admininfo set aname =?,apwd=? where aid=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, adminInfo.getAname());
			ps.setString(2, adminInfo.getApwd());
			ps.setString(3, adminInfo.getAid());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//ͬʱ�޸Ĺ���Ա��ʵ����������
	public boolean updateAdminNameAndPwd(AdminInfo adminInfo){
		String sql="update admininfo set aname =?,apwd=? where aid=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, adminInfo.getAname());
			ps.setString(2, adminInfo.getApwd());
			ps.setString(3, adminInfo.getAid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//��ѯ���й���Ա����ʵ������id
	public List<AdminInfo> queryAdminAll(){
		List <AdminInfo>list = new ArrayList();
		String sql="select aid,aname from admininfo";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				AdminInfo adminInfo=new AdminInfo();
				adminInfo.setAid(rs.getString("aid"));
				adminInfo.setAname(rs.getString("aname"));
				list.add(adminInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//��ȡ����
	public List<NewsClass> queryClassAll() {
		// TODO Auto-generated method stub
		List<NewsClass> list=new ArrayList();
		String sql="select cid,cname from newsclass";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				NewsClass newsClass=new NewsClass();
				newsClass.setCid(rs.getString("cid"));
				newsClass.setCname(rs.getString("cname"));
				list.add(newsClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public NewsClass queryClassById(String cid) {
		// TODO Auto-generated method stub
		String sql="select cid,cname from newsclass where cid=? limit 0,1";
		NewsClass newsClass=null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				newsClass=new NewsClass();
				newsClass.setCid(rs.getString("cid"));
				newsClass.setCname(rs.getString("cname"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newsClass;
	}
	//�޸�������
	public boolean updateClass(NewsClass newsClass) {
		// TODO Auto-generated method stub
		String sql="update newsclass set cname=? where cid=?";
		boolean b=false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newsClass.getCname());
			ps.setString(2, newsClass.getCid());
			ps.executeUpdate();
			b=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	//ɾ��������
	public void deleteClass(NewsClass newsClass) {
		
		String sql="delete from newsclass where cid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newsClass.getCid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�����������ѯ����
	public List<News> queryClassByCid(String cid) {
		String sql="select nid,ntitle,ndate,ncontent,cid from news where cid=?";
		List <News>list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, cid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				News news=new News();
				news.setNcontent(rs.getString("ncontent"));
				news.setNdate(rs.getString("ndate"));
				news.setNid(rs.getString("nid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setCid(rs.getString("cid"));
				list.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//�������
	public boolean insertNews(News news) {
		String sql="insert into news2(nid,ntitle,ndate,ncontent,cid,author,result,aid,teacher)value(?,?,?,?,?,?,'草稿',?,?)";
		//System.out.println(sql);
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, news.getNid());
			ps.setString(2, news.getNtitle());
			ps.setString(3, news.getNdate());
			ps.setString(4, news.getNcontent());
			ps.setString(5, news.getCid());
			ps.setString(6, news.getAuthor());
			ps.setString(7, news.getAid());
			ps.setString(8, news.getTeacher());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public boolean insertNews2(News news) {
		String sql="insert into news2(nid,ntitle,ndate,ncontent,cid,author,result,aid,teacher)value(?,?,?,?,?,?,'未审核',?,?)";
		//System.out.println(sql);
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, news.getNid());
			ps.setString(2, news.getNtitle());
			ps.setString(3, news.getNdate());
			ps.setString(4, news.getNcontent());
			ps.setString(5, news.getCid());
			ps.setString(6, news.getAuthor());
			ps.setString(7, news.getAid());
		    ps.setString(8, news.getTeacher());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//���¹���
	public List<Map> queryNewsMap() {
		String sql="select nid,ntitle,ndate,cname from news,newsclass where news.cid=newsclass.cid order by ndate desc";
		List<Map> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Map map=new HashMap<>();
				map.put("ndate", rs.getString("ndate"));
				map.put("ntitle", rs.getString("ntitle"));
				map.put("nid", rs.getString("nid"));			
				map.put("cname", rs.getString("cname"));			
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//��ҳ
	public List<Map> queryNewsMapByPage(int p) {
		int start = p*perPage;
		String sql="select nid,ntitle,ndate,cname from news,newsclass where news.cid=newsclass.cid order by ndate desc limit "+start+","+perPage;
		List<Map> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Map map=new HashMap<>();
				map.put("ndate", rs.getString("ndate"));
				map.put("ntitle", rs.getString("ntitle"));
				map.put("nid", rs.getString("nid"));			
				map.put("cname", rs.getString("cname"));			
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//��ҳ������
	public List<Map> queryNewsMapByPage3(int p,String cid,String ntitle,String aid) {
		int start = p*perPage;
		int no=start+1;
		String sql="select nid,ntitle,ndate,cname,news2.result "
				+"from news2,newsclass "
				+"where news2.cid=newsclass.cid and news2.aid=? and news2.result=?";
		if (cid!=null && !"".equals(cid)) {
			sql+=" and newsclass.cid=?";
		}
		if (ntitle!=null && !"".equals(ntitle)) {
			sql+=" and ntitle like ? ";
		}
				sql+=" order by ndate desc"+" limit "+start+","+perPage;
		List<Map> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			int num=3;
			ps.setString(1, aid);
			ps.setString(2, "已审核");
			if (cid!=null && !"".equals(cid)) {
				ps.setString(3, cid);
				num=4;
			}
			if (ntitle!=null && !"".equals(ntitle)) {
				ps.setString(num, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Map map=new HashMap<>();
				map.put("order_no", no++);
				map.put("ndate", rs.getString("ndate"));
				map.put("ntitle", rs.getString("ntitle"));
				map.put("nid", rs.getString("nid"));			
				map.put("cname", rs.getString("cname"));	
				map.put("result", rs.getString("result"));			
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Map> queryNewsMapByPage(int p,String cid,String ntitle,String aid) {
		int start = p*perPage;
		int no=start+1;
		String sql="select nid,ntitle,ndate,cname,news2.result "
				+"from news2,newsclass "
				+"where news2.cid=newsclass.cid and news2.aid=?and news2.result='未审核' ";
		if (cid!=null && !"".equals(cid)) {
			sql+=" and newsclass.cid=?";
		}
		if (ntitle!=null && !"".equals(ntitle)) {
			sql+=" and ntitle like ? ";
		}
				sql+=" order by ndate desc"+" limit "+start+","+perPage;
		List<Map> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			int num=2;
			ps.setString(1, aid);
			
			if (cid!=null && !"".equals(cid)) {
				ps.setString(2, cid);
				num=3;
			}
			if (ntitle!=null && !"".equals(ntitle)) {
				ps.setString(num, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Map map=new HashMap<>();
				map.put("order_no", no++);
				map.put("ndate", rs.getString("ndate"));
				map.put("ntitle", rs.getString("ntitle"));
				map.put("nid", rs.getString("nid"));			
				map.put("cname", rs.getString("cname"));	
				map.put("result", rs.getString("result"));			
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Map> queryNewsMapByPage5(int p,String cid,String ntitle,String aid) {
		int start = p*perPage;
		int no=start+1;
		String sql="select nid,ntitle,ndate,cname,news2.result "
				+"from news2,newsclass "
				+"where news2.cid=newsclass.cid and news2.aid=? and news2.result='草稿'";
		if (cid!=null && !"".equals(cid)) {
			sql+=" and newsclass.cid=?";
		}
		if (ntitle!=null && !"".equals(ntitle)) {
			sql+=" and ntitle like ? ";
		}
				sql+=" order by ndate desc"+" limit "+start+","+perPage;
		List<Map> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			int num=2;
			ps.setString(1, aid);
			
			if (cid!=null && !"".equals(cid)) {
				ps.setString(2, cid);
				num=3;
			}
			if (ntitle!=null && !"".equals(ntitle)) {
				ps.setString(num, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Map map=new HashMap<>();
				map.put("order_no", no++);
				map.put("ndate", rs.getString("ndate"));
				map.put("ntitle", rs.getString("ntitle"));
				map.put("nid", rs.getString("nid"));			
				map.put("cname", rs.getString("cname"));	
				map.put("result", rs.getString("result"));			
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Map> queryNewsMapByPage4(int p,String cid,String ntitle,String aid) {
		int start = p*perPage;
		int no=start+1;
		String sql="select nid,ntitle,ndate,cname,news2.result "
				+"from news2,newsclass "
				+"where news2.cid=newsclass.cid and news2.aid=? and news2.result=?";
		if (cid!=null && !"".equals(cid)) {
			sql+=" and newsclass.cid=?";
		}
		if (ntitle!=null && !"".equals(ntitle)) {
			sql+=" and ntitle like ? ";
		}
				sql+=" order by ndate desc"+" limit "+start+","+perPage;
		List<Map> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			int num=3;
			ps.setString(1, aid);
			ps.setString(2, "驳回");
			if (cid!=null && !"".equals(cid)) {
				ps.setString(3, cid);
				num=4;
			}
			if (ntitle!=null && !"".equals(ntitle)) {
				ps.setString(num, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Map map=new HashMap<>();
				map.put("order_no", no++);
				map.put("ndate", rs.getString("ndate"));
				map.put("ntitle", rs.getString("ntitle"));
				map.put("nid", rs.getString("nid"));			
				map.put("cname", rs.getString("cname"));	
				map.put("result", rs.getString("result"));			
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//��ѯ��������
	public int queryNewsCount() {
		String sql="select count(*) from news";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int queryNewsCount(String cid,String ntitle,String aid) {
		String sql="select count(*) from news2 where aid=? and result='未审核'";
		int flag=1;
		boolean f1=cid!=null && !"".equals(cid);
		if (f1) {
			sql="select count(*) from news2,newsclass "
					+"where news2.cid=newsclass.cid and news2.result='未审核'";
			sql+=" and newsclass.cid=? and aid=?";
			flag=2;
		}
		boolean f2=ntitle!=null && !"".equals(ntitle);
		if (f2) {
			sql+=(flag>0?" and ":" where")+" ntitle like ? ";
			flag+=1;
		}
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			if (f1) {
				ps.setString(1, cid);
				ps.setString(2, aid);
			}
			if (f2) {
				ps.setString(flag, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int queryNewsCount5(String cid,String ntitle,String aid) {
		String sql="select count(*) from news2 where aid=? and result='草稿'";
		int flag=1;
		boolean f1=cid!=null && !"".equals(cid);
		if (f1) {
			sql="select count(*) from news2,newsclass "
					+"where news2.cid=newsclass.cid and news2.result='草稿' ";
			sql+=" and newsclass.cid=? and aid=?";
			flag=2;
		}
		boolean f2=ntitle!=null && !"".equals(ntitle);
		if (f2) {
			sql+=(flag>0?" and ":" where")+" ntitle like ? ";
			flag+=1;
		}
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			if (f1) {
				ps.setString(1, cid);
				ps.setString(2, aid);
			}
			if (f2) {
				ps.setString(flag, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int queryNewsCount4(String cid,String ntitle,String aid) {
		String sql="select count(*) from news2 where aid=? and result='驳回'";
		int flag=1;
		boolean f1=cid!=null && !"".equals(cid);
		if (f1) {
			sql="select count(*) from news2,newsclass "
					+"where news2.cid=newsclass.cid  and news2.result='驳回'";
			sql+=" and newsclass.cid=? and aid=?";
			flag=2;
		}
		boolean f2=ntitle!=null && !"".equals(ntitle);
		if (f2) {
			sql+=(flag>0?" and ":" where")+" ntitle like ? ";
			flag+=1;
		}
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			if (f1) {
				ps.setString(1, cid);
				ps.setString(2, aid);
			}
			if (f2) {
				ps.setString(flag, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int queryNewsCount3(String cid,String ntitle,String aid) {
		String sql="select count(*) from news2 where aid=? and result='已审核'";
		int flag=1;
		boolean f1=cid!=null && !"".equals(cid);
		System.out.println(ntitle);
		if (f1) {
			sql="select count(*) from news2,newsclass "
					+"where news2.cid=newsclass.cid and news2.result='已审核' ";
			sql+=" and newsclass.cid=? and aid=?";
			flag=2;
		}
		boolean f2=ntitle!=null && !"".equals(ntitle);
		if (f2) {
			sql+=(flag>0?" and ":" where")+" ntitle like ? ";
			flag+=1;
		}
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			if (f1) {
				ps.setString(1, cid);
				ps.setString(2, aid);
			}
			if (f2) {
				ps.setString(flag, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int queryNewsCount2(String cid,String ntitle) {
		String sql="select count(*) from news";
		int flag=0;
		boolean f1=cid!=null && !"".equals(cid);
		if (f1) {
			sql="select count(*) from news,newsclass "
					+"where news.cid=newsclass.cid ";
			sql+=" and newsclass.cid=?";
			flag=1;
		}
		boolean f2=ntitle!=null && !"".equals(ntitle);
		if (f2) {
			sql+=(flag>0?" and ":" where")+" ntitle like ? ";
			flag+=1;
		}
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
		
			if (f1) {
				ps.setString(1, cid);
			}
			if (f2) {
				ps.setString(flag, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public News queryNewsById3(int id) {
		// TODO Auto-generated method stub
		String sql="select nid,ntitle,ndate,ncontent,cid,author,tex,count,teacher from news where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				News n= new News();
				n.setNcontent(rs.getString("ncontent"));
				n.setNdate(rs.getString("ndate"));
				n.setId(id);
				n.setNid(rs.getString("nid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setCid(rs.getString("cid"));
				n.setAuthor(rs.getString("author"));
				n.setTex(rs.getString("tex"));
				n.setCount(rs.getInt("count"));
				n.setTeacher(rs.getString("teacher"));
				return n;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public News queryNewsById2(String nid) {
		// TODO Auto-generated method stub
		String sql="select nid,ntitle,ndate,ncontent,cid,author,tex,count,teacher from news where nid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, nid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				News n= new News();
				n.setNcontent(rs.getString("ncontent"));
				n.setNdate(rs.getString("ndate"));
				n.setNid(nid);
				n.setNtitle(rs.getString("ntitle"));
				n.setCid(rs.getString("cid"));
				n.setAuthor(rs.getString("author"));
				n.setTex(rs.getString("tex"));
				n.setCount(rs.getInt("count"));
				n.setTeacher(rs.getString("teacher"));
				return n;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	//��������id������
	public News queryNewsById(String nid) {
		// TODO Auto-generated method stub
		String sql="select nid,ntitle,ndate,ncontent,cid,author,tex,teacher from news2 where nid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, nid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				News n= new News();
				n.setNcontent(rs.getString("ncontent"));
				n.setNdate(rs.getString("ndate"));
				n.setNid(nid);
				n.setNtitle(rs.getString("ntitle"));
				n.setCid(rs.getString("cid"));
				n.setAuthor(rs.getString("author"));
				n.setTex(rs.getString("tex"));
				n.setTeacher(rs.getString("teacher"));
				return n;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	//��������
	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		String sql="update news2 set ntitle=?,ndate=?,ncontent=?,cid=?,author=?,teacher=? where nid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, news.getNtitle());
			ps.setString(2, news.getNdate());
			ps.setString(3, news.getNcontent());
			ps.setString(4, news.getCid());
			ps.setString(5, news.getAuthor());
			ps.setString(6, news.getTeacher());
			ps.setString(7, news.getNid());

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateNews2(News news) {
		// TODO Auto-generated method stub
		String sql="update news2 set ntitle=?,ndate=?,ncontent=?,cid=?,author=? ,result='未审核',teacher=?where nid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, news.getNtitle());
			ps.setString(2, news.getNdate());
			ps.setString(3, news.getNcontent());
			ps.setString(4, news.getCid());
			ps.setString(5, news.getAuthor());
			ps.setString(6, news.getTeacher());
			ps.setString(7, news.getNid());
		
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateNewsById2(String nid,int count) {
		// TODO Auto-generated method stub
		String sql="update news set count=? where nid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,count);
			ps.setString(2, nid);
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	//ɾ������
	public boolean deleteNewsById2(String ntitle) {
		// TODO Auto-generated method stub
		String sql="delete from news2 where ntitle=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, ntitle);
			ps.executeUpdate();
			return  true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteNewsById(String nid) {
		// TODO Auto-generated method stub
		String sql="delete from news2 where nid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, nid);
			ps.executeUpdate();
			return  true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public List<News> queryNewsByCidIndex(String cid){
		String sql="select nid,ntitle,ndate,cid ,author,id from news where cid=? order by ndate desc limit 0,10";
		List <News>list = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, cid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				News news=new News();
				news.setId(rs.getInt("id"));
				news.setNdate(rs.getString("ndate"));
				news.setNid(rs.getString("nid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setCid(rs.getString("cid"));
				news.setAuthor(rs.getString("author"));
				list.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public List<News> queryNewsByCidIndex2(){
		String sql="select n.id, n.nid,n.ntitle,n.ndate,nc.cname,n.author,n.teacher from news n join newsclass nc  on n.cid=nc.cid where 1=1 order by n.count desc limit 0,50";
		List <News>list = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				News news=new News();
				news.setNdate(rs.getString("ndate"));
				news.setNid(rs.getString("nid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setCname(rs.getString("cname"));
				news.setAuthor(rs.getString("author"));
				news.setTeacher(rs.getString("teacher"));
				news.setId(rs.getInt("id"));
				list.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	//���·���
	public List<News> queryLastNewss() {
		// TODO Auto-generated method stub
		String sql="select id, nid ,ntitle from news order by  ndate desc limit 0,10";
		List list = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				News news=new News();
				news.setNid(rs.getString("nid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setId(rs.getInt("id"));
				list.add(news);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public List<Map> queryNewsMapByPage(String cid, String ntitle) {
		// TODO Auto-generated method stub
		String sql = "select nid,ntitle,ndate,cname from news,newsclass where news.cid=newsclass.cid ";
		List <Map>list = new ArrayList();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map map = new HashMap();
				map.put("ndate", 	rs.getString("ndate")	);
				map.put("ntitle",	rs.getString("ntitle")	);
				map.put("nid", 		rs.getString("nid")		);
				map.put("cname", 		rs.getString("cname")		);
				list.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<News> query(News n) {
		ArrayList<News> lists = new ArrayList<News>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = DbHelper.getConnection();
			String strSQL = "select * from news where 1=1";
			
			if (n.getNtitle() != null && !"".equals(n.getNtitle())) {
				strSQL = strSQL + " and ntitle like'%" + n.getNtitle() + "%'";
			}
			/*if (n.getUpwd() != null && !"".equals(n.getUpwd())) {
				strSQL = strSQL + " and upwd like'%" + n.getUpwd() + "%'";
			}*/
			if (n.getNdate() != null && !"".equals(n.getNdate())) {
				strSQL = strSQL + " and ndate like'%" + n.getNdate() + "%'";
			}
			// System.out.println(strSQL);
			pstm = conn.prepareStatement(strSQL);
			rs = pstm.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setNid(rs.getString("nid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNdate(rs.getString("ndate"));
				//news.setUemail(rs.getString("uemail"));
				lists.add(news);
			}
			return lists;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
					pstm = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	public int regUserInfoService(String aid, String aname, String apwd, String sex, int age, String birthday,String phone,String qq) {
		//创建sql语句
				String sql="insert into t_user(aid,aname,apwd,sex,age,birthday,phone,qq) value(?,?,?,?,?,?,?,?)";
				//工具类封装了增删改数据的方法
				return DBUtil.executeDML(sql, aid,aname,apwd,sex,age,birthday,phone,qq);
		
	}
	public List<Url> getUserUrlInfoService(String aid) {
		//声明jdbc变量
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
		           //声明变量
				List<Url> lu=null;
				try {
					//创建连接
					conn=DBUtil.getConnection();
					//创建SQL命令
					String sql="select * from t_url where urlid in(select urlid from t_user_url where aid=?) ";
					//创建SQL命令对象
					ps=conn.prepareStatement(sql);
					//给占位符赋值
					ps.setString(1, aid);
					
					//执行SQL命令
					rs=ps.executeQuery();
					//给list集合赋值
					lu=new ArrayList<>();
					//遍历
				    while(rs.next()){
				    	//给变量赋值
				       Url u=new Url();
				    	u.setUrlid(rs.getInt("urlid"));
				    	u.setLocation(rs.getString("location"));
				    	u.setRemark(rs.getString("remark"));
				    	lu.add(u);
				    }
				   
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					//关闭资源
				    DBUtil.closeAll(rs, ps, conn);
				}
				
				//返回结果
				return lu;
	}
	//管理员写入权限
	public void InsertUrl(String aid) {
		String sql="insert into t_user_url  values(?, 1),(?,2),(?,3),(?,4),(?,5),(?,6),(?,7),(?,8),(?,9),(?,10),(?,11),(?,12),(?,13),(?,14),(?,15),(?,16),(?,17),(?,18);";
		System.out.println(sql);
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, aid);
			ps.setString(2, aid);
			ps.setString(3, aid);
			ps.setString(4, aid);
			ps.setString(5, aid);
			ps.setString(6, aid);
			ps.setString(7, aid);
			ps.setString(8, aid);
			ps.setString(9, aid);
			ps.setString(10, aid);
			ps.setString(11, aid);
			ps.setString(12, aid);
			ps.setString(13, aid);
			ps.setString(14, aid);
			ps.setString(15, aid);
			ps.setString(16, aid);
			ps.setString(17, aid);
			ps.setString(18, aid);
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public void deleteur(String aid) {
		String sql="delete from t_user_url where aid=?";
		//工具类封装了增删改数据的方法
		DBUtil.executeDML(sql, aid);
		
	}
	public List<User> queryuserAll() {
		List <User>ld = new ArrayList();
		String sql="select aid,aname from t_user";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setAid(rs.getString("aid"));
				user.setAname(rs.getString("aname"));
				ld.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
		
	}
	public User checkUserInfo(String aid, String apwd) {
		//声明jdbc变量
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
		           //声明变量
				User u=null;
				try {
					//创建连接
					conn=DBUtil.getConnection();
					//创建SQL命令
					String sql="select * from t_user where aid=? and apwd=?";
					//创建SQL命令对象
					ps=conn.prepareStatement(sql);
					//给占位符赋值
					ps.setString(1, aid);
					ps.setString(2, apwd);
					//执行SQL命令
					rs=ps.executeQuery();
					//遍历
				    while(rs.next()){
				    	//给变量赋值
				    	u=new User();
				    	u.setAid(rs.getString("aid"));
				    	u.setAname(rs.getString("aname"));
				    	
				    }
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					//关闭资源
				    DBUtil.closeAll(rs, ps, conn);
				}
				
				//返回结果
				return u;
	}
	public User selUser(String aid) {
		//声明jdbc变量
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
		           //声明变量
				User u=null;
				try {
					//创建连接
					conn=DBUtil.getConnection();
					//创建SQL命令
					String sql="select * from t_user where aid=? ";
					//创建SQL命令对象
					ps=conn.prepareStatement(sql);
					//给占位符赋值
					ps.setString(1, aid);
				
					//执行SQL命令
					rs=ps.executeQuery();
					//遍历
				    while(rs.next()){
				    	//给变量赋值
				    	u=new User();
				    	u.setAid(rs.getString("aid"));
				    	u.setAname(rs.getString("aname"));
				    	u.setAge(rs.getInt("age"));
				    	u.setBirthday(rs.getString("birthday"));
				    	u.setSex(rs.getString("sex"));
				    	u.setPhone(rs.getString("phone"));
				    	u.setQq(rs.getString("qq"));
				    	u.setPhotoName(rs.getString("photoname"));
				        u.setPhototype(rs.getString("phototype"));
				        u.setRealname(rs.getString("realname"));
				        u.setCity(rs.getString("city"));
				        u.setSchool(rs.getString("school"));
				        u.setGrade(rs.getString("grade"));
				    }
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					//关闭资源
				    DBUtil.closeAll(rs, ps, conn);
				}
				
				//返回结果
				return u;
	}
	public List<Url> getUserUrlInfo(String aid) {
		//声明jdbc变量
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
           //声明变量
		List<Url> ls=null;
		try {
			//创建连接
			conn=DBUtil.getConnection();
			//创建SQL命令
			String sql="select * from t_url where urlid in(select urlid from t_user_url where aid=?) ";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, aid);
			
			//执行SQL命令
			rs=ps.executeQuery();
			//给list集合赋值
			ls=new ArrayList<>();
			//遍历
		    while(rs.next()){
		    	//给变量赋值
		       Url u=new Url();
		    	u.setUrlid(rs.getInt("urlid"));
		    	u.setLocation(rs.getString("location"));
		    	u.setRemark(rs.getString("remark"));
		    	ls.add(u);
		    }
		   
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
		    DBUtil.closeAll(rs, ps, conn);
		}
		
		//返回结果
		return ls;
	}
	public boolean updateUserName(User user) {
		String sql="update t_user set apwd=? where aid=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, user.getApwd());
			ps.setString(2, user.getAid());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public User queryUserInfoById(String aid) {
		String sql="select aid,aname,apwd from t_user where aid=?";
		User user=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,aid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				 user=new User();
				user.setAid(rs.getString("aid"));
				user.setAname(rs.getString("aname"));
				user.setApwd(rs.getString("apwd"));
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public void deleteUser(User user) {
		String sql="delete from t_user where aid=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getAid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public User selUser(User user) {
		Connection conn=null;
    	PreparedStatement   pstm=null;
    	ResultSet rs=null;
    	try {
			conn=DbHelper.getConnection();
			String strSQL="select * from t_user where aid=? and apwd=?";
			pstm=conn.prepareStatement(strSQL);
			pstm.setString(1,user.getAid() );
			pstm.setString(2, user.getApwd());
			rs=pstm.executeQuery();
			if(rs.next()){
			  String aid=rs.getString("aid");
			  String apwd=rs.getString("apwd");
			  String aname=	rs.getString("aname");
			  User  u=new User(aid,apwd,aname);
			  System.out.println(aid+""+apwd+""+aname);
			  return u;
			}else{
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
					rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			if(pstm!=null){
				try {
					pstm.close();
					pstm=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
    	
    	return null;
	}
	public List<Map> queryNewsMapByPage2(int p,String cid,String ntitle) {
		int start = p*perPage;
		int no=start+1;
		String sql="select id,nid,ntitle,ndate,cname "
				+"from news,newsclass "
				+"where news.cid=newsclass.cid ";
		if (cid!=null && !"".equals(cid)) {
			sql+=" and newsclass.cid=?";
		}
		if (ntitle!=null && !"".equals(ntitle)) {
			sql+=" and ntitle like ? ";
		}
				sql+=" order by ndate desc"+" limit "+start+","+perPage;
		List<Map> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			int num=1;
			if (cid!=null && !"".equals(cid)) {
				ps.setString(1, cid);
				num=2;
			}
			if (ntitle!=null && !"".equals(ntitle)) {
				ps.setString(num, "%"+ntitle+"%");
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Map<Object, Object> map=new HashMap<>();
				map.put("order_no", no++);
				map.put("ndate", rs.getString("ndate"));
				map.put("ntitle", rs.getString("ntitle"));
				map.put("nid", rs.getString("nid"));			
				map.put("cname", rs.getString("cname"));	
				map.put("id", rs.getString("id"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static int save(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n=0;
		try{
		//��ȡ����
		conn = DBUtil.getConnection();
		//����������ȡ���
		pstmt = conn.prepareStatement("update  t_user set phone=?,qq=?,realname=?,phototype=?,photoname=? where aid=?");
		
		pstmt.setString(1, user.getPhone());
		pstmt.setString(2, user.getQq());
		pstmt.setString(3, user.getRealName());
        pstmt.setString(4, user.getPhotoType());
		pstmt.setString(5, user.getPhotoName());
		pstmt.setString(6, user.getAid());
		n = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		//�ر���Դ
		DBUtil.closeAll(null, pstmt, conn);
	}		
		return n;
	}
	public int upsetUser(User user) {
		String sql="update  t_user set phone=?,qq=?,city=?,school=?,grade=? where aid=?";
		Object[] par= {user.getPhone(),user.getQq(),user.getCity(),user.getSchool(),user.getGrade(),user.getAid()};
		int n=DBUtil.executeDML(sql, par);
		return n;
	}
	
	}