package africa.semicolon.data.repository;

import africa.semicolon.data.models.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
@ExtendWith(SpringExtension.class)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test void saveTest() {
        Product product = new Product();
        Product savedProduct = productRepository.save(product);
        assertEquals(1,productRepository.count());
        assertNotNull(savedProduct.getId());
    }
}