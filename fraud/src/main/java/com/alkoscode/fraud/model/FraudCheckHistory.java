package com.alkoscode.fraud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_check_history_id_sequence",
            sequenceName = "fraud_check_history_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_check_history_id_sequence")
    private Long id;
    private Long customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
