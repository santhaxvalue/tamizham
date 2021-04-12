package com.xvalue.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

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
    public RegisterResponse() {
    }

    /**
     *
     * @param data
     * @param serviceName
     * @param statusCode
     * @param status
     */
    public RegisterResponse(String statusCode, String status, String serviceName, Data data) {
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
         * @param token
         */
        public Data(String token, UserDetails userDetails) {
            super();
            this.token = token;
            this.userDetails = userDetails;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserDetails getUserDetails() {
            return userDetails;
        }

        public void setUserDetails(UserDetails userDetails) {
            this.userDetails = userDetails;
        }



        public class UserDetails {

            @SerializedName("email")
            @Expose
            private String email;
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
            private Boolean isDeleted;
            @SerializedName("addressId")
            @Expose
            private Object addressId;
            @SerializedName("isEmailVerification")
            @Expose
            private Object isEmailVerification;
            @SerializedName("user_detailscol")
            @Expose
            private Object userDetailscol;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("id")
            @Expose
            private Integer id;

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
             * @param mobileNo
             * @param userDetailscol
             * @param isEmailVerification
             * @param phoneNo
             * @param addressId
             * @param firstName
             * @param createdAt
             * @param isDeleted
             * @param id
             * @param email
             * @param updatedAt
             */
            public UserDetails(String email, String firstName, String lastName, String mobileNo, String phoneNo, Integer userTypeId, Boolean isDeleted, Object addressId, Object isEmailVerification, Object userDetailscol, String updatedAt, String createdAt, Integer id) {
                super();
                this.email = email;
                this.firstName = firstName;
                this.lastName = lastName;
                this.mobileNo = mobileNo;
                this.phoneNo = phoneNo;
                this.userTypeId = userTypeId;
                this.isDeleted = isDeleted;
                this.addressId = addressId;
                this.isEmailVerification = isEmailVerification;
                this.userDetailscol = userDetailscol;
                this.updatedAt = updatedAt;
                this.createdAt = createdAt;
                this.id = id;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
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

            public Boolean getIsDeleted() {
                return isDeleted;
            }

            public void setIsDeleted(Boolean isDeleted) {
                this.isDeleted = isDeleted;
            }

            public Object getAddressId() {
                return addressId;
            }

            public void setAddressId(Object addressId) {
                this.addressId = addressId;
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

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

        }









    }





}