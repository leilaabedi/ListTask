package com.maktab.task.controller.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.maktab.task.R;
import com.maktab.task.model.StateEnum;
import com.maktab.task.model.Task;
import com.maktab.task.repository.TaskRepository;

import java.util.List;

public class listFragment extends Fragment {
    StateEnum mState;

    private RecyclerView mRecyclerView;
    private TaskRepository mRepository;


    public listFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = TaskRepository.getInstance();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findViews(view);
        initViews();
        return view;
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Task> tasks = mRepository.getTasks();
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
        mRecyclerView.setAdapter(taskAdapter);
    }


    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_task_list);
    }


    private class TaskHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewTitle;
        private TextView mTextViewState;

        private Task mTask;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.row_item_task_title);
            mTextViewState = itemView.findViewById(R.id.row_item_task_state);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        public void bindTask(Task task) {
            StateEnum temp=StateEnum.Todo;
            int pos=getAdapterPosition();
            if (pos % 2==0) {
                mTextViewState.setBackgroundColor(Color.CYAN);
                mTextViewTitle.setBackgroundColor(Color.CYAN);
            }

            if (pos % 2==1) {
                mTextViewState.setBackgroundColor(Color.GREEN);
                mTextViewTitle.setBackgroundColor(Color.GREEN);
            }

            int rand;
            String name = "";
            mTask = task;
            mTextViewTitle.setText(task.getName());
            if (task.getStateEnum()==StateEnum.Todo)
                name="Todo";
            if (task.getStateEnum()==StateEnum.Done)
                name="Done";
            if (task.getStateEnum()==StateEnum.Doing)
                name="Doing";

            mTextViewState.setText(name);
           // mTextViewRand.setText(Integer.toString(rand));
        }



    }

        private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
            private List<Task> mTasks;

            public TaskAdapter(List<Task> Tasks) {
                this.mTasks = Tasks;
            }

            public List<Task> getTasks() {
                return mTasks;
            }

            public void setTasks(List<Task> Tasks) {
                this.mTasks = Tasks;
            }


            @Override
            public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                View view = layoutInflater.inflate(R.layout.task_row_list, parent, false);
                TaskHolder taskHolder = new TaskHolder(view);
                return taskHolder;
            }

            @Override
            public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
                Task task = mTasks.get(position);
                holder.bindTask(task);
            }

            @Override
            public int getItemCount() {
                return mTasks.size();
            }
        }







    }






