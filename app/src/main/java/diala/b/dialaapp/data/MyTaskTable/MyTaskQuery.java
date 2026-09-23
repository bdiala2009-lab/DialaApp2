package diala.b.dialaapp.data.MyTaskTable;

import androidx.room.Dao;
import androidx.room.Query;

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
     * ارجاع المهمات حسب المستعمل واذا انتهت ام لا
     */
}
