package demo.app.entities;

import demo.app.dto.UserDTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="user")
@SqlResultSetMappings(value = {
        @SqlResultSetMapping(name = "doSearchUser", classes = {
                @ConstructorResult(targetClass = UserDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "email", type = String.class),
                                @ColumnResult(name = "zone", type = String.class),
                                @ColumnResult(name = "status", type = String.class),
                                @ColumnResult(name = "phone", type = String.class)
                        })
        })

})
public class UserEntity {
    private Long id;
    private String email;
    private Timestamp enrollDate;
    private String image;
    private String name;
    private String password;
    private String phone;
    private String status;
    private String zone;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "enroll_date")
    public Timestamp getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Timestamp enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "zone")
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(enrollDate, that.enrollDate) && Objects.equals(image, that.image) && Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(phone, that.phone) && Objects.equals(status, that.status) && Objects.equals(zone, that.zone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, enrollDate, image, name, password, phone, status, zone);
    }
}
