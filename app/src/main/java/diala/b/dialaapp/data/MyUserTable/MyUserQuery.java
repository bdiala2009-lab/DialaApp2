package diala.b.dialaapp.data.MyUserTable;

import androidx.room.Query;

import java.util.List;

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

    void insertAll(MyUser... users);
    // حذف

    void delete(MyUser user);
    //حذف حسب الرقم المميز id
    @Query("Delete From MyUser WHERE keyid=:id ")

    void delete(int id);
    //اضافة مستعمل واحد

    void insert(MyUser myUser);
    //تعديل مستعمل او قائمة مستعملين

    void update(MyUser...values);
}



