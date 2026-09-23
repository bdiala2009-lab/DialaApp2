package diala.b.dialaapp.data.MyTaskTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyTaskQuery {
    /**
     *اعادة جميع معطيات جدول المهمات
     * قائمة من المهمات return@
     */
    @Query("SELECT*FROM MyTask ORDER BY importance DESC")
    List<MyTask> getAllTasks();
    /**
        ارجاع المهمات حسب المستعمل واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
     *رقم المستعمل *@param userid_p
     * @return
     */
    @Query("SELECT*FROM MyTask WHERE userId=:userid_p ORDER BY time DESC")
    List<MyTask> getAllTaskOrderby(long userid_p);
    /**
     ارجاع المهمات حسب المستعمل واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
     *رقم المستعمل *@param userid_p
     * هل تمت ام لا@param isCompleted_p
     * @return قائمة مهمات
     */
    @Query("SELECT * FROM MyTask WHERE userId=:userid_p AND isCompleted=:isCompleted_p " +
            "ORDER BY importance DESC")
    List<MyTask> getAllTaskOrderedBy(long userid_p, boolean isCompleted_p);

    /**
     * إدخال مهام
     * @param t مجموعة مهام
     */
    @Insert
    void insertTask(MyTask... t); // ثلاثة نقاط تعني مجموعة

    /**
     * تعديل المهمات
     * @param tasks مجموعة مهام للتعديل (التعديل حسب المفتاح الرئيسي)
     */
    @Update
    void updateTask(MyTask... tasks);

    /**
     * حذف مهمة أو مهام
     * @param tasks حذف المهام (حسب المفتاح الرئيسي)
     */
    @Delete
    void deleteTask(MyTask... tasks);

    @Query("DELETE FROM MyTask WHERE keyId=:kid")
    void deleteTask(long kid);

    /**
     * استخراج جميع المهامات التابعة لرقم الموضوع
     * @param key_id رقم الموضوع
     * @return
     */
    @Query("SELECT * FROM MyTask WHERE subjId=:key_id" +
            " ORDER BY importance DESC")
    List<MyTask> getTasksBySubjId(long key_id);

}

