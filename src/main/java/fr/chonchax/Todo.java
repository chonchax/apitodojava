package fr.chonchax;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Todo {
    private int id;
    private String title;
    private String description;
    private Timestamp created_at;
    private LocalDateTime due_time;
    private Status status;
    private int user_id;

    public enum Status {
        NOT_STARTED, TODO, IN_PROGRESS, DONE,
    }

    public Todo() {}

    public Todo(int id, String title, String description, Timestamp created_at, LocalDateTime due_time, Status status, int user_id)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created_at = created_at;
        this.due_time = due_time;
        this.status = status;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getDueTime() {
        return due_time;
    }

    public void setDueTime(LocalDateTime due_time) {
        this.due_time = due_time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
}
