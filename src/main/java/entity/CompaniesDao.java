package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "companies")
@Entity
@Data
public class CompaniesDao {
    @Id
    private Long id;

    @Column(name = "name_company")
    private String name;
}
