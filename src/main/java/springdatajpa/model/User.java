package springdatajpa.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "USER")
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	@Column(name = "SALARY", nullable = false)
	private Integer salary;

	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(name = "LAST_MODIFIED_AT", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModifiedAt;

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

}
