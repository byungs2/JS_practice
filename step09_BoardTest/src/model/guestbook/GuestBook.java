package model.guestbook;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity 
@NamedQuery(query="select g from GuestBook g order by g.num", name="GuestBook.allList")
public class GuestBook implements Serializable{
	
	@Id
	@GeneratedValue(generator="GBook_id_gen")
	@SequenceGenerator(name="GBook_id_gen", sequenceName="GBook_id_seq", allocationSize=1)
	private int num;					// 글 번호
	@Column(length=50, nullable = false)
	private String title;					// 글 제목
	@Column(length=50, nullable = false)
	private String author;				// 글 작성자
	@Column(length=50, nullable = false)
	private String email;	// 글 작성자 전자메일
	
	// Large Object binary   
	@Lob
	private String content;				// 글 내용
	
	@Column(length=20, nullable = false)
	private String password;			// 글 비밀번호
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date writeday;			// 글 작성일
	
	private int readnum;				// 글 조회수
	
	@Builder
	public GuestBook(String title, String author, String email, String content, String password, Date writeday,
			int readnum) {
		this.title = title;
		this.author = author;
		this.email = email;
		this.content = content;
		this.password = password;
		this.writeday = writeday;
		this.readnum = readnum;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setWriteday(Date writeday) {
		this.writeday = writeday;
	}
	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}
	
	
}