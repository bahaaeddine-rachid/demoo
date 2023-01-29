package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentModuleId implements Serializable {


    @Column(name="student_id")
    Integer studentId;

    @Column(name="module_id")
    Integer moduleId;

    public StudentModuleId() {
    }

    public StudentModuleId(Integer studentId, Integer moduleId) {
        this.studentId = studentId;
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModuleId that = (StudentModuleId) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(moduleId, that.moduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, moduleId);
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}
