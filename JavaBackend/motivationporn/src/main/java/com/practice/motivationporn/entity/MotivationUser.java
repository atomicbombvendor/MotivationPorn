package com.practice.motivationporn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName(value = "motivation_user")
public class MotivationUser implements Serializable {

    private static final long serialVersionUID = 643588398390856689L;

    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String avatarUrl;

    private String password;

    private String email;

    private Integer status;

    private Integer priority;

    private LocalDateTime createTime;

    private LocalDateTime lastVisitedTime;

    private LocalDateTime updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastVisitedTime() {
        return lastVisitedTime;
    }

    public void setLastVisitedTime(LocalDateTime lastVisitedTime) {
        this.lastVisitedTime = lastVisitedTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "MotivationUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", lastVisitedTime=" + lastVisitedTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
