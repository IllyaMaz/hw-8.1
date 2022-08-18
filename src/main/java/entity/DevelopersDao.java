package entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne
    @JoinColumn(name = "id_project")
    private ProjectsDao projectsDao;
}
