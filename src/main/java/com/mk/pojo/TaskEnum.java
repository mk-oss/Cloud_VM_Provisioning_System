/**
 * 
 */
package com.mk.pojo;

/**
 * @author MaruthaMuthu
 *
 */
public enum TaskEnum {
	TASK01("auto_order_collection_started","order_collection_sub_flow","auto"),
	TASK02("auto_order_screening","order_collection_sub_flow","auto"),
	TASK03("auto_order_type_classification","order_collection_sub_flow","auto"),
	TASK04("auto_post_order_staging","order_collection_sub_flow","auto"),
	
	TASK05("auto_validate_customer_entity","order_validation_sub_flow","auto"),
	TASK06("auto_validate_billing_address","order_validation_sub_flow","auto"),
	TASK07("auto_validate_order_entities","order_validation_sub_flow","auto"),
	TASK08("auto_validate_auth_entities","order_validation_sub_flow","auto"),
	TASK09("auto_send_notification","order_validation_sub_flow","auto");
	 
	private String taskName;
	private String subFlow;
	private String type;
	private TaskEnum(String taskName, String subFlow, String type) {
		this.taskName = taskName;
		this.subFlow = subFlow;
		this.type = type;
	}
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the subFlow
	 */
	public String getSubFlow() {
		return subFlow;
	}
	/**
	 * @param subFlow the subFlow to set
	 */
	public void setSubFlow(String subFlow) {
		this.subFlow = subFlow;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
 
}
