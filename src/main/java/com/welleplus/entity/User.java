package com.welleplus.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name = "user",uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@Entity(name = "user")
public class User implements Serializable {
    private String id;
    private String userName;
    private String password;
    private Timestamp careateTime;

    @Id
    @GenericGenerator(name="idGenerator",strategy="uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "username")
    @NotBlank
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password")
    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "create_time",updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    public Timestamp getCareateTime() {
        return careateTime;
    }

    public void setCareateTime(Timestamp careateTime) {
        this.careateTime = careateTime;
    }
}
