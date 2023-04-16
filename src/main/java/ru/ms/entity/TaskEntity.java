package ru.ms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String header;
    private String description;
    private Boolean status;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TaskEntity [id=" + id + ", header=" + header + ", description=" + description + ", status=" + status
				+ "]";
	}

    

    

    
    


}
