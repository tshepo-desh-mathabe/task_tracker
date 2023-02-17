package co.za.task.tracker.entity;

import co.za.task.tracker.util.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.USER_STORY)
public class UserStory extends Task {
    @Id
    @Column(name = EntityConstants.USER_STORY_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userStoryId;
}
