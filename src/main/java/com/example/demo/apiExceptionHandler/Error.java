package com.example.demo.apiExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

public class Error {
    private Integer status;
    private LocalDateTime dateHour;
    private String title;
    private List<Field> Fields;

    public static class Field{
        private String name;
        private String message;

        public Field(String name, String message) {
            setName(name);
            setMessage(message);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDateTime dateHour) {
        this.dateHour = dateHour;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Field> getFields() {
        return Fields;
    }

    public void setFields(List<Field> fields) {
        Fields = fields;
    }

}
