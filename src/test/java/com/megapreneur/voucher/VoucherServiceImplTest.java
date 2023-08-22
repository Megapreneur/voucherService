package com.megapreneur.voucher;

import com.megapreneur.voucher.repository.VoucherRepository;
import com.megapreneur.voucher.service.VoucherService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@AllArgsConstructor
public class VoucherAppTest {
    private final VoucherService voucherService;

    @Test
    @Order(1)
    void testToGenerateVoucher(){
        
    }
}
