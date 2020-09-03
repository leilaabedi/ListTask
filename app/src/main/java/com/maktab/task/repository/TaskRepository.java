package com.maktab.task.repository;

import com.maktab.task.controller.fragment.mainFragment;
import com.maktab.task.model.StateEnum;
import com.maktab.task.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
   public  int TASK_SIZE =mainFragment.num ;
    private static TaskRepository sInstance;
    private List<Task> mTasks;



    public static TaskRepository getInstance() {
        if (sInstance == null)
            sInstance = new TaskRepository();
        return sInstance;
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> mTasks) {
        this.mTasks = mTasks;
    }

    private TaskRepository() {
        int rand;
        StateEnum temp = StateEnum.Todo;
        mTasks = new ArrayList<>();
        for (int i = 0; i < TASK_SIZE; i++) {
            Task task = new Task();
            task.setName("task" + i);
            rand = makeRandom();
            if (rand==1)
                task.setStateEnum(temp.Todo);
            if (rand==2)
                task.setStateEnum(temp.Done);
            if (rand==3)
                task.setStateEnum(temp.Doing);

            mTasks.add(task);
        }


    }

    private int makeRandom() {
        int min, max, randOrder;
        max = 3;
        min = 1;
        randOrder = (int) (Math.random() * ((max - min) + 1)) + min;
        return randOrder;
    }


}
