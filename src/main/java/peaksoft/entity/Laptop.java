package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.OperatingSystem;

import java.lang.management.OperatingSystemMXBean;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author kurstan
 * @created at 24.01.2023 13:38
 */
@Entity
@Table (name = "laptops")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Laptop {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "laptop_id_generator"
    )
    @SequenceGenerator(
            name = "laptop_id_generator",
            sequenceName = "laptop_seq",
            allocationSize = 1
    )
    private Long id;
    private String brand;
    @Column(name = "operating_system")
    private OperatingSystem operatingSystem;
    private Double memory;
    private BigDecimal price;
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    public Laptop(String brand, OperatingSystem operatingSystem, Double memory, BigDecimal price, LocalDate dateOfIssue) {
        this.brand = brand;
        this.operatingSystem = operatingSystem;
        this.memory = memory;
        this.price = price;
        this.dateOfIssue = dateOfIssue;
    }
}
