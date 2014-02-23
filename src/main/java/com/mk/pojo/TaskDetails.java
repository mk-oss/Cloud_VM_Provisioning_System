/**
 * 
 */
package com.mk.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author MaruthaMuthu
 * 
 */

@Entity
@Table(name = "tbl_task_details")
@XmlRootElement(name = "Tasks")
public class TaskDetails {
	private String taskid;
	private String name;
	private String subflow;
	private String type;
	private String description;
	private String dept;

	public TaskDetails() {
		super();
	}

	/**
	 * @return the taskid
	 */
	@XmlAttribute
	@Id
	@Column(name = "taskid", unique = true, nullable = false)
	public String getTaskid() {
		return taskid;
	}

	/**
	 * @param taskid
	 *            the taskid to set
	 */
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	/**
	 * @return the name
	 */
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subflow
	 */
	@Column(name = "subflow", nullable = false)
	public String getSubflow() {
		return subflow;
	}

	/**
	 * @param subflow
	 *            the subflow to set
	 */
	public void setSubflow(String subflow) {
		this.subflow = subflow;
	}

	/**
	 * @return the type
	 */
	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the description
	 */
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dept
	 */
	@Column(name = "dept", nullable = false)
	public String getDept() {
		return dept;
	}

	/**
	 * @param dept
	 *            the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

}
