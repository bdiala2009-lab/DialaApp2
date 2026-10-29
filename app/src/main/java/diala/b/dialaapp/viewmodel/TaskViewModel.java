package diala.b.dialaapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.ListIterator;

import diala.b.dialaapp.model.MyTaskTable.MyTask;
import diala.b.dialaapp.repositories.TaskRepository;

/**
 * نموذج عرض المهام (TaskViewModel) مسئول عن تجهيز وإدارة البيانات المتعلقة بالمهام (MyTask) لصالح واجهات المستخدم (Views/Activities).
 * يقوم بالاحتفاظ بالبيانات وتجاوز عمليات إعادة إنشاء النشاط (Configuration Changes) مثل دوران الشاشة،
 * ويتعامل مع {@link TaskRepository} لتنفيذ العمليات المختلفة.
 */

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository repository;
    private LiveData<List<MyTask>> allTasks;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع (TaskRepository) وجلب قائمة جميع المهام الأولية.
     *
     * @param application سياق التطبيق (Application Context) الممرر للـ AndroidViewModel.
     */
    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }

    /**
     * جلب جميع المهام كـ LiveData لمراقبتها من واجهة المستخدم.
     *
     * @return قائمة بجميع المهام محدثة تلقائياً.
     */
    public LiveData<List<MyTask>> getAllTasks() {
        return allTasks;
    }

    /**
     * جلب المهام الخاصة بمستخدم معين بناءً على معرف المستخدم (User ID).
     *
     * @param userId معرف المستخدم المراد جلب مهامه.
     * @return قائمة المهام الخاصة بالمستخدم.
     */

/**
 * إدراج مهمة أو عدة مهمات جديدة عبر المستودع.
 *
 * @param tasks المهام المراد إضافتها.
 */
public void insertTask(MyTask...tasks){
    repository.insertTask(tasks);
}
/**
 * تحديث مهمة أو عدة مهمات عبر المستودع.
 *
 * @param tasks المهام المراد تحديثها.
 */
public void updateTask(MyTask...tasks){
    repository.updateTask(tasks);
}
/**
 * حذف مهمة أو عدة مهمات عبر المستودع.
 *
 * @param tasks المهام المراد حذفها.
 */
public void deleteTask(MyTask...tasks){
    repository.deleteTask(tasks);
}
/**
 * حذف مهمة محددة باستخدام معرفها الفريد (Task ID).
 *
 * @param taskId معرف المهمة المراد حذفها.
 */
public void deleteTask(long taskId){
    repository.deleteTask(taskId);
}
}