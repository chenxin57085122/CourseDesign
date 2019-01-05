package com.xinyuan.main.domain;

public class ShoppingAddress {
    private Integer id;

    private Integer userId;

    private String province;

    private String city;

    private String shippingPeople;

    private String phone;

    private String addressDetail;

    private String postalCode;

    private String county;

    private Boolean isDefault;

    public Boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getShippingPeople() {
        return shippingPeople;
    }

    public void setShippingPeople(String shippingPeople) {
        this.shippingPeople = shippingPeople == null ? null : shippingPeople.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"userId\":")
                .append(userId);
        sb.append(",\"province\":\"")
                .append(province).append('\"');
        sb.append(",\"city\":\"")
                .append(city).append('\"');
        sb.append(",\"shippingPeople\":\"")
                .append(shippingPeople).append('\"');
        sb.append(",\"phone\":\"")
                .append(phone).append('\"');
        sb.append(",\"addressDetail\":\"")
                .append(addressDetail).append('\"');
        sb.append(",\"postalCode\":\"")
                .append(postalCode).append('\"');
        sb.append(",\"county\":\"")
                .append(county).append('\"');
        sb.append(",\"isDefault\":")
                .append(isDefault);
        sb.append('}');
        return sb.toString();
    }
}