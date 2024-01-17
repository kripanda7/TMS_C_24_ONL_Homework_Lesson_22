package by.teachmeskills.lesson39.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "car", schema = "tms")
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
    private Boolean deleted;

    public Car(Long id, String name, Integer price, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.deleted = deleted;
    }
}
