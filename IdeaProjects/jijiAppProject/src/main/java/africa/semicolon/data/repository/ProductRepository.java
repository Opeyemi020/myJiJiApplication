package africa.semicolon.data.repository;

import africa.semicolon.data.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductRepository extends MongoRepository<Product, String> {


}
