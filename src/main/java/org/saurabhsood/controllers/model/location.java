package org.saurabhsood.controllers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "location",schema = "hieubui")
@Entity
public class location extends AuditModel{
    @Id
    @Column(name = "location_id")
    private UUID location_id;

    @Column(name = "CITY")
    private String CITY;

    @Column(name = "COUNTRY")
    private String COUNTRY;


    public UUID getLocation_id() {
        return location_id;
    }

    public void setLocation_id(UUID location_id) {
        this.location_id = location_id;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }
}
