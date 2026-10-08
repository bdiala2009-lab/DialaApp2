package diala.b.dialaapp.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import diala.b.dialaapp.model.MyTaskTable.MyTask;
import diala.b.dialaapp.model.MyTaskTable.MyTaskQuery;
import diala.b.dialaapp.model.MyUserTable.MyUser;
import diala.b.dialaapp.model.MyUserTable.MyUserQuery;
import diala.b.dialaapp.model.mySubjectTable.MySubject;
import diala.b.dialaapp.model.mySubjectTable.MySubjectQuery;


    /**
     * الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها
     * وتوفر لنا كائن للتعامل مع قاعدة البيانات
     */
    @Database(entities={MyUser.class, MySubject.class, MyTask.class},version=1)

    public abstract   class AppDataBase extends RoomDatabase{
        /**
         * كائن للتعامل مع قاعدة البيانات
         * @return
         */
        private static AppDataBase db;
        /**
         * يعيد كائن لعمليات جدول المستعملين
         * @return
         */
   public abstract MyUserQuery getMyUserQuery();
/**
 * يعيد كائن لعمليات جدول المهمات
 * @return
 */

        public abstract MySubjectQuery getMySubjectQuery();

        /**
         * يعيد حقول عمليات جدول المهام
         *
         * @return
         */
        public abstract MyTaskQuery getMyTaskQuery();

        /**
         * بناء قاعدة البيانات وإعادة قاعدة بيانات
         *
         * @param context
         * @return
         */
        public static AppDataBase getDB(Context context) {
            if (db == null) {
                db = Room.databaseBuilder(context,
                                AppDataBase.class,
                                "dialaDataBase")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
            return db;
        }
        }


