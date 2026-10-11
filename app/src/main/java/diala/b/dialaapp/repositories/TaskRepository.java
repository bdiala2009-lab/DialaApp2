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
    public TaskRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        taskQuery = db.getMyTaskQuery();
        allTasks = (LiveData<List<MyTask>>) taskQuery.getAllTasks();
    }

    /**
     * LiveData جلب جميع المهام الموجودة في قاعدة البيانات كـ.
     *
     * @return قائمة بجميع المهام المحدثة تلقائياً.
     */
    public LiveData<List<MyTask>> getAllTasks() {
        return allTasks;
    }
/**
 * إدراج مهمة أو عدة مهمات جديدة في قاعدة البيانات.
 *
 * @param t المهام المراد إضافتها.
 */
public void insertTask (MyTask...t){
    taskQuery.insertTask(t);
}
    /**
     * تحديث مهمة أو عدة مهمات في قاعدة البيانات.
     *
     * @param tasks المهام المراد تحديثها.
     */
public void updateTask(MyTask...tasks){
    taskQuery.updateTask(tasks);
}
/**
* حذف مهمة أو عدة مهمات من قاعدة البيانات.
            *
            * @param tasks المهام المراد حذفها.
            */
public void deleteTask(MyTask... tasks) {
    taskQuery.deleteTask(tasks);
}
/**
 * حذف مهمة محددة باستخدام معرفها الفريد (Task ID).
 *
 * @param taskId معرف المهمة المراد حذفها.
 */
public void deleteTask(long taskId){
    taskQuery.deleteTask(taskId);
}
}