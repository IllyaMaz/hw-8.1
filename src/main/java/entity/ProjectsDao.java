package entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(name = "projects")
@Entity
@Data
public class ProjectsDao {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private String deadline;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_company")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CompaniesDao companiesDao;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_customer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CustomersDao customersDao;
}
