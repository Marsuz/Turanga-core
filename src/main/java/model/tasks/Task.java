package model.tasks;

/**
 * Created by Marcin on 2016-08-30.
 */
public interface Task {

    public String getDescription();
    public void setDescription(String description);

    public String getExampleCorrectQuery();
    public void setExampleCorrectQuery(String query);

    public String getCategory();
    public void setCategory(String category);

}
