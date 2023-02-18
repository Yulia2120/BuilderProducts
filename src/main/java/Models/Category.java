package Models;

import java.util.ArrayList;


public class Category {
    private int Id;
    private String nameCategory;
    private double ratingCategory;

   public Category(int id, String category, double rating){
       this.Id = id;
       this.nameCategory = category;
       this.ratingCategory = rating;
   }

    public int getCategoryId() {
        return Id;
    }

    public String getCategory() {
        return nameCategory;
    }

    public double getRatingCategory() {
        return ratingCategory;
    }

    @Override
    public String toString() {
        return "Category: {" +
                "Id=" + Id +
                ", nameCategory='" + nameCategory + '\'' +
                ", ratingCategory=" + ratingCategory +
                '}';
    }
}
