package com.tel_ran.hederkosher.model.security.entity;

import com.tel_ran.hederkosher.model.common.entity.Room;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

/**
 * Created by Igor on 17.08.2016.
 */
public class UserGrantedAuthority implements GrantedAuthority {
    private long id;
    private Date createDate;
    private Role role;
    private Room room;

    public UserGrantedAuthority(Date createDate, Role role, Room room) {
        this.createDate = createDate;
        this.role = role;
        this.room = room;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Role getRole() {
        return role;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String getAuthority() {
        return role.getName();
    }

    @Override
    public String toString() {
        return "UserGrantedAuthority{" +
                "role=" + role +
                ", room=" + room +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGrantedAuthority that = (UserGrantedAuthority) o;

        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        return room != null ? room.equals(that.room) : that.room == null;

    }

    @Override
    public int hashCode() {
        int result = role != null ? role.hashCode() : 0;
        result = 31 * result + (room != null ? room.hashCode() : 0);
        return result;
    }
}
