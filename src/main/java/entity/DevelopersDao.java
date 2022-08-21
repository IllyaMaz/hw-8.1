package entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(name = "developers")
@Entity
@Data
public class DevelopersDao {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private Integer age;

    @Column
    private String gender;

    @Column
    private Integer salary;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_project")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProjectsDao projectsDao;
}
