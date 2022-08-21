package entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(name = "customers")
@Entity
@Data
public class CustomersDao {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_company")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CompaniesDao companiesDao;
}
