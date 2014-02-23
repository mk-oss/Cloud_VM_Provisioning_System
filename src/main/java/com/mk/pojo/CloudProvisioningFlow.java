/**
 * 
 */
package com.mk.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author MaruthaMuthu
 * 
 */
@XmlRootElement(name = "cloud_vm_provisioning_flow")
@XmlType(propOrder={"orderCollectionSubFlow", "orderValidatationSubFlow", "orderApprovalSubFlow", "orderProvisioningSubFlow", "orderCompletionSubFlow"})
public class CloudProvisioningFlow {
	
	private OrderCollectionSubFlow orderCollectionSubFlow;
	private OrderValidationSubFlow orderValidatationSubFlow;
	private OrderApprovalSubFlow orderApprovalSubFlow;
	private OrderProvisioningSubFlow orderProvisioningSubFlow;
	private OrderCompletionSubFlow orderCompletionSubFlow;

	/**
	 * @return the orderCollectionSubFlow
	 */
	@XmlElement
	public OrderCollectionSubFlow getOrderCollectionSubFlow() {
		return orderCollectionSubFlow;
	}

	/**
	 * @param orderCollectionSubFlow
	 *            the orderCollectionSubFlow to set
	 */
	public void setOrderCollectionSubFlow(
			OrderCollectionSubFlow orderCollectionSubFlow) {
		this.orderCollectionSubFlow = orderCollectionSubFlow;
	}

	/**
	 * @return the orderValidatationSubFlow
	 */
	@XmlElement
	public OrderValidationSubFlow getOrderValidatationSubFlow() {
		return orderValidatationSubFlow;
	}

	/**
	 * @param orderValidatationSubFlow
	 *            the orderValidatationSubFlow to set
	 */
	public void setOrderValidatationSubFlow(
			OrderValidationSubFlow orderValidatationSubFlow) {
		this.orderValidatationSubFlow = orderValidatationSubFlow;
	}

	/**
	 * @return the orderApprovalSubFlow
	 */
	@XmlElement
	public OrderApprovalSubFlow getOrderApprovalSubFlow() {
		return orderApprovalSubFlow;
	}

	/**
	 * @param orderApprovalSubFlow
	 *            the orderApprovalSubFlow to set
	 */
	public void setOrderApprovalSubFlow(
			OrderApprovalSubFlow orderApprovalSubFlow) {
		this.orderApprovalSubFlow = orderApprovalSubFlow;
	}

	/**
	 * @return the orderProvisioningSubFlow
	 */
	@XmlElement
	public OrderProvisioningSubFlow getOrderProvisioningSubFlow() {
		return orderProvisioningSubFlow;
	}

	/**
	 * @param orderProvisioningSubFlow
	 *            the orderProvisioningSubFlow to set
	 */
	public void setOrderProvisioningSubFlow(
			OrderProvisioningSubFlow orderProvisioningSubFlow) {
		this.orderProvisioningSubFlow = orderProvisioningSubFlow;
	}

	/**
	 * @return the orderCompletionSubFlow
	 */
	@XmlElement
	public OrderCompletionSubFlow getOrderCompletionSubFlow() {
		return orderCompletionSubFlow;
	}

	/**
	 * @param orderCompletionSubFlow
	 *            the orderCompletionSubFlow to set
	 */
	public void setOrderCompletionSubFlow(
			OrderCompletionSubFlow orderCompletionSubFlow) {
		this.orderCompletionSubFlow = orderCompletionSubFlow;
	}

}
