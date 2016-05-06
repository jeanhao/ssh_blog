package com.zeng.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeng.dao.ArticleDao;
import com.zeng.entity.Article;
import com.zeng.entity.Critique;
@Service
public class ArticleManagerImpl implements ArticleDao, ArticleManager {

	@Autowired
	private ArticleDao articleDao;
	
	//Ìí¼Ó²©ÎÄ
	@Override
	public void addArticle(Article article) {
		articleDao.addArticle(article);
	}
	@Override
	public List<Article> listByPage(int pageNow, int pageSize) {
		return articleDao.listByPage(pageNow,pageSize);
	}
	@Override
	public int getAllcount(String type) {
		return articleDao.getAllcount(type);
	}
	@Override
	public Article getArticleById(Integer id) {
		return articleDao.getArticleById(id);
	}
	@Override
	public void addCritique(Critique critique) {
		articleDao.addCritique(critique);
	}
	@Override
	public List<Critique> listCritiqueByPage(int pageNow, int pageSize){
		return articleDao.listCritiqueByPage(pageNow, pageSize);
	}

}
