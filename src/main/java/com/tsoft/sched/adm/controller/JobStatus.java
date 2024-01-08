package com.tsoft.sched.adm.controller;

public enum JobStatus {
    DELETE(-1),
    READY(0),
    PROGRESS(1),
    ERROR(4),
    CANCELE(7),
    RETRY(9),
    COMPLETE(10);

    private final int code;

    JobStatus (int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
