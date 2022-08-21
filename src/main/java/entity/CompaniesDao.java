package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Table(name = "companies")
@Entity
@Data
public class CompaniesDao {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;


}
