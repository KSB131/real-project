package com.smhrd.carepose.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "patient") // DB 테이블명
public class PatientEntity {

    @Id
    private Long patient_id; // 환자 고유 번호 (PK)

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "room_bed", nullable = false)
    private String roomBed; // room_bed 속성

    // 필요한 다른 컬럼들 (나이, 병명 등) 추가 가능
}