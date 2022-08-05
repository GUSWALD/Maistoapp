package Entity;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Entity
@Table(name = "foodmenu")

public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dishId")
    private int dishId;
    @Column(name = "dishName")
    private String dishName;
    @Column(name = "dishDesc")
    private String dishDesc;
    @Column(name = "orderCount")
    private int orderCount;
    @Column(name = "bought", columnDefinition = "SMALLINT")
    private boolean bought;

    public Menu() {
    }

    public Menu(int dishId, String dishName, String dishDesc) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishDesc = dishDesc;
    }

    public Menu(String dishName, String dishDesc) {
        this.dishName = dishName;
        this.dishDesc = dishDesc;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDesc() {
        return dishDesc;
    }

    public void setDishDesc(String dishDesc) {
        this.dishDesc = dishDesc;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public boolean isbought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public int getOrderCount(){
        return orderCount;
    }
    public void setOrderCount(int orderCount){
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return
                "Id of the dish = " + dishId +
                        ", Name of the dish = '" + dishName + '\'' +
                        ", Description of the dish = '" + dishDesc + ".";
    }
}