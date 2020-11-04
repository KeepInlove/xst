package com.xst.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GUO
 * @Classname TaskExamCustomerAnswer
 * @Description 任务试卷完成结果
 * @Date 2020/11/4 10:11
 */
public class TaskExamCustomerAnswer implements Serializable {

    private static final long serialVersionUID = -556842372977600137L;

    private Integer id;

    private Integer taskExamId;

    private Integer createUser;

    private Date createTime;
    /*任务完成情况(Json)*/
    private Integer textContentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskExamId() {
        return taskExamId;
    }

    public void setTaskExamId(Integer taskExamId) {
        this.taskExamId = taskExamId;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTextContentId() {
        return textContentId;
    }

    public void setTextContentId(Integer textContentId) {
        this.textContentId = textContentId;
    }
}
