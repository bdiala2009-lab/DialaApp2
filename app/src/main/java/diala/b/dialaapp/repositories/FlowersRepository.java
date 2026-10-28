package diala.b.dialaapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

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
    AllFlowers = (LiveData<List<Flowers>>) FlowersQuery.getAllFlowers();
}
    }