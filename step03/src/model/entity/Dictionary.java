package model.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity 
@NamedQuery(query="select d from Dictionary d order by d.kor", name="Dictionary.findList")
@NamedQuery(query="select d from Dictionary d where d.kor like :word or d.en like :word order by d.kor", name="Dictionary.findByLike")
public class Dictionary {
	@Id
	private String kor;	
	private String en;
}