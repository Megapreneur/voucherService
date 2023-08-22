package com.megapreneur.voucher.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Voucher {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID voucherId;
    @Enumerated(EnumType.STRING)
    private Category category;
//    @UniqueElements
    private String voucherNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime timeCreated;
    private LocalDateTime deletedAt;
}
