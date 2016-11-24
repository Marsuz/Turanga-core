package model.categories;


import model.common.EntityWithId;

import javax.persistence.Entity;

@Entity
public class ForbiddenWord extends EntityWithId{

    private String word;

    public ForbiddenWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForbiddenWord that = (ForbiddenWord) o;

        return word.equals(that.word);

    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
