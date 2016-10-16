package com.model;

import javax.persistence.Id;

public class Job {
	@Id
private int jobid;
private String jobname;
private String jobdescription;

public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
public String getJobdescription() {
	return jobdescription;
}
public String getJobname() {
	return jobname;
}
public void setJobname(String jobname) {
	this.jobname = jobname;
}
public void setJobdescription(String jobdescription) {
	this.jobdescription = jobdescription;
}
}
