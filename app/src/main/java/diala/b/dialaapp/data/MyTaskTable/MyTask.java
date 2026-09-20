package diala.b.dialaapp.data.MyTaskTable;
@Entity
public class MyTask {
        @PrimaryKey(autoGenerate = true)
        /** مفتاح أساسي */
        public int keyId;
        /** أولوية */
        public int importance;
        /** عنوان المهمة */
        public String shortTitle;
        /** نص المهمة */
        public String text;
        /** لون بناء المهمة */
        public long time;



    /** هل تمت المهمة */
        public boolean isCompleted;

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    /** رقم موضوع المهمة */
        public int taskId;
        /** رقم المستخدم الذي أضاف المهمة */
        public long userId;
    }
public MyTask() {

}
public int getKeyId() {
    return keyId;
}

public void setKeyId(int keyId) {
    this.keyId = keyId;
}

}
