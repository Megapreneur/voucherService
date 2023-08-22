package com.megapreneur.voucher;

import com.megapreneur.voucher.model.Voucher;
import com.megapreneur.voucher.repository.VoucherRepository;
import com.megapreneur.voucher.service.VoucherService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VoucherServiceImplTest {

    private final VoucherService voucherService;
    private final VoucherRepository voucherRepo;

    @Autowired
    public VoucherServiceImplTest(VoucherService voucherService, VoucherRepository voucherRepo) {
        this.voucherService = voucherService;
        this.voucherRepo = voucherRepo;
    }

    @Test
    @Order(1)
    void testToGenerateVoucher() throws Exception {
        String category = "Silver";
        String voucherNumber = voucherService.generateVoucher(category);
        Voucher voucher = voucherRepo.findByVoucherNumber(voucherNumber);
        assertEquals(voucher.getCategory().toString(), category);
        System.out.println(voucher.getVoucherNumber());
    }

    @Test
    @Order(2)
    void testVoucherCanBeDeleted() throws Exception {
        String voucherNumber = "43412948092986800786de28cac-4b3b-44bd-9406-1b8943742f96GOL";
        Voucher savedVoucher = voucherRepo.findByVoucherNumber(voucherNumber);
        System.out.println(savedVoucher.getDeletedAt());
        voucherService.deleteVoucher(voucherNumber);
        System.out.println(savedVoucher.getDeletedAt());
        assertNull(savedVoucher.getDeletedAt());
    }
    @Test
    @Order(3)
    void testThatVoucherCanBeRedeemed() throws Exception {
        String voucherNumber = "5229584402118455638bd652268-29ef-46f9-86fd-3af2d3ed58f8GOL";
        Voucher savedVoucher = voucherRepo.findByVoucherNumber(voucherNumber);
        System.out.println(savedVoucher.getStatus());
        voucherService.redeemVoucher(voucherNumber);
        System.out.println(savedVoucher.getStatus());
        assertEquals(savedVoucher.getStatus().toString(), "Inactive");

    }
}
