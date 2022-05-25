package com.fantasy.backend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "athletes")
public class Athlete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer playerRank;

	private String name;

	private Integer started;

	private Integer passingYds;

	private Integer passingTds;

	private Integer rushingYds;

	private Integer rushingTds;

	private Integer recYds;

	private Integer recTds;

	private Integer fieldGoals;

	private Integer tackles;

	private Integer age;

	private String team;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team teamDb;

	// private Team team;

	private Integer passCompleted;

	private Integer passAttempted;

	private Integer interceptions;

	private Integer sacked;

	private Double sackedYdsLost;

	private String pos;

	public Long getId() {
		return this.id;
	}

	public void setId(Long newId) {
		this.id = newId;
	}

	public Integer getPlayerRank() {
		return this.playerRank;
	}

	public void setPlayerRank(Integer playerRank) {
		this.playerRank = playerRank;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStarted() {
		return this.started;
	}

	public void setStarted(Integer started) {
		this.started = started;
	}

	public Integer getPassingYds() {
		return this.passingYds;
	}

	public void setPassingYds(Integer passingYds) {
		this.passingYds = passingYds;
	}

	public Integer getPassingTds() {
		return this.passingTds;
	}

	public void setPassingTds(Integer passingTds) {
		this.passingTds = passingTds;
	}

	public Integer getRushingYds() {
		return this.rushingYds;
	}

	public void setRushingYds(Integer rushingYds) {
		this.rushingYds = rushingYds;
	}

	public Integer getRushingTds() {
		return this.rushingTds;
	}

	public void setRushingTds(Integer rushingTds) {
		this.rushingTds = rushingTds;
	}

	public Integer getRecYds() {
		return this.recYds;
	}

	public void setRecYds(Integer recYds) {
		this.recYds = recYds;
	}

	public Integer getRecTds() {
		return this.recTds;
	}

	public void setRecTds(Integer recTds) {
		this.recTds = recTds;
	}

	public Integer getFieldGoals() {
		return this.fieldGoals;
	}

	public void setFieldGoals(Integer fieldGoals) {
		this.fieldGoals = fieldGoals;
	}

	public Integer getTackles() {
		return this.tackles;
	}

	public void setTackles(Integer newTackles) {
		this.tackles = newTackles;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String newTeam) {
		this.team = newTeam;
	}

	public Team getTeamDb() {
		return this.teamDb;
	}

	public void setTeamDb(Team teamDb) {
		this.teamDb = teamDb;
	}

	public Integer getPassCompleted() {
		return this.passCompleted;
	}

	public void setPassCompleted(Integer passCompleted) {
		this.passCompleted = passCompleted;
	}

	public Integer getPassAttempted() {
		return this.passAttempted;
	}

	public void setPassAttempted(Integer passAttempted) {
		this.passAttempted = passAttempted;
	}

	public Integer getInterceptions() {
		return this.interceptions;
	}

	public void setInterceptions(Integer interceptions) {
		this.interceptions = interceptions;
	}

	public Integer getSacked() {
		return this.sacked;
	}

	public void setSacked(Integer sacked) {
		this.sacked = sacked;
	}

	public Double getSackedYdsLost() {
		return this.sackedYdsLost;
	}

	public void setSackedYdsLost(Double sackedYdsLost) {
		this.sackedYdsLost = sackedYdsLost;
	}

	public String getPos() {
		return this.pos;
	}

	public void setPos(String newPos) {
		this.pos = newPos;
	}

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public Athlete() {

	}

	public Athlete(Team teamDb) {
		this.teamDb = teamDb;
	}

}
