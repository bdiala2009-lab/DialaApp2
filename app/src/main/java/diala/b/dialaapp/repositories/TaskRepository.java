package diala.b.dialaapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import diala.b.dialaapp.model.AppDataBase;
import diala.b.dialaapp.model.MyTaskTable.MyTask;
import diala.b.dialaapp.model.MyTaskTable.MyTaskQuery;

/**
        * مستودع المهام (MyTask) يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المهام (TaskRepository).
        * يقوم بفصل قاعدة بيانات
* Room  و {@link MyTaskQuery}
        * عن بقية أجزاء التطبيق (ViewModels).
        */

public class TaskRepository {
   private MyTaskQuery taskQuery;//واجهة اسعلامات
    private LiveData<List<MyTask>> allTasks;//مبنى معطيات يحوي جميع المهام المستخرجة
/**
 * منشئ الكلاس(constructor)
 * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
 *
 * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
 */
public TaskRepository(Application application){
    AppDataBase db= AppDataBase.getDB(application);
    taskQuery= db.getMyTaskQuery();
    allTasks= (LiveData<List<MyTask>>) taskQuery.getAllTasks();
}
    /**
     *LiveData جلب جميع المهام الموجودة في قاعدة البيانات كـ.
     *
     * @return قائمة بجميع المهام المحدثة تلقائياً.
     */
public LiveData<List<MyTask>> getAllTasks (){
    return allTasks;
    }
    /**
     * جلب المهام المرتبطة بمعرف مستخدم معين (User ID).
     *
     * @param userId معرف المستخدم المراد جلب مهامه.
     * @return قائمة المهام الخاصة بالمستخدم المحدد.
     */
public LiveData<List<MyTask>>getTaskByUserId(long userId){
    return taskQuery.getTasksByUserId(userId);
}
/**
 * جلب مهمة معينة بناءً على معرفها الفريد (Task ID).
 *
 * @param taskId معرف المهمة الفريد.
 * @return كائن المهمة المطلوب.
 */
public LiveData <MyTask> getTaskById(long taskId){
    return taskQuery.getTaskById(taskId);
}
/**
 * البحث عن المهام التي تتطابق عناوينها مع النص المدخل.
 *
 * @param title النص أو الكلمة المراد البحث عنها في العنوان.
 * @return قائمة المهام المطابقة.
 */
public LiveData<List<MyTask>>getTaskByTitle(String title){
    return taskQuery.getTasksByTitle()
}
}


