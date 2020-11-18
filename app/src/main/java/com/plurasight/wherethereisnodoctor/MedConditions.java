package com.plurasight.wherethereisnodoctor;

public class MedConditions {
    public   String case_id, case_desc,treatment,signs, prevention, warnings, ref_page;

    public MedConditions(String case_id, String case_desc, String treatment, String signs, String prevention,
                         String warnings, String ref_page) {
        this.case_id = case_id;
        this.case_desc = case_desc;
        this.treatment = treatment;
        this.signs = signs;
        this.prevention = prevention;
        this.warnings = warnings;
        this.ref_page = ref_page;
    }

    public MedConditions(){

    }

    public String getCase_id() {
        return case_id;
    }

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }

    public String getCase_desc() {
        return case_desc;
    }

    public void setCase_desc(String case_desc) {
        this.case_desc = case_desc;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getSigns() {
        return signs;
    }

    public void setSigns(String signs) {
        this.signs = signs;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getRef_page() {
        return ref_page;
    }

    public void setRef_page(String ref_page) {
        this.ref_page = ref_page;
    }
}
