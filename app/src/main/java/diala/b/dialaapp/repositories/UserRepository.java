package diala.b.dialaapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import diala.b.dialaapp.model.AppDataBase;
import diala.b.dialaapp.model.MyUserTable.MyUser;
import diala.b.dialaapp.model.MyUserTable.MyUserQuery;

/**
 * مستودع المستخدمين (UserRepository) يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المستخدمين (MyUser).
 * يقوم بفصل قاعدة بيانات Room و {@link MyUserQuery} عن بقية أجزاء التطبيق (ViewModels).
 */
public class UserRepository {
    private MyUserQuery userQuery;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمستخدمين.
     *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public UserRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        userQuery = db.getMyUserQuery();
    }

    /**
     * جلب جميع المستخدمين من قاعدة البيانات.
     *
     * @return قائمة بجميع المستخدمين.
     */
    public List<MyUser> getAllUsers() {
        return userQuery.getAll();
    }

    /**
     * جلب المستخدم بواسطة معرفه (ID).
     *
     * @param id معرف المستخدم.
     * @return LiveData تحتوي على قائمة المستخدمين المطابقين.
     */
    public LiveData<List<MyUser>> loadAllByIds(int id) {
        return userQuery.loadAllByIds(id);
    }


    /**
     * التحقق من وجود المستخدم بواسطة البريد الإلكتروني وكلمة المرور.
     *
     * @param email البريد الإلكتروني.
     * @param password كلمة المرور.
     * @return LiveData تحتوي على بيانات المستخدم في حال وجوده.
     */
    public LiveData<List<MyUser>> checkEmailPassw(String email, String password) {
        return userQuery.checkEmailPassw(email, password);
    }

    /**
     * التحقق من وجود البريد الإلكتروني مسبقاً.
     *
     * @param email البريد الإلكتروني المراد فحصه.
     * @return LiveData تحتوي على بيانات المستخدم إن وجد.
     */
    public LiveData<List<MyUser>> checkEmail(String email) {
        return userQuery.checkEmail(email);
    }

    /**
     * إدراج مستخدم واحد أو مجموعة مستخدمين في قاعدة البيانات.
     *
     * @param users المستخدمون المراد إضافتهم.
     */
    public void insertUser(MyUser... users) {
        userQuery.insertAll(users);
    }

    /**
     * تحديث بيانات مستخدم أو مجموعة مستخدمين.
     *
     * @param users المستخدمون المراد تحديث بياناتهم.
     */
    public void updateUser(MyUser... users) {
        userQuery.update(users);
    }

    /**
     * حذف مستخدم أو مجموعة مستخدمين من قاعدة البيانات.
     *
     * @param users المستخدمون المراد حذفهم.
     */
    public void deleteUser(MyUser... users) {
        userQuery.delete(users);
    }

    /**
     * حذف مستخدم محدد باستخدام معرفه (ID).
     *
     * @param id معرف المستخدم المراد حذفه.
     */
    public void deleteUser(int id) {
        userQuery.delete(id);
    }


}
