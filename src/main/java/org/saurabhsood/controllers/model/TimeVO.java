package org.saurabhsood.controllers.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Table
public class TimeVO {

    @PrimaryKey
    @Column(value = "time_id")
    private UUID TIME_ID;

    @Column(value = "CREATE_AT")
    private Date CREATE_AT;

    @Column(value = "MODIFIED_AT")
    private Date MODIFIED_AT;

    @Column(value = "MONTH")
    private int MONTH;

    @Column(value = "QUARTER")
    private int QUARTER;

    @Column(value = "YEAR")
    private int YEAR;


    public TimeVO() {
    }

    public TimeVO(UUID TIME_ID, Date CREATE_AT, Date MODIFIED_AT, int MONTH, int QUARTER, int YEAR) {
        this.TIME_ID = TIME_ID;
        this.CREATE_AT = CREATE_AT;
        this.MODIFIED_AT = MODIFIED_AT;
        this.MONTH = MONTH;
        this.QUARTER = QUARTER;
        this.YEAR = YEAR;
    }


    public UUID getTIME_ID() {
        return TIME_ID;
    }

    public void setTIME_ID(UUID TIME_ID) {
        this.TIME_ID = TIME_ID;
    }


    public int getMONTH() {
        return MONTH;
    }

    public void setMONTH(int MONTH) {
        this.MONTH = MONTH;
    }

    public int getQUARTER() {
        return QUARTER;
    }

    public void setQUARTER(int QUARTER) {
        this.QUARTER = QUARTER;
    }

    public int getYEAR() {
        return YEAR;
    }

    public void setYEAR(int YEAR) {
        this.YEAR = YEAR;
    }

    public Date getCREATE_AT() {
        return CREATE_AT;
    }

    public void setCREATE_AT(Date CREATE_AT) {
        this.CREATE_AT = CREATE_AT;
    }

    public Date getMODIFIED_AT() {
        return MODIFIED_AT;
    }

    public void setMODIFIED_AT(Date MODIFIED_AT) {
        this.MODIFIED_AT = MODIFIED_AT;
    }
}