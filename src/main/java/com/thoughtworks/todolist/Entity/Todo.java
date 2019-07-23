package com.thoughtworks.todolist.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(name = "text")
    private String text;
    @Column(name = "is_complete")
    private boolean complete;

    @Column(name = "create_time")
    private Timestamp createTime;

    public Todo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public long getCreateTime() {
        return createTime.getTime();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
