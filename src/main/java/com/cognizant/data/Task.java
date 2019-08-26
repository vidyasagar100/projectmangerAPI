package com.cognizant.data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="task_table")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "Task_ID")
    private Integer taskId;

    @Column(name = "Parent_ID")
    private Integer parentId;

    @Column(name = "Project_ID")
    private Integer projectId;

    @Column(name = "Priority")
    private Integer priority;

    @Column(name = "Task")
    private String taskDesc;

    @Column(name = "Start_Date")
    private LocalDate startDate;

    @Column(name = "End_Date")
    private LocalDate endDate;

    @Column(name = "user_ID")
    private Integer userId;

    public String getParentTaskDesc() {
        return parentTaskDesc;
    }

    public void setParentTaskDesc(String parentTaskDesc) {
        this.parentTaskDesc = parentTaskDesc;
    }

    private String parentTaskDesc;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
