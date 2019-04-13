package org.bitbucket.slawekhaa.realtimenotifer.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(
        name = "user_session",
        uniqueConstraints= @UniqueConstraint(columnNames={"session_token", "user_id"})
)
@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=2, max=255,message = "Sess token [:anum] 2-255")
    private String session_token;

    @NotNull
    @Min(value = 1, message = "User id be integer > 0")
    private int user_id;

//    @OneToOne
//    private User quest;

//    @OneToOne
//    private Session quest;

    public UserSession() {}


    public UserSession(int user_id, String session_token) {
        this.user_id = user_id;
        this.session_token = session_token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSession usess = (UserSession) o;
        return id == ((UserSession) o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session_token, user_id);
    }

    @Override
    public String toString() {
        return "id: " + id + " | uid:" + user_id + " | seess:" + session_token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getSession_token() {
        return session_token;
    }

    public void setSession_token(@NotNull String session_token) {
        this.session_token = session_token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
