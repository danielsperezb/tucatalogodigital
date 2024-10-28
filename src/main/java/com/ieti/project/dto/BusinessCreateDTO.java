package com.ieti.project.dto;

import java.util.Date;

public class BusinessCreateDTO {

    private String name;
    private String password;
    private Date deathDate;
    private Integer key_code;

    public BusinessCreateDTO() {
    }

    // Constructor completo
    public BusinessCreateDTO(String name, String password, Date deathDate, Integer key_code) {
        this.name = name;
        this.password = password;
        this.deathDate = deathDate;
        this.key_code = key_code;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Integer getKeyCode() {
        return key_code;
    }

    public void setKeyCode(Integer key_code) {
        this.key_code = key_code;
    }

}
