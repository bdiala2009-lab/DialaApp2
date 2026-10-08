package diala.b.dialaapp.model.MyUserTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface MyUserQuery {
    @Query("SELECT * FROM MyUser")
    List<MyUser> getAll();
    // استخراج مستعمل حسب رقم المميز لهid
    @Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")

    List<MyUser> loadAllByIds(int[] userIds);
    //هل المستعمل موجود حسب الايميل وكلمة السر
    //هل المستعمل موجود حسب الايميل وكلمة السر
    @Query("SELECT * FROM MyUser WHERE email = :myEmail AND passw = :myPassw LIMIT 1")

    MyUser checkEmailPassw(String myEmail, String myPassw);
    //فحص هل الايميل موجود من قبل
    @Query("SELECT * FROM MyUser WHERE email = :myEmail LIMIT 1")

    MyUser checkEmail(String myEmail);
    // اضافة مستعمل او مجموعة مستعملين
    @Insert
    void insertAll(MyUser... users);
    // حذف
    @Delete
    void delete(MyUser user);
    //حذف حسب الرقم المميز id
    @Query("Delete From MyUser WHERE keyid=:id ")

    void delete(int id);
    //اضافة مستعمل واحد
    @Insert
    void insert(MyUser myUser);
    //تعديل مستعمل او قائمة مستعملين
    @Update
    void update(MyUser...values);

}



