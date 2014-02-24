Cloud_VM_Provisioning_System
============================

cloud vm provisioning work flow web services implementation

Objective:
 This project has been developed as a POC/DEMO to implement and demonstrate a typical  work flow of ordering/setup/configuration/provisioning of virtual machine on cloud environment.

Scope:
 Providing the core/centralized system for provisioning the cloud vm orders

Implementation:
 The provisioning system is implemented as a REST web services where the various external systems can interact with this core system on various stages of order provisioning with the intent of
	•	creating new order
	•	initiating the work flow
	•	updating the task statuses
	•	configuring the various parameters
	•	viewing/tracking order flow
	•	cancelling the order
This has been implemented in a perfect SOA platform where other external systems like GUI’s, web applications, standalone desktop applications can be integrated in ease.

Technology stack:

	Language              – Java SE 6
	
	REST Web services     – Jersey 1.8
	
	Application container – Spring 3.0.5
	
	ORM                   – Hibernate 3.6.3
	
	Database              – H2 database 1.3.175
	
	Application Server    – Jetty 7.6.8
	
	Build tool            – Maven 2
	
	Others                – Eclipse, Firefox POSTER plug-in
