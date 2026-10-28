package diala.b.dialaapp.model.DIALAp;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface FlowersQuery {
    /*
     * اعادة جميع معطيات جدول الورود
     * قائمة من الورود return@
     */
    @Query("SELECT * FROM Flowers")
    List<Flowers> getAllflowers();

    /*
     * ارجاع الورود حسب اسم الوردة وبالترتيب الطلبيات
     * رقم المستعمل *@param userid_p
     *
     * @return
     */
    @Query("SELECT * FROM Flowers WHERE flowerName=:fname ORDER BY OrderNumber DESC")
    List<Flowers> getAllflowerOrderby(String fname);

    /*
     * ارجاع طلبيات حسب اسم الوردة واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
     * اسم الزهرة *@param flowerName
     * هل تمت ام لا@param isCompleted
     *
     * @return قائمة مهمات
     */
    @Query("SELECT * FROM Flowers WHERE flowerName=:fname AND isCompleted=:isCompleted " +
            "ORDER BY OrderNumber DESC")
    List<Flowers> getAllFlowerOrderedBy(String fname, boolean isCompleted);

    /*
     * إدخال مهام
     *
     * @param f مجموعة ورود
     */
    @Insert
    default void insertflower(Flowers... f) // ثلاثة نقاط تعني مجموعة
    {

    }

    /*
     * تعديل المهمات
     *
     * @param tasks مجموعة مهام للتعديل (التعديل حسب المفتاح الرئيسي)
     */
    @Update
    void updateflower(Flowers... f);

    /*
     * حذف مهمة أو مهام
     *
     * @param flowers حذف المهام (حسب المفتاح الرئيسي)
     */
    @Delete
   void deleteflower(Flowers... f);



    @Query("DELETE FROM Flowers WHERE flowerName=:fname")
     void deleteflower(String fname);




}


