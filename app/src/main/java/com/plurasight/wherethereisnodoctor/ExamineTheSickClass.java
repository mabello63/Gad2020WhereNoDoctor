package com.plurasight.wherethereisnodoctor;

public class ExamineTheSickClass {

    public   String detail_code, procedure, exam_code, exam_description;

    public ExamineTheSickClass(String detail_code, String procedure, String exam_code, String exam_description) {
        this.detail_code = detail_code;
        this.procedure = procedure;
        this.exam_code = exam_code;
        this.exam_description = exam_description;
    }

    public ExamineTheSickClass() { }

    public String getDetail_code() {
        return detail_code;
    }

    public void setDetail_code(String detail_code) {
        this.detail_code = detail_code;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getExam_code() {
        return exam_code;
    }

    public void setExam_code(String exam_code) {
        this.exam_code = exam_code;
    }

    public String getExam_description() {
        return exam_description;
    }

    public void setExam_description(String exam_description) {
        this.exam_description = exam_description;
    }
}
