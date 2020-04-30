package com.happier.flowering.entity;

import java.util.List;

public class JasonBean {
    private List<Result> result;
    private long log_id;
    public void setResult(List<Result> result) {
        this.result = result;
    }
    public List<Result> getResult() {
        return result;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }
    public long getLog_id() {
        return log_id;
    }
}
