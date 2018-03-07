package com.drye.myblog.demo.entity;

/**
 * The type Admin entity.
 *
 * @Description: AdminEntity实体类
 * @Author: GeekYe
 * @Date: 2018 /3/7
 */
public class AdminEntity {

    private Integer adminId;
    private String adminName;
    private String adminPassword;

    /**
     * Gets admin id.
     *
     * @return the admin id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * Sets admin id.
     *
     * @param adminId the admin id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * Gets admin name.
     *
     * @return the admin name
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * Sets admin name.
     *
     * @param adminName the admin name
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * Gets admin password.
     *
     * @return the admin password
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * Sets admin password.
     *
     * @param adminPassword the admin password
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * Instantiates a new Admin entity.
     *
     * @param adminName     the admin name
     * @param adminPassword the admin password
     */
    public AdminEntity(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    /**
     * Instantiates a new Admin entity.
     */
    public AdminEntity() {
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
