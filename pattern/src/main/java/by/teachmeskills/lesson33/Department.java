package by.teachmeskills.lesson33;

import lombok.Builder;

import java.util.Objects;

@Builder
public class Department implements Cloneable {
    private Long id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    protected Department clone() throws CloneNotSupportedException {
        return (Department) super.clone();
    }
}
