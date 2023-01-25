package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransferStorage {

    private List<Transfer> transferList= new ArrayList<>();

    public TransferStorage() {
        transferList.add(new Transfer(1, 2, 200, 10200, TransferStatus.ACCEPTED));
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }
}
