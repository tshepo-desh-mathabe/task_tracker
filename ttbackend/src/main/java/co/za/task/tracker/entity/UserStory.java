package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.USER_STORY)
public class UserStory {
    @Id
    @JsonIgnore
    @Column(name = EntityConstants.USER_STORY_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userStoryId;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.TASK_ID, referencedColumnName = EntityConstants.TASK_ID)
    private Task task;
}
