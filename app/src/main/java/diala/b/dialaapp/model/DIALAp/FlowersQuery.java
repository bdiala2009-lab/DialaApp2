package diala.b.dialaapp.model.DIALAp;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;


@Dao
public interface FlowersQuery {
        /**
         *اعادة جميع معطيات جدول الورود
         * قائمة من الورود return@
         */
        @Query( "SELECT * FROM Flowers")
        List<Flowers> getAllflowers();
    /**
     ارجاع الورود حسب اسم الوردة وبالترتيب الطلبيات
     *رقم المستعمل *@param userid_p
     * @return
     */
    @Query("SELECT * FROM Flowers WHERE flowerName=:fname ORDER BY OrderNumber DESC")
    List<Flowers> getAllflowerOrderby(String fname);
}
