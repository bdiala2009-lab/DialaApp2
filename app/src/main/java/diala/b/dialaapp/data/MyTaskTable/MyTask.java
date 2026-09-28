package diala.b.dialaapp.data.MyTaskTable;

import androidx.room.Entity;
 import androidx.room.PrimaryKey;

/**
 * فئة تمثل مهمة
 */
@Entity
public class MyTask
{
    public long getSubjId() {
        return subjId;
    }

public long keyid;
    /** رقم المهمة */
    /** 5-1: رقم المهمة */

    public int importance;
    /** عنوان قصير */
    public String shortTitle;
    /** نص المهمة */
    public String text;
    /** زمن بناء المهمة */
    public long time;
    /** هل تمت المهمة */
    public boolean isCompleted;
    /** رقم موضوع المهمة */
    public long subjId;
    /** رقم المستخدم الذي أضاف المهمة */
    public long userId;

    public MyTask() {
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public long getSubjld() {
        return subjId;
    }

    public void setSubjld(long subjld) {
        this.subjId= subjld;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public void setSubjId(long subjId) {
        this.subjId = subjId;
    }



    @Override
    public String toString() {
        return "MyTask{" +
                "keyid=" + keyid +
                ", importance=" + importance +
                ", shortTitle='" + shortTitle + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                ", subjId=" + subjId +
                ", userId=" + userId +
                '}';
    }
}