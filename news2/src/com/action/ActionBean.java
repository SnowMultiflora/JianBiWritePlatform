package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.SqlHelper;
import com.pojo.AdminInfo;
import com.pojo.News;
import com.pojo.NewsClass;
import com.pojo.NewsPojo;

public class ActionBean {
	public String queryAdminAll(){
		SqlHelper sqlHelper = new SqlHelper();
		List <AdminInfo>list=sqlHelper.queryAdminAll();
		String tableHTML="";
		int i=1;
		for(AdminInfo adminInfo:list){
			tableHTML+="<tr><td><input type=\"radio\" name=\"rad\" autocomplete=\"off\" value=\""+adminInfo.getAid()+"\"/></td><td class=\"text-center\">"+(i++)+"</td><td class=\"text-center\">"+adminInfo.getAid()+"</td><td class=\"text-center\">"+adminInfo.getAname()+"</td></tr>";
		}
		sqlHelper.destroy();
		return tableHTML;
	}
	public AdminInfo queryAdminById(String aid){
		SqlHelper sqlHelper = new SqlHelper();
		AdminInfo adminInfo=sqlHelper.queryAdminInfoById(aid);
		sqlHelper.destroy();
		return adminInfo;
	}
	//��������������
	public String queryClassAll(){
		SqlHelper sqlHelper = new SqlHelper();
		List <NewsClass>list=sqlHelper.queryClassAll();
		String tableHTML="";
		int i=1;
		for(NewsClass newsClass:list){
			tableHTML+="<tr><td><input type=\"radio\" name=\"rad\" autocomplete=\"off\" value=\""+newsClass.getCid()+"\"/></td><td class=\"text-center\">"+(i++)+"</td><td class=\"text-center\">"+newsClass.getCname()+"</td></tr>";
		}
		sqlHelper.destroy();
		return tableHTML;
	}
	public List<NewsClass>queryClassList(){
		SqlHelper sqlHelper = new SqlHelper();
		List <NewsClass>list=sqlHelper.queryClassAll();
		sqlHelper.destroy();
		return list;
	}
	public NewsClass queryClassById(String cid){
		SqlHelper sqlHelper=new SqlHelper();
		NewsClass newsClass=sqlHelper.queryClassById(cid);
		sqlHelper.destroy();
		return newsClass;
	}

	//���¹���
	public List<Map> queryNewsMap(){
		SqlHelper sqlHelper = new SqlHelper();
		List list=sqlHelper.queryNewsMap();
		sqlHelper.destroy();
		return list;
	}
	//��ҳ
	public List<Map> queryNewsMapByPage(int p){
		SqlHelper sqlHelper = new SqlHelper();
		List list=sqlHelper.queryNewsMapByPage(p);
		//int rows=sqlHelper.queryNewsCount();
		sqlHelper.destroy();
		return list;
	}
	//��ҳ����������
	public Map queryNewsByPage(int p){
		Map map=new HashMap<>();
		SqlHelper sqlHelper = new SqlHelper();
		
		map.put("list", sqlHelper.queryNewsMapByPage(p));
		map.put("rows", sqlHelper.queryNewsCount());
		map.put("classlist", sqlHelper.queryClassAll());
		sqlHelper.destroy();
		return map;
	}
	
	public Map queryNewsByPage(int p,String cid,String ntitle,String aid){
		Map map=new HashMap<>();
		SqlHelper sqlHelper = new SqlHelper();
		
		map.put("list", sqlHelper.queryNewsMapByPage(p,cid,ntitle,aid));
		map.put("rows", sqlHelper.queryNewsCount(cid,ntitle,aid));
		map.put("classlist", sqlHelper.queryClassAll());
		sqlHelper.destroy();
		return map;
	}
	public Map queryNewsByPage5(int p,String cid,String ntitle,String aid){
		Map map=new HashMap<>();
		SqlHelper sqlHelper = new SqlHelper();
		
		map.put("list", sqlHelper.queryNewsMapByPage5(p,cid,ntitle,aid));
		map.put("rows", sqlHelper.queryNewsCount5(cid,ntitle,aid));
		map.put("classlist", sqlHelper.queryClassAll());
		sqlHelper.destroy();
		return map;
	}
	public Map queryNewsByPage4(int p,String cid,String ntitle,String aid){
		Map map=new HashMap<>();
		SqlHelper sqlHelper = new SqlHelper();
		
		map.put("list", sqlHelper.queryNewsMapByPage4(p,cid,ntitle,aid));
		map.put("rows", sqlHelper.queryNewsCount4(cid,ntitle,aid));
		map.put("classlist", sqlHelper.queryClassAll());
		sqlHelper.destroy();
		return map;
	}
	public Map queryNewsByPage3(int p,String cid,String ntitle,String aid){
		Map map=new HashMap<>();
		SqlHelper sqlHelper = new SqlHelper();
		
		map.put("list", sqlHelper.queryNewsMapByPage3(p,cid,ntitle,aid));
		map.put("rows", sqlHelper.queryNewsCount3(cid,ntitle,aid));
		map.put("classlist", sqlHelper.queryClassAll());
		sqlHelper.destroy();
		return map;
	}
	public Map queryNewsMapForUpdate(String nid){
		Map map=new HashMap();
		SqlHelper sqlHelper = new SqlHelper();
		map.put("newsClassList", sqlHelper.queryClassAll());
		map.put("news", sqlHelper.queryNewsById(nid));
		sqlHelper.destroy();
		return map;
	}
}
