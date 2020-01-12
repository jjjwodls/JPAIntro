package com.example.demo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Data;


//lombok library create getter,setter,toString
//AuditEntityListener는 Spring data jpa에서 구현한 EntityListener이다.
//@PrePersist, @PreUpdate 설정을 통해 엔티티가 영속화 되기이전에 AuditingHandler를 통해 생성일, 생성자, 수정일, 수정자를 자동으로 찾아 설정한다.


@Data 
@EntityListeners(AuditingEntityListener.class)
@Entity 
public class JPAUser {
	
	
	/*
	 * use Sequence 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	 * @SequenceGenerator(sequenceName = "db_seq_name",allocationSize = 1,name =
	 * "user_seq")
	 */
	@Id // this column is Primary Key
	@Column(name = "USERID")
	private Long userId;
	
	@Column(name="USERNAME",length = 20,nullable = false)
	private String userName;
	
	@Column(name="USERAGE",length = 5,nullable = false)
	private Long userAge;
	
	@Column(name="CREATETIME",nullable = false,updatable = false)
	@CreatedDate
	private Timestamp createTime;
	
	@Column(name="UPDATETIME",nullable = false,updatable = true)
	@LastModifiedDate
	private Timestamp updateTime;
	

	public JPAUser() {
	}

	@Builder
	public JPAUser(Long userId, String userName, Long userAge, String createTime, String updateTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
	}
	
	
}



