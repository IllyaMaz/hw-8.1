package entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "customers")
@Entity
@Data
public class CustomersDao {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private CompaniesDao companiesDao;
}
