package com.ashokit.entity;
  

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data 
@Entity
@Table(name="Insurance_Policy")
public class InsurancePolicy {
	
	@Id
	@GeneratedValue
	private Integer coustmerId;
	private String coustmerName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmount;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminatedReason;
	public Integer getCoustmerId() {
		return coustmerId;
	}
	public void setCoustmerId(Integer coustmerId) {
		this.coustmerId = coustmerId;
	}
	public String getCoustmerName() {
		return coustmerName;
	}
	public void setCoustmerName(String coustmerName) {
		this.coustmerName = coustmerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	public Double getBenefitAmount() {
		return benefitAmount;
	}
	public void setBenefitAmount(Double benefitAmount) {
		this.benefitAmount = benefitAmount;
	}
	public String getDenialReason() {
		return denialReason;
	}
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	public LocalDate getTerminatedDate() {
		return terminatedDate;
	}
	public void setTerminatedDate(LocalDate terminatedDate) {
		this.terminatedDate = terminatedDate;
	}
	public String getTerminatedReason() {
		return terminatedReason;
	}
	public void setTerminatedReason(String terminatedReason) {
		this.terminatedReason = terminatedReason;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [coustmerId=" + coustmerId + ", coustmerName=" + coustmerName + ", gender=" + gender
				+ ", planName=" + planName + ", planStatus=" + planStatus + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", benefitAmount=" + benefitAmount + ", denialReason=" + denialReason
				+ ", terminatedDate=" + terminatedDate + ", terminatedReason=" + terminatedReason + "]";
	}
	
	
}
