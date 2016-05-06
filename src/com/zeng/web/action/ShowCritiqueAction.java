package com.zeng.web.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.utils.Page;
import com.zeng.entity.Critique;
import com.zeng.manager.ArticleManager;

@SuppressWarnings("serial")
public class ShowCritiqueAction extends ActionSupport{
	
	@Autowired
	private ArticleManager articleManager;
	private String json;
	private final int pageSize = 5;
	private int pageNow = 1; // 初始化为1,默认从第一页开始显示
	private Page page;
	//展示评论
		public String showCritique() throws Exception{
			 List<Critique>  critiques = articleManager.listCritiqueByPage(pageNow, this.pageSize);
			page = new Page(pageNow, this.pageSize,articleManager.getAllcount("critique"));
			if (page.getPageNow() > page.getTotalPage()) {
				page.setPageNow(page.getTotalPage());
			}
			if(critiques.size()>0||critiques!=null){
				JSONArray jsonArray =new JSONArray();
				for(int i=0;i<critiques.size();i++){
				JSONObject jo=new JSONObject();
				jo.put("critic_date",critiques.get(i).getCritic_date());
				jo.put("criticInfo", critiques.get(i).getCriticInfo());
				jsonArray.add(jo);
				}
				json = jsonArray.toString();
			}
			return "showCritique";
		}

		public void setPageNow(int pageNow) {
			this.pageNow = pageNow;
		}

		public Page getPage() {
			return page;
		}

		public void setPage(Page page) {
			this.page = page;
		}

		public int getPageNow() {
			return pageNow;
		}

		public String getJson() {
			return json;
		}

		public void setJson(String json) {
			this.json = json;
		}
}
