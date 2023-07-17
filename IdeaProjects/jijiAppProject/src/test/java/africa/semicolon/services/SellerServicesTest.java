package africa.semicolon.services;
import africa.semicolon.data.repository.ProductRepository;
import africa.semicolon.dtos.requests.PostProductRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.math.BigDecimal;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class SellerServicesTest {
    @Autowired
    private SellerServiceImplementation sellerServiceImplementation;
    @Autowired
    private ProductRepository productRepository;

    @Test public void addProductTest(){
        PostProductRequest request = new PostProductRequest();
        request.setDescription("Sultan's Laptop, In need of urgent 2k");
        request.setName("Laptop");
        request.setPrice(BigDecimal. valueOf(2000));
        sellerServiceImplementation.postProduct(request);
        assertThat(productRepository.count(), is(1L));
        assertThat(productRepository.findAll().get(0).getName(), is("Laptop"));

    }
    @Test public void addProductResponseTest() {
        PostProductRequest request = new PostProductRequest();
        request.setDescription("Sultan's Laptop, In need of urgent 2k");
        request.setName("Laptop");
        request.setPrice(BigDecimal.valueOf(2000));
        var response = sellerServiceImplementation.postProduct(request);
//        assertThat(productRepository.count(), is(1L));
//        assertThat(productRepository.findAll().get(0).getName(), is("Laptop"));
        System.out.println(response.getId());
        Assertions.assertNotNull(response.getId());
    }



}