CREATE TABLE voucher (
                         voucherId UUID PRIMARY KEY,
                         category VARCHAR(255),
                         voucherNumber VARCHAR(255),
                         status VARCHAR(255),
                         timeCreated TIMESTAMP,
                         deletedAt TIMESTAMP
);