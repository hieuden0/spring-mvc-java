package org.saurabhsood.controllers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "time",schema = "hieubui")
public class time {
    @Id
    @Column(name = "time_id")
    private UUID time_id;

    @Column(name = "CREATE_AT")
    private Date CREATE_AT;

    @Column(name = "MODIFIED_AT")
    private Date MODIFIED_AT;

    @Column(name = "MONTH")
    private int MONTH;

    @Column(name = "QUARTER")
    private int QUARTER;

    @Column(name = "YEAR")
    private int YEAR;


    public UUID getTime_id() {
        return time_id;
    }

    public void setTime_id(UUID time_id) {
        this.time_id = time_id;
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
}
