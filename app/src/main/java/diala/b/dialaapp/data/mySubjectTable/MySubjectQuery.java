package diala.b.dialaapp.data.mySubjectTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface MySubjectQuery {
    @Dao
    public interface MySubjectQuery {

        /**
         * إعادة جميع معطيات جدول المواضيع
         * @return قائمة من المواضيع
         */
        @Query("SELECT * FROM MySubject")
        List<MySubject> getAllSubjects();

        /**
         * إدخال مجموعة مهام
         * @param s
         */
        @Insert
        void insert(MySubject... s);

        /**
         * تعديل المهام
         * @param s
         */
        @Update
        void update(MySubject... s);

        /**
         * حذف المهام حسب المفتاح الرئيسي
         * @param s
         */
        @Delete
        void delete(MySubject... s);

        @Query("DELETE FROM MySubject WHERE key_id=:keyid")
        void delete(long keyid);

        @Query("SELECT * FROM MySubject WHERE title=:sub")
        MySubject checkSubject(String sub);
    }
}
