package by.teachmeskills.lesson33;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
public class User implements Cloneable {
    private Long id;
    private String name;
    private List<Role> roles;
    private Department department;

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", roles=" + roles + ", department=" + department + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(roles, user.roles) && Objects.equals(department, user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, roles, department);
    }

    protected User deepClone() throws CloneNotSupportedException {
        User newUser = (User) super.clone();
        Department department = this.department.clone();
        List<Role> roles = new ArrayList<>();
        for (Role role : this.roles) {
            roles.add(role.clone());
        }
        newUser.setDepartment(department);
        newUser.setRoles(roles);
        return newUser;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
