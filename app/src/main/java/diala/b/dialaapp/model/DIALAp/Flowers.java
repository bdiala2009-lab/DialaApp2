package diala.b.dialaapp.model.DIALAp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Flowers {
    @PrimaryKey(autoGenerate = true)
    public long OrderNumber;
    @ColumnInfo//اعطاء اسم جديد للعامود-الصفة في الجدول
    public String flowerName;
    public String color;
    public Double price;
    public double numofflowers;
    /** هل تمت الطلبية */
    public boolean isCompleted;
    public long getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getNumofflowers() {
        return numofflowers;
    }

    public void setNumofflowers(double numofflowers) {
        this.numofflowers = numofflowers;
    }

    @Override
    public String toString() {
        return "flowers{" +
                "OrderNumber=" + OrderNumber +
                ", flowerName='" + flowerName + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", numofflowers=" + numofflowers +
                '}';
    }

}

