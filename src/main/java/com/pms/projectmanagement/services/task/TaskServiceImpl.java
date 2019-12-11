package com.pms.projectmanagement.services.task;

import com.pms.projectmanagement.dtos.TaskDto;
import com.pms.projectmanagement.enums.TaskStatus;
import com.pms.projectmanagement.models.Project;
import com.pms.projectmanagement.models.Task;
import com.pms.projectmanagement.models.User;
import com.pms.projectmanagement.repositories.ProjectRepository;
import com.pms.projectmanagement.repositories.TaskRepository;
import com.pms.projectmanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewTask(UUID projectId, UUID userId, TaskDto taskDto, String username) {
        Task task = modelMapper.map(taskDto,Task.class);

        Optional<User> user = userRepository.findById(userId);
        Optional<Project> project = projectRepository.findById(projectId);

        task.setOpenedUser(user.get());
        task.setProject(project.get());

        if(!username.equals("")){
            task.setSignedUser(userRepository.findByUsername(username));
            task.setSigned(true);
        }else{
            task.setSigned(false);
        }
        Long taskNumber = taskRepository.count();
        if(taskNumber != 0){
            task.setTaskNumber((int) (taskNumber+1L));
        }else{
            task.setTaskNumber(1);
        }
        task.setTaskStatus(TaskStatus.OPEN);
        taskRepository.save(task);


    }
}
