
package com.iudigital.human_resources.domain;

import java.sql.Date;

/**
 * @Juan Camilo Jimenez Vasquez
 */
public class Worker {

    private int id;
    private String identification_number;
    private String names;
    private String surnames;
    private String sex;
    private String adress;
    private String phone;
    private Date birthdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return names +" "+ surnames ;
    }
    
    
}
