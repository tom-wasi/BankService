package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.TransferStatus.ACCEPTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankServiceMockTest {

    @Mock
    private UserStorage userStorage;
    @Mock
    private TransferStorage transferStorage;
    @InjectMocks
    private BankService bankService;

    @Test
    void successRegisterNewUser() {
        ArrayList<User> testList = new ArrayList<>();
        testList.add(new User(1, 20000));
        when(userStorage.getUserList()).thenReturn(testList);
        User testUser = bankService.registerNewUser(2, 100);
        assertThat(testUser.toString()).isEqualTo("User{id=2, balance=100.0}");
    }
    @Test
    void userDoesntExistInDataBase() {
        when(userStorage.getUserList()).thenReturn(List.of(new User(1,1999)));
        User testUser = bankService.findUserById(2);
        assertThat(testUser).isNull();
    }
    @Test
    void successfulTransferRequest() {
        ArrayList<Transfer> testList = new ArrayList<>();
        testList.add(new Transfer(1,1, 200, 1799, ACCEPTED));
        when(userStorage.getUserList()).thenReturn(List.of(new User(1,1999)));
        when(transferStorage.getTransferList()).thenReturn(testList);
        Transfer testTransfer = bankService.transferRequest(1, 200);
        assertThat(testTransfer.toString()).isEqualTo("Transfer{id=10, userId=1, amountSend=-200.0, newBalance=1799.0, transferStatus=ACCEPTED}");
    }
    @Test
    void successfullyPutMoneyOnAccount() {
        ArrayList<Transfer> testList = new ArrayList<>();
        testList.add(new Transfer(1,1, 200, 1799, ACCEPTED));
        when(userStorage.getUserList()).thenReturn(List.of(new User(1,1999)));
        when(transferStorage.getTransferList()).thenReturn(testList);
        Transfer testTransfer = bankService.putMoneyOnAccount(1, 200);
        assertThat(testTransfer.toString()).isEqualTo("Transfer{id=19, userId=1, amountSend=200.0, newBalance=2199.0, transferStatus=ACCEPTED}");
    }
    @Test
    void successfulReadUserCredentials() {
        when(userStorage.getUserList()).thenReturn(List.of(new User(1,1999)));
        String testString = bankService.readUserCredentials(1);
        assertThat(testString).isEqualTo("User{id=1, balance=1999.0}");
    }
}
