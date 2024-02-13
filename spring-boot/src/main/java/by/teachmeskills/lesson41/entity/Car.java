package by.teachmeskills.lesson41.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "car", schema = "tms")
@NamedQueries(
        {
                @NamedQuery(name = "Car.selectAll", query = "SELECT c FROM Car c where deleted = false order by id ASC"),
        }
)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "deleted")
    private Boolean deleted = false;

    public Car(Long id, String name, Integer price, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.deleted = deleted;
    }
}
