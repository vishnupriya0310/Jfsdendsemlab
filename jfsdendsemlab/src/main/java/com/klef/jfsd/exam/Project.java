package com.klef.jfsd.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_table")
public class Project
{
	@Id
	@Column(name = "pid")
    private int id;
	@Column(name="pname",length = 50,nullable = false)
    private String Name;
	@Column(name="pduration",length = 10,nullable = false)
    private String duration;
	@Column(name="pbudget",length = 30,nullable = false)
    private Double Budget;
	@Column(name="fteamlead",nullable = false)
    private String TeamLead;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Double getBudget() {
		return Budget;
	}
	public void setBudget(Double budget) {
		Budget = budget;
	}
	public String getTeamLead() {
		return TeamLead;
	}
	public void setTeamLead(String teamLead) {
		TeamLead = teamLead;
	}
	
	
}