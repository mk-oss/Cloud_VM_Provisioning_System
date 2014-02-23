/**
 * 
 */
package com.mk.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author MaruthaMuthu
 *
 */
@XmlRootElement(name = "order_approval_sub_flow")
public class OrderApprovalSubFlow {

	private String status;

	private List<Task> taskList = new ArrayList<Task>();

	/**
	 * @return the taskList
	 */
	@XmlElement(name="task")
	public List<Task> getTaskList() {
		return taskList;
	}

	/**
	 * @param taskList the taskList to set
	 */
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	/**
	 * @return the status
	 */
	@XmlAttribute
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
