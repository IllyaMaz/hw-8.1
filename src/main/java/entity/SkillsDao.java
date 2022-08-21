package entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_developer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DevelopersDao developersDao;
}
