package org.saurabhsood.controllers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "product",schema = "hieubui")
@Entity
public class product extends AuditModel{
    @Id
    @Column(name = "product_id")
    private UUID product_id;

    @Column(name = "CLASS")
    private String CLASS;

    @Column(name = "INVENTORY")
    private String INVENTORY;

    @Column(name = "ITEM")
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
