package model.entity;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.PublicCommon;
public class DictionaryDAO {
	public static boolean insert(Dictionary dic) {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		tx.begin();
		
		try {
			if (em.find(Dictionary.class, dic.getKor()) != null) {
				return result;
			}
			em.persist(dic);
			tx.commit();
			result = true;
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return result;
	}
	
	public static boolean update(Dictionary dic) {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		tx.begin();
		try {
			Dictionary d = em.find(Dictionary.class, dic.getKor());
			System.out.println(d);
			d.setEn(dic.getEn());
			System.out.println(d);
			tx.commit();
			result = true;
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return result;
	}
	
	public static boolean delete(Dictionary dic) {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		tx.begin();
		
		try {
			Dictionary d = em.find(Dictionary.class, dic.getKor());
			if (d == null) {
				return result;
			}
			em.remove(d);
			tx.commit();
			result = true;
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return result;
	}
	
	public static Dictionary getEntity(String kor) {
		EntityManager em = PublicCommon.getManager();
		Dictionary dic = null;
		
		try {
			dic = em.find(Dictionary.class, kor);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return dic;
	}
	
	public static ArrayList<Dictionary> getList() {
		EntityManager em = PublicCommon.getManager();
		ArrayList<Dictionary> list = null;
		
		try {
			list = (ArrayList<Dictionary>) em.createNamedQuery("Dictionary.findList").getResultList();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return list;
	}
	
	public static ArrayList<Dictionary> getLikeList(String word) {
		EntityManager em = PublicCommon.getManager();
		ArrayList<Dictionary> list = null;
		
		try {
			list = (ArrayList<Dictionary>) em.createNamedQuery("Dictionary.findByLike").setParameter("word","%"+word.toLowerCase()+"%").getResultList();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return list;
	}
	
}