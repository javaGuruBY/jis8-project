package com.tutrit.qs.webtgbot.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class StoredMessage {
    @Id
    private Integer updateId;
    private Long chatId;
    private String userName;
    private String text;
}
