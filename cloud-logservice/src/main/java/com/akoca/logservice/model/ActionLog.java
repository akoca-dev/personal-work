package com.akoca.logservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Document(indexName = "action_log", type = "article")
public class ActionLog {

    @Id
    private Long id;

    @Field(type = Text)
    private String requestServiceName;

    @Field(type = Text)
    private String requestUrl;

    @Field(type = FieldType.Integer)
    private Integer requestServicePort;

    @Field(type = FieldType.Integer)
    private Integer delay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Integer getRequestServicePort() {
        return requestServicePort;
    }

    public void setRequestServicePort(Integer requestServicePort) {
        this.requestServicePort = requestServicePort;
    }

    public String getRequestServiceName() {
        return requestServiceName;
    }

    public void setRequestServiceName(String requestServiceName) {
        this.requestServiceName = requestServiceName;
    }
}
