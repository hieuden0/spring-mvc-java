package org.saurabhsood.controllers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "sale")
public class SaleVO extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID sale_id;

    @Column()
    private String DOLLARS;

    private UUID location_id;

    private UUID product_id;

    private UUID time_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_id")
    @JsonIgnore
    private TimeVO timeVO;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private ProductVO productVO;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private LocationVO locationVO;

    public SaleVO() {
    }

    public SaleVO(String DOLLARS, UUID location_id, UUID product_id, UUID time_id, TimeVO timeVO) {
        this.setDOLLARS(DOLLARS);
        this.setLocation_id(location_id);
        this.setProduct_id(product_id);
        this.setTime_id(time_id);
        this.setTimeVO(timeVO);
    }


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

    public TimeVO getTimeVO() {
        return timeVO;
    }

    public void setTimeVO(TimeVO timeVO) {

        this.timeVO = timeVO;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    public LocationVO getLocationVO() {
        return locationVO;
    }

    public void setLocationVO(LocationVO locationVO) {
        this.locationVO = locationVO;
    }
}
