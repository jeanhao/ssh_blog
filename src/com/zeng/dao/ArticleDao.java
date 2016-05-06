package com.zeng.dao;

import java.util.List;

import com.zeng.entity.Article;
import com.zeng.entity.Critique;

public interface ArticleDao {
	public void addArticle(Article article);

	public List<Article> listByPage(int pageNow, int pageSize);

	public int getAllcount(String type);

	public Article getArticleById(Integer id);

	public void addCritique(Critique critique);

	public List<Critique> listCritiqueByPage(int pageNow, int pageSize);
}
