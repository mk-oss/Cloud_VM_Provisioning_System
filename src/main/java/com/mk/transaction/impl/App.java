package com.mk.transaction.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mk.pojo.CloudProvisioningFlow;
import com.mk.pojo.OrderApprovalSubFlow;
import com.mk.pojo.OrderCollectionSubFlow;
import com.mk.pojo.OrderCompletionSubFlow;
import com.mk.pojo.OrderProvisioningSubFlow;
import com.mk.pojo.OrderValidationSubFlow;
import com.mk.pojo.Task;
import com.mk.pojo.TaskDetails;
import com.mk.pojo.TaskEnum;
import com.mk.pojo.TaskStatus;
 
public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + h2");
		//intiateFlow("VM001");
		//updateTaskStatus("VM001","TASK01","STARTED");
		fetchProvisioningFlow("VM001");
	}
	
	public static void insert(){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();
		Task task = new Task("VM001TASK02","TASK02", "NOTSTARTED", null, new Date(), new Date());
		session.save(task);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateTaskStatus(String orderId, String taskId, String status){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();
		Task updateTask = (Task)session.get(com.mk.pojo.Task.class, orderId+taskId);
		if (status.equalsIgnoreCase(TaskStatus.COMPLETED.toString())
				|| status.equalsIgnoreCase(TaskStatus.CANCELED.toString())
				|| status.equalsIgnoreCase(TaskStatus.FAILED.toString())) {
			updateTask.setEnded(new Date());
		}else if (status.equalsIgnoreCase(TaskStatus.STARTED.toString())
				|| status.equalsIgnoreCase(TaskStatus.RESUME.toString())
				|| status.equalsIgnoreCase(TaskStatus.NOTSTARTED.toString())) {
			updateTask.setEnded(null);
		}
		updateTask.setStatus(status);
		session.save(updateTask);
		session.getTransaction().commit();
		session.close();
	}
	public static CloudProvisioningFlow fetchProvisioningFlow(String orderId){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Query query = session.createQuery("from Task where orderid = :orderId ");
		query.setParameter("orderId", orderId);
		List<Task> orderTasks = query.list();
		CloudProvisioningFlow cloudProvisioningFlow = new CloudProvisioningFlow();
		OrderCollectionSubFlow orderCollectionSubFlow = new OrderCollectionSubFlow();
		OrderValidationSubFlow orderValidationSubFlow = new OrderValidationSubFlow();
		OrderApprovalSubFlow orderApprovalSubFlow = new OrderApprovalSubFlow();
		OrderProvisioningSubFlow orderProvisioningSubFlow = new OrderProvisioningSubFlow();
		OrderCompletionSubFlow orderCompletionSubFlow = new OrderCompletionSubFlow();
		
		for(Task task : orderTasks){
			Task task1 = new Task();
			task1.setId(task.getTaskid());
			task1.setStarted(task.getStarted());
			task1.setEnded(task.getEnded());
			task1.setStatus(task.getStatus());
			for(TaskEnum t:TaskEnum.values()){
				if(task1.getId().equalsIgnoreCase(t.name())){
					task1.setName(t.getTaskName());
					task1.setType(t.getType());
					if(t.getSubFlow().equalsIgnoreCase("order_collection_sub_flow")){
						orderCollectionSubFlow.getTaskList().add(task1);
					}else if(t.getSubFlow().equalsIgnoreCase("order_validation_sub_flow")){
						orderValidationSubFlow.getTaskList().add(task1);
					}else if(t.getSubFlow().equalsIgnoreCase("order_approval_sub_flow")){
						orderApprovalSubFlow.getTaskList().add(task1);
					}else if(t.getSubFlow().equalsIgnoreCase("order_provisioning_sub_flow")){
						orderProvisioningSubFlow.getTaskList().add(task1);
					}else if(t.getSubFlow().equalsIgnoreCase("order_completion_sub_flow")){
						orderCompletionSubFlow.getTaskList().add(task1);
					}
				}
			}
		}
		cloudProvisioningFlow.setOrderCollectionSubFlow(orderCollectionSubFlow);
		cloudProvisioningFlow.setOrderValidatationSubFlow(orderValidationSubFlow);
		cloudProvisioningFlow.setOrderApprovalSubFlow(orderApprovalSubFlow);
		cloudProvisioningFlow.setOrderProvisioningSubFlow(orderProvisioningSubFlow);
		cloudProvisioningFlow.setOrderCompletionSubFlow(orderCompletionSubFlow);

		Collections.sort(cloudProvisioningFlow.getOrderCollectionSubFlow().getTaskList());
		Collections.sort(cloudProvisioningFlow.getOrderValidatationSubFlow().getTaskList());
		Collections.sort(cloudProvisioningFlow.getOrderApprovalSubFlow().getTaskList());
		Collections.sort(cloudProvisioningFlow.getOrderProvisioningSubFlow().getTaskList());
		Collections.sort(cloudProvisioningFlow.getOrderCompletionSubFlow().getTaskList());

		return cloudProvisioningFlow;
	}
	public static void intiateFlow(String orderid){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();
		Query query = session.createQuery("from TaskDetails");
		List<TaskDetails> allTasks = query.list();
		for(TaskDetails taskDetail : allTasks){
			session.save(new Task(orderid+taskDetail.getTaskid(),orderid,taskDetail.getTaskid(),"NOTSTARTED", new Date(), null));
		}
		System.out.println(allTasks.size());
		session.getTransaction().commit();
		session.close();
	}
}