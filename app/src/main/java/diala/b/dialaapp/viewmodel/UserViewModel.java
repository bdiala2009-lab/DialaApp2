package diala.b.dialaapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import diala.b.dialaapp.model.MyTaskTable.MyTask;
import diala.b.dialaapp.model.MyUserTable.MyUser;
import diala.b.dialaapp.repositories.TaskRepository;
import diala.b.dialaapp.repositories.UserRepository;


public class UserViewModel extends AndroidViewModel {
        private UserRepository repository;
        private LiveData<List<MyUser>> allUsers;

        public UserViewModel(@NonNull Application application) {
            super(application);
            repository = new UserRepository(application);
            allUsers = repository.getAllUsers();
        }
    public LiveData<List<MyTask>> getAll() {
        return allUsers ;
    }
}
