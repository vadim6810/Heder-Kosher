package com.tel_ran.hederkosher.model.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tel_ran.hederkosher.model.common.entity.Room;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Igor on 17.08.2016.
 */
@Entity
@Table(name = "user_granted_authority")
public class UserGrantedAuthority implements GrantedAuthority {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID", foreignKey = @ForeignKey(name = "FK_USER_GRANTED_AUTHORITY$ROLE_ID"))
    private Role role;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOM_ID", foreignKey = @ForeignKey(name = "FK_USER_GRANTED_AUTHORITY$ROOM_ID"))
    private Room room;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID") //foreignKey = @ForeignKey(name = "FK_USER_GRANTED_AUTHORITY$USER_ID"))
    private User user;

    public UserGrantedAuthority(Role role, Room room, User user) {
        this.role = role;
        this.room = room;
        this.user = user;
    }

    public UserGrantedAuthority() {
    }

    @Override
    public String toString() {
        return "UserGrantedAuthority{" +
                "role=" + role +
                ", room=" + room +
                '}';
    }

    /**
     * Getter for property 'role'.
     *
     * @return Value for property 'role'.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Setter for property 'role'.
     *
     * @param role Value to set for property 'role'.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Getter for property 'room'.
     *
     * @return Value for property 'room'.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Setter for property 'room'.
     *
     * @param room Value to set for property 'room'.
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGrantedAuthority that = (UserGrantedAuthority) o;

        if (id != that.id) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return role==null?"":role.getName();
    }
}
