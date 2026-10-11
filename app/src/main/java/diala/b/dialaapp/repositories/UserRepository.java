package diala.b.dialaapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import diala.b.dialaapp.model.AppDataBase;
import diala.b.dialaapp.model.MyUserTable.MyUser;
import diala.b.dialaapp.model.MyUserTable.MyUserQuery;

public class UserRepository {
    private  MyUserQuery userQuery;
    private LiveData<List<MyUser>> allUsers;

 /**
    * منشئ الكلاس (Constructor).
    * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمستعملين.
    *
    * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
    */
    public UserRepository(Application application) {
    AppDataBase db=AppDataBase.getDB(application);
    MyUserQuery userQuery = db.getMyUserQuery();
    List<MyUser> allUsers = userQuery.getAll();
}
/**
 * LiveDataجلب جميع المستعملين الموجودة في قاعدة البيانات ك
 *
 * @return  قائمة بجميع المستعملينالمحدثين تلقائيا
 */
public LiveData<List<MyUser>>getAllUsers(){
    return allUsers;
}
}

