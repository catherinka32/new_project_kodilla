package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Badges {
    int votes;
    AttachmentsByType attachmentsByType;
}
