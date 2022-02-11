/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
public class TestResult{

    private Integer testResultId;
   
    private String testType;
   
    private String result;
   
    private Date testTime;
  
    private Patient ngCachLy;

    public TestResult() {
    }

    public TestResult(Integer testResultId) {
        this.testResultId = testResultId;
    }

    public TestResult(Integer testResultId, String testType, String result, Date testTime, Patient ngCachLy) {
        this.testResultId = testResultId;
        this.testType = testType;
        this.result = result;
        this.testTime = testTime;
        this.ngCachLy = ngCachLy;
    }

    public Integer getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(Integer testResultId) {
        this.testResultId = testResultId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public Patient getNgCachLy() {
        return ngCachLy;
    }

    public void setNgCachLy(Patient ngCachLy) {
        this.ngCachLy = ngCachLy;
    }

    @Override
    public String toString() {
        return "KqXetNghiem{" + "testResultId=" + testResultId + ", testType=" + testType + ", result=" + result + ", testTime=" + testTime + ", ngCachLy=" + ngCachLy + '}';
    }
}
