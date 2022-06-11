package com.pojo;

public class Brand {
     // id 主键
    private Integer  id;
    // 品牌名称
    private String  brandName ;
    // 企业名称
    private String  companyNam;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String  description;
    // 状态：0：禁用  1：启用
    private Integer  status;

    public Brand() {
    }

    public Brand(Integer id, String brandName, String companyNam, Integer ordered, String description, Integer status) {
        this.id = id;
        this.brandName = brandName;
        this.companyNam = companyNam;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyNam() {
        return companyNam;
    }

    public void setCompanyNam(String companyNam) {
        this.companyNam = companyNam;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyNam='" + companyNam + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
