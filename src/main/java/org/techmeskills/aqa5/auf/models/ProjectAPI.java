package org.techmeskills.aqa5.auf.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class ProjectAPI {
    int id;
    String name;
    String announcement;
    boolean show_announcement;
    boolean is_completed;
    String completed_on;
    int suite_mode;
    String url;
}
