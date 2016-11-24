package model.categories;

import model.common.EntityWithId;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Category extends EntityWithId {

    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}