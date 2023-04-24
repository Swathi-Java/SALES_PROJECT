package com.lancesoft.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="projects")
public class Projects {
	@Id
private String projectid;
private String name;
@OneToOne
@JoinColumn(name="whiteid")
private Whitepaper whiteid;
@OneToOne
@JoinColumn(name="caseid")
private CaseStudy caseid;
@OneToOne
@JoinColumn(name="induid")
private Industries induid;

}
