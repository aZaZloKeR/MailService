package com.azazland.mailservice.db.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mailing_data")
public class MailingData {
    @Id
    @Column(name = "mail")
    private String mail;

    @Column(name = "message_id")
    private int messageId;

}
