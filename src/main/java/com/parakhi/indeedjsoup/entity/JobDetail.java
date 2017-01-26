package com.parakhi.indeedjsoup.entity;

public class JobDetail {

	private String jobTitle,companyName,jobLocation,salary,jobDescription;
	
	
	public JobDetail() {
		
	}

	public JobDetail(String jobTitle, String companyName, String jobLocation,
			String salary, String jobDescription) {
		
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.jobDescription = jobDescription;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	
}
