/**
 * 
 */
package com.mk.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author MaruthaMuthu
 * 
 */

@Entity
@Table(name = "tbl_task_status")
@XmlRootElement(name = "task")
public class Task implements Comparable<Task>{

	public Task() {
	}

	public Task(String id, String orderid, String taskid,String status,
			Date started, Date ended) {
		super();
		this.id = id;
		this.setOrderid(orderid);
		this.taskid = taskid;
		this.status = status;
		this.started = started;
		this.ended = ended;
	}

	private String id;
	private String orderid;
	private String taskid;
	private String name;
	private String type;
	private String status;
	private Date started;
	private Date ended;

	/**
	 * @return the id
	 */
	@XmlAttribute
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the orderid
	 */
	@Column(name = "orderid", nullable = false)
	public String getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	/**
	 * @return the taskid
	 */
	@Column(name = "taskid", nullable = false)
	public String getTaskid() {
		return taskid;
	}

	/**
	 * @param taskid the taskid to set
	 */
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	/**
	 * @return the name
	 */
	@XmlAttribute
	@Transient 
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
	 * @return the type
	 */
	@XmlAttribute
	@Transient 
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
	 * @return the status
	 */
	@Column(name = "status", nullable = false)
	@XmlAttribute
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the started
	 */
	@XmlAttribute
	@Column(name = "started", nullable = false)
	public Date getStarted() {
		return started;
	}

	/**
	 * @param started
	 *            the started to set
	 */
	public void setStarted(Date started) {
		this.started = started;
	}

	/**
	 * @return the ended
	 */
	@XmlAttribute
	@Column(name = "ended", nullable = true)
	public Date getEnded() {
		return ended;
	}

	/**
	 * @param ended
	 *            the ended to set
	 */
	public void setEnded(Date ended) {
		this.ended = ended;
	}

	@Override
	public int compareTo(Task arg) {
	      return (this.id).compareTo(arg.id);
	}

}
