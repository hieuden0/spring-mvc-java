package org.saurabhsood.controllers.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
public class ProductVO extends AuditModel {

    @PrimaryKey
    @Column(value = "time_id")
    private UUID product_id;

    @Column(value = "CLASS")
    private String CLASS;

    @Column(value = "INVENTORY")
    private String INVENTORY;

    @Column(value = "ITEM")
    private int ITEM;


    public UUID getProduct_id() {
        return product_id;
    }

    public void setProduct_id(UUID product_id) {
        this.product_id = product_id;
    }

    public String getCLASS() {
        return CLASS;
    }

    public void setCLASS(String CLASS) {
        this.CLASS = CLASS;
    }

    public String getINVENTORY() {
        return INVENTORY;
    }

    public void setINVENTORY(String INVENTORY) {
        this.INVENTORY = INVENTORY;
    }

    public int getITEM() {
        return ITEM;
    }

    public void setITEM(int ITEM) {
        this.ITEM = ITEM;
    }
}
