package diala.b.dialaapp.model.DIALAp;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class flowers {
    @PrimaryKey(autoGenerate = true)
    public long OrderNumber;
    @ColumnInfo(name = "full_Name")//اعطاء اسم جديد للعامود-الصفة في الجدول
    public String flowerName;
    public String color;
    public Double price;
    public double numofflowers;

}
