package com.megapreneur.voucher.controller;

import com.megapreneur.voucher.service.VoucherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/voucher")
@AllArgsConstructor
public class VoucherController {
    private final VoucherService voucherService;

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public ResponseEntity<Object> generateVoucher(@PathVariable("category") String category) throws Exception {
        return new ResponseEntity<>(voucherService.generateVoucher(category), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/deleteVoucher/{voucherNumber}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> deleteVoucher(@PathVariable("voucherNumber") String voucherNumber) throws Exception {
        voucherService.deleteVoucher(voucherNumber);
        return new ResponseEntity<>("Voucher has been deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/redeemVoucher/{voucherNumber}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> redeemVoucher(@PathVariable("voucherNumber") String voucherNumber) throws Exception {
        voucherService.redeemVoucher(voucherNumber);
        return new ResponseEntity<>("Voucher has been redeemed successfully", HttpStatus.OK);
    }
}
