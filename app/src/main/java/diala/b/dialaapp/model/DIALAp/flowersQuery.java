package diala.b.dialaapp.model.DIALAp;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;


@Dao
public interface flowersQuery {
        /**
         *اعادة جميع معطيات جدول الورود
         * قائمة من الورود return@
         */
        @Query( "SELECT*FROM flowers")
        List<flowers> getAllflowers();
    /**
     ارجاع الورود حسب اسم الوردة وبالترتيب الطلبيات
     *رقم المستعمل *@param userid_p
     * @return
     */
    @Query("SELECT*FROM flowers WHERE fname=flowerName ORDER BY OrderNumber DESC")
    List<flowers> getAllTaskOrderby(string fname);
}
