package com.zeng.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zeng.entity.Article;
import com.zeng.entity.Critique;
@Repository
public class ArticleDaoImpl implements ArticleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addArticle(Article article) {
		sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public List<Article> listByPage(int pageNow, int pageSize) {
		String hql = "from Article order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setFirstResult((pageNow - 1) * pageSize).setMaxResults(pageSize);
		return query.list();
	}
	
	@Override
	public List<Critique> listCritiqueByPage(int pageNow, int pageSize) {
		String hql = "from Critique order by critic_date desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setFirstResult((pageNow - 1) * pageSize).setMaxResults(pageSize);
		return query.list();
	}
	public static void main(){
		System.out.println("hehe");
		System.out.println("hehe");
	}
	//获取数据数量
	@Override
	public int getAllcount(String type) {
		String hql ="";
		if(type.equals("article")){
			hql = "select count(*) from Article";
		}else{
			hql = "select count(*) from Critique";
		}
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if(count>0){
			return count.intValue();
		}else{
			return 0;
		}
	}

	@Override
	public Article getArticleById(Integer id) {
		String hql = "from Article a where a.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setInteger(0, id);
		Article article = (Article) query.uniqueResult();
		return article;
	}

	@Override
	public void addCritique(Critique critique) {
		sessionFactory.getCurrentSession().save(critique);
	}
}
