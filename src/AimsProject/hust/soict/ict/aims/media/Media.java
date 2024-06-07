package AimsProject.hust.soict.ict.aims.media;

import java.util.Comparator;
import java.util.Objects;
public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {
    }

    public Media(String title) {
        this.title = title;
    }

    public boolean isMatch(String title){
        return Objects.equals(this.getTitle(), title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        // Checking if the object is null or not an instance of Media
        if (!(obj instanceof Media)) return false;

        // Casting the object to Media type
        Media that = (Media) obj;

        // Checking if titles and costs are equal
        return Objects.equals(this.getTitle(), that.getTitle()) &&
                Float.compare(this.getCost(), that.getCost()) == 0;
    }

    @Override
    public String toString() {
        return getId() + " - " + getTitle() + " - " + getCategory() + " - " + getCost();
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


}
