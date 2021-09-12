package com.me.carsite.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "link")
@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "whatsapp_link")
    private String whatsappLink;
    @Column(name = "messenger_link")
    private String messengerLink;
    @Column(name = "linkedin_link")
    private String linkedinLink;
    @Column(name = "gmail_link")
    private String gmailLink;
}
