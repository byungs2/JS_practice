package model.guestbook;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.PublicCommon;

public class GuestBookDAO {
	public static boolean writeContent(GuestBook vo) throws SQLException{
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			em.persist(vo);
			tx.commit();
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();		
			return false;
		} finally {
			em.close();
		}
		
		return true;
	}
	
	public static GuestBook getContent(int num, boolean flag) throws SQLException{				
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		GuestBook gBook = null;
		tx.begin();
		
		try {
			//DB로 부터 검색해서 영속성 컨텍스트에 저장
			gBook = em.find(GuestBook.class, num);
			
			//영속성 컨텍스트의 데이터값 수정 - update 
			if(flag){
				gBook.setReadnum(gBook.getReadnum()+1);
			}
			
			tx.commit();
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return gBook;
	}
	
	public  static boolean deleteContent(int num, String password) throws SQLException{
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		tx.begin();
		
		try {
			GuestBook gBook = em.find(GuestBook.class, num);
			if (gBook.getPassword().equals(password)) {
				em.remove(gBook);
				result = true;
			}
			tx.commit();
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}		
		return result;
	}
	
	public  static boolean updateContent(GuestBook vo) throws SQLException{
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			//? 검색
			GuestBook gBook = em.find(GuestBook.class, vo.getNum());
			
			// update ? 혹여 객체 자체를 복제할 수는 없나?
			gBook.setTitle(vo.getTitle());
			gBook.setAuthor(vo.getAuthor());
			gBook.setEmail(vo.getEmail());
			gBook.setPassword(vo.getPassword());
			gBook.setContent(vo.getContent());
			gBook.setWriteday(vo.getWriteday());
			gBook.setReadnum(vo.getReadnum());
			
			tx.commit();
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();		
			return false;
		} finally {
			em.close();
		}
		
		return true;
	}
	
	public static ArrayList<GuestBook> getAllContents() throws SQLException{
		EntityManager em = PublicCommon.getManager();
		//ArrayList<GuestBookBean> list = null;
		
		try {
			return (ArrayList<GuestBook>)em.createNamedQuery("GuestBook.allList").getResultList();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return null;
	}
	
	public static GuestBook getContent(int num) throws SQLException{
		EntityManager em = PublicCommon.getManager();
		GuestBook gBook = null;
		
		try {
			gBook = em.find(GuestBook.class, num);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();	
			throw e;
		} finally {
			em.close();
		}
		
		return gBook;
	}
}
