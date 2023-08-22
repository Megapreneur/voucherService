package com.megapreneur.voucher.service;

import com.megapreneur.voucher.model.Voucher;
import org.springframework.stereotype.Service;

public interface VoucherService {
    String generateVoucher(String category) throws Exception;
    void deleteVoucher(String voucherNumber) throws Exception;
    void redeemVoucher(String voucherNumber) throws Exception;
}
