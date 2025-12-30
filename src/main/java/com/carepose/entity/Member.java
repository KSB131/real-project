package com.carepose.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pw", nullable = false)
    private String pw;

    @Column(name = "room_authority", nullable = false)
    private String roomAuthority; // 601CARE / 6NURS
}
