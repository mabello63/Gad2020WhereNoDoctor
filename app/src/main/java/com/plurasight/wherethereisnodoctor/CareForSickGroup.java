package com.plurasight.wherethereisnodoctor;

public class CareForSickGroup {

    public   String care_code, details,category_code, care_desc;

    public CareForSickGroup(String care_code, String details, String category_code) {
        this.care_code = care_code;
        this.details = details;
        this.category_code = category_code;
        this.care_desc = care_desc;
    }

    public CareForSickGroup(){}

    public String getCare_code() {
        return care_code;
    }

    public void setCare_code(String care_code) {
        this.care_code = care_code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getCare_desc() { return care_desc;  }

   public void setCare_desc(String care_desc) {
        this.care_desc = care_desc;
  }

}
