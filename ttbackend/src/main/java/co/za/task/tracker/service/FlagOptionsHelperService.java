package co.za.task.tracker.service;

import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.entity.dto.StatusDto;
import co.za.task.tracker.entity.dto.TaskFlagDto;
import co.za.task.tracker.util.constants.PayloadDetails;
import co.za.task.tracker.util.helper.service.util.IFindAll;
import co.za.task.tracker.util.payload.FlagOptionsResponse;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Service
public class FlagOptionsHelperService {
    private IFindAll<Set<TaskFlagDto>> taskFlagFinder;
    private IFindAll<Set<PriorityDto>> priorityFinder;
    private IFindAll<Set<StatusDto>> statusFinder;

    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllFlagOptions() {
        Map<String, Object> map = new HashMap<>();
        FlagOptionsResponse flagOptionsResponse = new FlagOptionsResponse(
                PayloadDetails.TASKS, PayloadDetails.PRIORITIES, PayloadDetails.STATUSES, map
        );
        flagOptionsResponse.setFlagOptions(taskFlagFinder.readAll(), priorityFinder.readAll(), statusFinder.readAll());

        return ResponseApiWrapper.okRequest(flagOptionsResponse.getFlagOptions());
    }
}
