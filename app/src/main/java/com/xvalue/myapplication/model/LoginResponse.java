package com.xvalue.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status_code")
    @Expose
    private String statusCode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("service_name")
    @Expose
    private String serviceName;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginResponse() {
    }

    /**
     *
     * @param data
     * @param serviceName
     * @param statusCode
     * @param status
     */
    public LoginResponse(String statusCode, String status, String serviceName, Data data) {
        super();
        this.statusCode = statusCode;
        this.status = status;
        this.serviceName = serviceName;
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("expires_at")
        @Expose
        private String expiresAt;
        @SerializedName("user_details")
        @Expose
        private UserDetails userDetails;

        /**
         * No args constructor for use in serialization
         *
         */
        public Data() {
        }

        /**
         *
         * @param userDetails
         * @param expiresAt
         * @param token
         */
        public Data(String token, String expiresAt, UserDetails userDetails) {
            super();
            this.token = token;
            this.expiresAt = expiresAt;
            this.userDetails = userDetails;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getExpiresAt() {
            return expiresAt;
        }

        public void setExpiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
        }

        public UserDetails getUserDetails() {
            return userDetails;
        }

        public void setUserDetails(UserDetails userDetails) {
            this.userDetails = userDetails;
        }





    public class UserDetails {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("email_verified_at")
        @Expose
        private Object emailVerifiedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("mobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("phoneNo")
        @Expose
        private String phoneNo;
        @SerializedName("userTypeId")
        @Expose
        private Integer userTypeId;
        @SerializedName("isDeleted")
        @Expose
        private Integer isDeleted;
        @SerializedName("createdBy")
        @Expose
        private Object createdBy;
        @SerializedName("modifiedBy")
        @Expose
        private Object modifiedBy;
        @SerializedName("addressId")
        @Expose
        private Object addressId;
        @SerializedName("device_token")
        @Expose
        private Object deviceToken;
        @SerializedName("isEmailVerification")
        @Expose
        private Object isEmailVerification;
        @SerializedName("user_detailscol")
        @Expose
        private Object userDetailscol;
        @SerializedName("isPaid")
        @Expose
        private Object isPaid;
        @SerializedName("language")
        @Expose
        private Object language;

        /**
         * No args constructor for use in serialization
         *
         */
        public UserDetails() {
        }

        /**
         *
         * @param userTypeId
         * @param lastName
         * @param language
         * @param mobileNo
         * @param userDetailscol
         * @param isEmailVerification
         * @param phoneNo
         * @param addressId
         * @param deviceToken
         * @param createdAt
         * @param firstName
         * @param isPaid
         * @param isDeleted
         * @param emailVerifiedAt
         * @param createdBy
         * @param modifiedBy
         * @param id
         * @param email
         * @param updatedAt
         */
        public UserDetails(Integer id, String email, Object emailVerifiedAt, String createdAt, String updatedAt, String firstName, String lastName, String mobileNo, String phoneNo, Integer userTypeId, Integer isDeleted, Object createdBy, Object modifiedBy, Object addressId, Object deviceToken, Object isEmailVerification, Object userDetailscol, Object isPaid, Object language) {
            super();
            this.id = id;
            this.email = email;
            this.emailVerifiedAt = emailVerifiedAt;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.firstName = firstName;
            this.lastName = lastName;
            this.mobileNo = mobileNo;
            this.phoneNo = phoneNo;
            this.userTypeId = userTypeId;
            this.isDeleted = isDeleted;
            this.createdBy = createdBy;
            this.modifiedBy = modifiedBy;
            this.addressId = addressId;
            this.deviceToken = deviceToken;
            this.isEmailVerification = isEmailVerification;
            this.userDetailscol = userDetailscol;
            this.isPaid = isPaid;
            this.language = language;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }

        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public Integer getUserTypeId() {
            return userTypeId;
        }

        public void setUserTypeId(Integer userTypeId) {
            this.userTypeId = userTypeId;
        }

        public Integer getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Integer isDeleted) {
            this.isDeleted = isDeleted;
        }

        public Object getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Object createdBy) {
            this.createdBy = createdBy;
        }

        public Object getModifiedBy() {
            return modifiedBy;
        }

        public void setModifiedBy(Object modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        public Object getAddressId() {
            return addressId;
        }

        public void setAddressId(Object addressId) {
            this.addressId = addressId;
        }

        public Object getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(Object deviceToken) {
            this.deviceToken = deviceToken;
        }

        public Object getIsEmailVerification() {
            return isEmailVerification;
        }

        public void setIsEmailVerification(Object isEmailVerification) {
            this.isEmailVerification = isEmailVerification;
        }

        public Object getUserDetailscol() {
            return userDetailscol;
        }

        public void setUserDetailscol(Object userDetailscol) {
            this.userDetailscol = userDetailscol;
        }

        public Object getIsPaid() {
            return isPaid;
        }

        public void setIsPaid(Object isPaid) {
            this.isPaid = isPaid;
        }

        public Object getLanguage() {
            return language;
        }

        public void setLanguage(Object language) {
            this.language = language;
        }

    }

    }





}