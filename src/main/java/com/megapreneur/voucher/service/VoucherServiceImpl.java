package com.megapreneur.voucher.service;

import com.megapreneur.voucher.model.Category;
import com.megapreneur.voucher.model.Status;
import com.megapreneur.voucher.model.Voucher;
import com.megapreneur.voucher.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service

public class VoucherServiceImpl implements VoucherService{
    private final VoucherRepository voucherRepo;
    @Override
    public String generateVoucher(String category) throws Exception {
        Voucher newVoucher = new Voucher();
        newVoucher.setTimeCreated(LocalDateTime.now());
        newVoucher.setStatus(Status.Active);
        newVoucher.setCategory(Category.valueOf(category));
        voucherNumber(category, newVoucher);
        voucherRepo.save(newVoucher);
        return newVoucher.getVoucherNumber();
    }

    private static void voucherNumber(String category, Voucher newVoucher) throws Exception {
        if (Category.valueOf(category).equals(Category.Diamond)){
            newVoucher.setVoucherNumber(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())) + UUID.randomUUID() + "DAI");
        } else if (Category.valueOf(category).equals(Category.Platinum)) {
            newVoucher.setVoucherNumber(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())) + UUID.randomUUID() + "PLA");
        } else if (Category.valueOf(category).equals(Category.Gold)) {
            newVoucher.setVoucherNumber(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())) + UUID.randomUUID() + "GOL");
        } else if (Category.valueOf(category).equals(Category.Silver)) {
            newVoucher.setVoucherNumber(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())) + UUID.randomUUID() + "SIL");
        }else {
            throw new Exception("Invalid category!!!");
        }
    }

    @Override
    public void deleteVoucher(String voucherNumber) throws Exception {
        Voucher voucher = voucherRepo.findByVoucherNumber(voucherNumber);
            if (voucher.getDeletedAt() == null){
                voucher.setDeletedAt(LocalDateTime.now());
                voucherRepo.save(voucher);
            }else {
                throw new Exception("Voucher has already been deleted !!!");
            }
    }

    @Override
    public void redeemVoucher(String voucherNumber) throws Exception {
        Optional<Voucher> voucher = Optional.ofNullable(voucherRepo.findByVoucherNumber(voucherNumber));
        if (voucher.isPresent()){
            if(voucher.get().getStatus().equals(Status.Active)){
                voucher.get().setStatus(Status.Inactive);
                voucherRepo.save(voucher.get());
            }else {
                throw new Exception("Voucher has already been used !!!");
            }
        }else {
            throw new Exception("Voucher doesn't exist!!!");
        }
    }
}
