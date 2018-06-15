package org.saurabhsood.controllers.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "sale",schema = "hieubui")
public class sale extends AuditModel {

    @Id
    @Column(name = "sale_id")
    private UUID sale_id;

    @Column(name = "DOLLARS", columnDefinition = "DOLLARS")
    private String DOLLARS;

    @Column(name = "location_id", columnDefinition = "location_id")
    private UUID location_id;

    @Column(name = "product_id", columnDefinition = "product_id")
    private UUID product_id;

    @Column(name = "time_id", columnDefinition = "time_id")
    private UUID time_id;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "time_id",referencedColumnName="time_id", insertable=false, updatable=false)
    private time time;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable=false, updatable=false)
    private product product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable=false, updatable=false)
    private location location;


    public UUID getSale_id() {
        return sale_id;
    }

    public void setSale_id(UUID sale_id) {
        this.sale_id = sale_id;
    }

    public String getDOLLARS() {
        return DOLLARS;
    }

    public void setDOLLARS(String DOLLARS) {
        this.DOLLARS = DOLLARS;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public void setLocation_id(UUID location_id) {
        this.location_id = location_id;
    }

    public UUID getProduct_id() {
        return product_id;
    }

    public void setProduct_id(UUID product_id) {
        this.product_id = product_id;
    }

    public UUID getTime_id() {
        return time_id;
    }

    public void setTime_id(UUID time_id) {
        this.time_id = time_id;
    }


    public time getTime() {
        return time;
    }

    public void setTime(time time) {
        this.time = time;
    }

    public org.saurabhsood.controllers.model.product getProduct() {
        return product;
    }

    public void setProduct(org.saurabhsood.controllers.model.product product) {
        this.product = product;
    }

    public org.saurabhsood.controllers.model.location getLocation() {
        return location;
    }

    public void setLocation(org.saurabhsood.controllers.model.location location) {
        this.location = location;
    }
}
