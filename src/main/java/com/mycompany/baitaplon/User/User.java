package com.mycompany.baitaplon.User;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Id sẽ được tự động tạo bởi DataBase
    private Integer id;
    @Column(length = 45, nullable = true, name = "first_name")
    //Tham số cuối là mapping vào cột nào
    private String firstName;

    @Column(length = 20, nullable = true, name = "phone_number")
    private String phoneNumber;

    @Column(length = 10, nullable = false, name = "enable")
    private boolean enable;

    @Column(length = 45, nullable = false, name = "table_id")
    private String tableId;

    @Column(length = 10, nullable = false, name = "people_number")
    private int peopleNumber;

    @Column(length = 255, nullable = false)
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public String getTableId() {
        return tableId;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
