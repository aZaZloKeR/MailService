package com.azazland.mailservice.db.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int MessageId;

    @Column(name = "name")
    private String name;

    @Column(name = "theme")
    private String theme;

    @Column(name = "body")
    private String body;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
    private List<MailingData> mailingData;
}
