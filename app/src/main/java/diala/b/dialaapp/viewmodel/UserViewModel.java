package diala.b.dialaapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import diala.b.dialaapp.model.MyUserTable.MyUser;
import diala.b.dialaapp.repositories.UserRepository;

/**
 * نموذج عرض المستخدمين (UserViewModel) مسئول عن تجهيز وإدارة البيانات المتعلقة بالمستخدمين (MyUser) لصالح واجهات المستخدم (Views/Activities).
 * يقوم بالاحتفاظ بالبيانات وتجاوز عمليات إعادة إنشاء النشاط (Configuration Changes) مثل دوران الشاشة،
 * ويتعامل مع {@link UserRepository} لتنفيذ العمليات المختلفة.
 */
public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع (UserRepository) وجلب كائن إدارة بيانات المستخدمين.
     *
     * @param application سياق التطبيق (Application Context) الممرر للـ AndroidViewModel.
     */
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
    }
    /**
     * إدراج مستخدم جديد في قاعدة البيانات (التسجيل / Sign Up).
     *
     * @param user كائن المستخدم المراد إضافته.
     */
    public void insert(MyUser user) {
        repository.insert(user);
    }

    /**
     * جلب جميع المستخدمين من قاعدة البيانات.
     *
     * @return قائمة بجميع المستخدمين.
     */
    public List<MyUser> getAllUsers() {
        return repository.getAllUsers();
    }

    /**
     * جلب المستخدم بناءً على المعرف الخاص به (ID).
     *
     * @param userId معرف المستخدم المراد جلب بياناته.
     * @return LiveData تحتوي على قائمة البيانات المطابقة للمستخدم.
     */
    public LiveData<List<MyUser>> loadAllByIds(int userId) {
        return repository.loadAllByIds(userId);
    }

    /**
     * التحقق من البريد الإلكتروني وكلمة المرور عند تسجيل الدخول.
     *
     * @param email البريد الإلكتروني.
     * @param password كلمة المرور.
     * @return LiveData تحتوي على نتيجة التحقق من الحساب.
     */
    public LiveData<List<MyUser>> checkEmailPassw(String email, String password) {
        return repository.checkEmailPassw(email, password);
    }

    /**
     * التحقق مما إذا كان البريد الإلكتروني مسجلاً مسبقاً في النظام.
     *
     * @param email البريد الإلكتروني المراد فحصه.
     * @return LiveData تحتوي على نتيجة الفحص.
     */
    public LiveData<List<MyUser>> checkEmail(String email) {
        return repository.checkEmail(email);
    }

    /**
     * إدراج مستخدم جديد أو مجموعة مستخدمين عبر المستودع.
     *
     * @param users المستخدمون المراد إضافتهم.
     */
    public void insertUser(MyUser... users) {
        repository.insertUser(users);
    }

    /**
     * تحديث بيانات مستخدم أو مجموعة مستخدمين عبر المستودع.
     *
     * @param users المستخدمون المراد تحديث بياناتهم.
     */
    public void updateUser(MyUser... users) {
        repository.updateUser(users);
    }

    /**
     * حذف مستخدم أو مجموعة مستخدمين عبر المستودع.
     *
     * @param users المستخدمون المراد حذفهم.
     */
    public void deleteUser(MyUser... users) {
        repository.deleteUser(users);
    }

    /**
     * حذف مستخدم محدد باستخدام معرفه الفريد (User ID).
     *
     * @param userId معرف المستخدم المراد حذفه.
     */
    public void deleteUser(int userId) {
        repository.deleteUser(userId);
    }
}
