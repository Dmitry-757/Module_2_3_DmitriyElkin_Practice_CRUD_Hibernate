package com.Dmitry_Elkin.PracticeTaskCRUD.model;

import jakarta.persistence.*;

public enum Status {
    ACTIVE(1),
    DELETED(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    Status(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Status getStatusById(int i){
        return switch (i){
            case 1 -> Status.ACTIVE;
            case 0 -> Status.DELETED;
            default -> null;
        };
    }

}
