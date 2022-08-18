package entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "skills")
@Entity
@Data
public class SkillsDao {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private String level;

    @ManyToOne
    @JoinColumn(name = "id_developer")
    private DevelopersDao developersDao;
}
