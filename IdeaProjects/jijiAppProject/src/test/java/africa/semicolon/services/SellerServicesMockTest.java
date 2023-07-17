package africa.semicolon.services;

import africa.semicolon.data.repository.UserRepository;
import africa.semicolon.data.repository.mocks.FirstRegisterRepository;
import africa.semicolon.dtos.requests.RegisterSellerRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;

@DataMongoTest
@ContextConfiguration(classes = TestConfig.class)
public class SellerServicesMockTest {
    @Autowired
    private UserRepository userRepository;
    private SellerServices sellerServices;

    @Test
    void registerSellerTest(){
        RegisterSellerRequest request = new RegisterSellerRequest();
        sellerServices.registerSeller(request);
        Assertions.assertEquals(1,userRepository.count());

    }
    @Test void  registerDuplicateSellerTest(){
        userRepository = new FirstRegisterRepository();
        sellerServices = new SellerServiceImplementation(null,userRepository);
        RegisterSellerRequest request = new RegisterSellerRequest();
        request.setUsername("sultan");
        sellerServices.registerSeller(request);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sellerServices.registerSeller(request));
        Assertions.assertEquals(1,userRepository.count());
    }
}
