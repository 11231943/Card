package com.wheat.discountcard.bean;


/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

    // Fields

    @Override
    public String toString() {
        return "Userinfo [id=" + id + ", firstName=" + firstName + ", sex="
                + sex + ", phone=" + phone + ", pwd=" + pwd + "]";
    }

    /**
     * TODO field comment
     */
    private static final long serialVersionUID = 1L;
    private long id;
    private String firstName;
    private Integer sex;
    private String phone;
    private String pwd;

    // Constructors

    /** default constructor */
    public UserInfo() {
    }

    /** full constructor */
    public UserInfo(String firstName, Integer sex, String phone, String pwd) {
        this.firstName = firstName;
        this.sex = sex;
        this.phone = phone;
        this.pwd = pwd;
    }

    // Property accessors

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}