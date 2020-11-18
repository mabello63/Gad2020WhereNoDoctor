package com.plurasight.wherethereisnodoctor;

public class PharmacyGroup {

    public   String MedCode, GenericName,OtherNames,Uses,Dosage,Warnings, Caution,SigeEffects,MoreInfo, GroupCode, Desc;

    public PharmacyGroup(String medCode, String genericName, String otherNames, String uses, String dosage, String warnings, String caution, String sigeEffects, String moreInfo, String groupCode, String desc) {
        MedCode = medCode;
        GenericName = genericName;
        OtherNames = otherNames;
        Uses = uses;
        Dosage = dosage;
        Warnings = warnings;
        Caution = caution;
        SigeEffects = sigeEffects;
        MoreInfo = moreInfo;
        GroupCode = groupCode;
        Desc = desc;
    }

    public PharmacyGroup(){}

    public String getMedCode() {
        return MedCode;
    }

    public void setMedCode(String medCode) {
        MedCode = medCode;
    }

    public String getGenericName() {
        return GenericName;
    }

    public void setGenericName(String genericName) {
        GenericName = genericName;
    }

    public String getOtherNames() {
        return OtherNames;
    }

    public void setOtherNames(String otherNames) {
        OtherNames = otherNames;
    }

    public String getUses() {
        return Uses;
    }

    public void setUses(String uses) {
        Uses = uses;
    }

    public String getDosage() {
        return Dosage;
    }

    public void setDosage(String dosage) {
        Dosage = dosage;
    }

    public String getWarnings() {
        return Warnings;
    }

    public void setWarnings(String warnings) {
        Warnings = warnings;
    }

    public String getCaution() {
        return Caution;
    }

    public void setCaution(String caution) {
        Caution = caution;
    }

    public String getSigeEffects() {
        return SigeEffects;
    }

    public void setSigeEffects(String sigeEffects) {
        SigeEffects = sigeEffects;
    }

    public String getMoreInfo() {
        return MoreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        MoreInfo = moreInfo;
    }

    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String groupCode) {
        GroupCode = groupCode;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
