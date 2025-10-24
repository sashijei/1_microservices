package com.mercy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mercy.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
