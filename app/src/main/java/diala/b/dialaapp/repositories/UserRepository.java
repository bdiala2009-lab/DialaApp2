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

public LiveData<List<MyUser>>loadsAllByIds(int Id){
    return  userQuery.loadAllByIds(Id);
}
    public  LiveData<List<MyUser>>checkEmailPassw(String myEmail,String myPassw){
    return userQuery.checkEmailPassw(myEmail,myPassw);
    }
    public LiveData<List<MyUser>> checkEmail(String myEmail){
    return userQuery.checkEmail(myEmail);
    }
    public void insert(MyUser...Users){
        userQuery.insertAll(Users);
    }
    public void delete (MyUser...Users){
        userQuery.delete(Users);
    }
    public void delete(int id){
    userQuery.delete(id);
    }
    public void insert (MyUser myUser){
    userQuery.insert(myUser);
    }
    public void update(MyUser...values){
    userQuery.update(values);
    }
}


