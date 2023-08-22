package com.megapreneur.voucher.repository;

import com.megapreneur.voucher.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, UUID> {
    Voucher findByVoucherNumber(String voucherNumber);

}
