package co.za.task.tracker.util.payload;

import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.entity.dto.StatusDto;
import co.za.task.tracker.entity.dto.TaskFlagDto;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class FlagOptionsResponse {
    private String tasks;
    private String priorities;
    private String statuses;
    private Map<String, Object> flagOptions;

    public void setFlagOptions(Set<TaskFlagDto> tasks, Set<PriorityDto> priorities, Set<StatusDto> statuses) {
        flagOptions.put(this.tasks, tasks);
        flagOptions.put(this.priorities, priorities);
        flagOptions.put(this.statuses, statuses);
    }

    public Map<String, Object> getFlagOptions() {
        return flagOptions;
    }
}
