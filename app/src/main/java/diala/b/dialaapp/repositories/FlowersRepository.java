package diala.b.dialaapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import java.util.List;

import diala.b.dialaapp.model.AppDataBase;
import diala.b.dialaapp.model.DIALAp.Flowers;
import diala.b.dialaapp.model.DIALAp.FlowersQuery;
import diala.b.dialaapp.model.MyTaskTable.MyTask;

public class FlowersRepository {
    private FlowersQuery flowersQuery;
    private LiveData<List<Flowers>> AllFlowers;

    public FlowersRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        flowersQuery = db.getflowersQuery();
        AllFlowers = flowersQuery.getAllFlowers();
    }

    /**
     * جلب جميع الورود الموجودة في قاعدة البيانات كـ LiveData.
     *
     * @return قائمة بجميع الورود المحدثة تلقائياً.
     */
    public LiveData<List<Flowers>> getAllFlowers() {
        return AllFlowers;
    }

    /**
     * إرجاع الورود حسب اسم الوردة وبالترتيب التنازلي.
     *
     * @param fname اسم الوردة المراد البحث عنها.
     * @return قائمة الورود المحدثة تلقائياً كـ LiveData.
     */
    public List<Flowers> getAllflowerOrderby(String fname) {
        return flowersQuery.getAllflowerOrderby(fname);
    }

    /**
     * إرجاع الورود حسب اسم الوردة وحالة الإكمال مرتبة تنازلياً.
     *
     * @param fname       اسم الزهرة.
     * @param isCompleted حالة المكتملة.
     * @return قائمة الورود المطابقة كـ LiveData.
     */
    public List<Flowers> getAllFlowerOrderedBy(String fname, boolean isCompleted) {
        return flowersQuery.getAllFlowerOrderedBy(fname, isCompleted);
    }

    /**
     * إدراج زهرة أو عدة ورود جديدة في قاعدة البيانات.
     *
     * @param f الورود المراد إضافتها.
     */
    public void insert(Flowers... f) {
        flowersQuery.insertflower(f);
    }

    /**
     * تعديل زهرة أو عدة ورود موجودة في قاعدة البيانات.
     *
     * @param flowers الورود المراد تعديل بياناتها.
     */
    public void updateflower(Flowers... flowers) {
        flowersQuery.updateflower(flowers);
    }
/**
 * حذف زهرة أو عدة ورود من قاعدة البيانات.
 *
 * @param flowers الورود المراد حذفها.
 */
public void deleteflower(Flowers... flowers) {

        flowersQuery.deleteflower(flowers);
    }
    /**
     * حذف الورود التي تحمل اسماً معيناً.
     *
     * @param fname اسم الوردة المراد حذفها.
     */
    public void  deleteflower(String fname) {
        flowersQuery. deleteflower(fname);
        }
    }



