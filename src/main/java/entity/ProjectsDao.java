package entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne
    @JoinColumn(name = "id_company")
    private CompaniesDao companiesDao;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomersDao customersDao;
}
