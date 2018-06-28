package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseSn;

    private String courseName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "courseStudent",
            joinColumns = @JoinColumn(name = "courseSn",referencedColumnName ="courseSn"),
            inverseJoinColumns = @JoinColumn(name = "userSn",referencedColumnName ="userSn" )
    )
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseSn() {
        return courseSn;
    }

    public void setCourseSn(String courseSn) {
        this.courseSn = courseSn;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
