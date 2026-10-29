package diala.b.dialaapp.model.DIALAp;
import diala.b.dialaapp.model.DIALAp.Flowers;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FlowersQuery {

    /**
     * إعادة جميع معطيات جدول الورود
     * @return قائمة من الورود
     */
    @Query("SELECT * FROM Flowers")
   LiveData<List<Flowers>> getAllFlowers();

    /**
     * ارجاع الورود حسب اسم الوردة وبالترتيب
     * @param fname اسم الوردة
     * @return قائمة الورود
     */
    @Query("SELECT * FROM Flowers WHERE flowerName=:fname ORDER BY OrderNumber DESC")
    List<Flowers> getAllflowerOrderby(String fname);

    /**
     * ارجاع طلبيات حسب اسم الوردة وإذا انتهت أم لا ومرتبة تنازلياً
     * @param fname اسم الزهرة
     * @param isCompleted هل تمت أم لا
     * @return قائمة ورود
     */
    @Query("SELECT * FROM Flowers WHERE flowerName=:fname AND isCompleted=:isCompleted " +
            "ORDER BY OrderNumber DESC")
    List<Flowers> getAllFlowerOrderedBy(String fname, boolean isCompleted);

    /**
     * إدخال مجموعة ورود
     * @param f مجموعة ورود
     */
    @Insert
    void insertflower(Flowers... f); // ثلاثة نقاط تعني مجموعة

    /**
     * تعديل المهام/الورود
     * @param f مجموعة ورود للتعديل
     */
    @Update
    void updateflower(Flowers... f);

    /**
     * حذف وردة أو مجموعة ورود
     * @param f مجموعة ورود للحذف
     */
    @Delete
   void deleteflower(Flowers... f);

    /**
     * حذف وردة حسب الاسم
     * @param fname اسم الوردة المراد حذفها
     */
    @Query("DELETE FROM Flowers WHERE flowerName=:fname")
     void deleteflower(String fname);




}


