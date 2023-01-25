package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BankServiceTest {
    BankService bankService;

    @BeforeEach
    void setup() {
        TransferStorage transferStorage = new TransferStorage();
        UserStorage userStorage = new UserStorage();
        bankService = new BankService(userStorage, transferStorage);
    }

    @Test
    void successfulUserRegister() {
        //when
        User testUser = bankService.registerNewUser(12, 1000);

        //then
        assertThat(testUser.toString()).isEqualTo("User{id=12, balance=1000.0}");
    }
    @Test
    void userDoesntExistInDataBase() {
        User testUser = bankService.findUserById(-1);
        assertThat(testUser).isNull();
    }

   @Test
   void succesfulTransferRequest() {
        Transfer testTransfer = bankService.transferRequest(1, 200);
        assertThat(testTransfer.toString()).isEqualTo("Transfer{id=10, userId=1, amountSend=-200.0, newBalance=9800.0, transferStatus=ACCEPTED}");
   }
   @Test
    void succesfulPutMoneyOnAccount() {
       Transfer testTransfer = bankService.putMoneyOnAccount(1, 200);
       assertThat(testTransfer.toString()).isEqualTo("Transfer{id=19, userId=1, amountSend=200.0, newBalance=10200.0, transferStatus=ACCEPTED}");
   }

   @Test
    void succesfulReadUserCredentials() {
        String testString = bankService.readUserCredentials(1);
        assertThat(testString).isEqualTo("User{id=1, balance=10000.0}");
   }
}

