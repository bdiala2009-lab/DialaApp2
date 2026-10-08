package diala.b.dialaapp.model.mySubjectTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MySubject {
    @PrimaryKey
    public long key_id;
    public String title;

    public void setTitle(String math) {
    }
}
