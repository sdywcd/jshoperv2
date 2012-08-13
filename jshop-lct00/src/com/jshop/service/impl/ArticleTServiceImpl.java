package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ArticleTDao;
import com.jshop.dao.impl.ArticleTDaoImpl;
import com.jshop.entity.ArticleT;
import com.jshop.service.ArticleTService;
@Service("articleTService")
@Scope("prototype")
public class ArticleTServiceImpl implements ArticleTService {
	@Resource(name="articleTDao")
	private ArticleTDao articleTDao;

	
	public ArticleTDao getArticleTDao() {
		return articleTDao;
	}

	public void setArticleTDao(ArticleTDao articleTDao) {
		this.articleTDao = articleTDao;
	}

	public void addArticleT(ArticleT at) {
		this.getArticleTDao().addArticleT(at);
	}

	public int countfindAllArticle(String creatorid) {
		return this.getArticleTDao().countfindAllArticle(creatorid);
	}

	public List<ArticleT> findAllArticleT(int currentPage, int lineSize, String creatorid) {
		return this.getArticleTDao().findAllArticleT(currentPage, lineSize, creatorid);
	}

	public ArticleT findArticleByarticleid(String articleid) {
		return this.getArticleTDao().findArticleByarticleid(articleid);
	}

	public int updateArticleT(ArticleT at) {
		return this.getArticleTDao().updateArticleT(at);
	}

	public int updateHtmlPath(String articleid, String htmlPath) {
		return this.getArticleTDao().updateHtmlPath(articleid, htmlPath);
	}

	public List<ArticleT> findAllArticleBycreatorid(String creatorid) {
		return this.getArticleTDao().findAllArticleBycreatorid(creatorid);
	}

	public List<ArticleT> findAllArticleT(String status) {
		return this.getArticleTDao().findAllArticleT(status);
	}

	public List<ArticleT> sortAllArticleT(int currentPage, int lineSize, String creatorid, String queryString) {

		return this.getArticleTDao().sortAllArticleT(currentPage, lineSize, creatorid, queryString);
	}

	public int delArticleT(String[] list) {
		return this.getArticleTDao().delArticleT(list);
	}

	public int updateArticlepositionByarticleCategoryTid(String articleCategoryTid, String position) {
		return this.getArticleTDao().updateArticlepositionByarticleCategoryTid(articleCategoryTid, position);
	}

	@Override
	public int updateHtmlPath(String articleid, String htmlPath,
			Date updatetime) {
		return this.getArticleTDao().updateHtmlPath(articleid, htmlPath, updatetime);
	}
	
	
}
