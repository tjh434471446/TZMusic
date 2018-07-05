package com.jiehao.tzmusic.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="tm_singer_collection")
public class SingerCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @OneToOne
    @JoinColumn(name="userDr",referencedColumnName = "id")
    private User user;
    @OneToMany
    @JoinColumn(name="singers",referencedColumnName = "id")
    private List<Singer> singers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }
}
