package africa.semicolon.services;

import africa.semicolon.data.models.Product;
import africa.semicolon.data.models.User;
import africa.semicolon.data.repository.ProductRepository;
import africa.semicolon.data.repository.UserRepository;
import africa.semicolon.dtos.requests.PostProductRequest;
import africa.semicolon.dtos.requests.RegisterSellerRequest;
import africa.semicolon.dtos.responses.PostProductResponse;
import africa.semicolon.dtos.responses.RegisterSellerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImplementation implements SellerServices{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    public SellerServiceImplementation(ProductRepository productRepository, UserRepository userRepository){
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }
    @Override
    public PostProductResponse postProduct(PostProductRequest postProductRequest) {
        Product product = new Product();
        product.setName(postProductRequest.getName());
        product.setDescription(postProductRequest.getDescription());
        product.setPrice(postProductRequest.getPrice());
        Product savedProduct = productRepository.save(product);
        PostProductResponse response = new PostProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        return response;

    }
    public RegisterSellerResponse registerSeller(RegisterSellerRequest registerSellerRequest){
        User user = new User();
        user.setUsername(registerSellerRequest.getUsername());
        user.setPassword(registerSellerRequest.getPassword());
        userRepository.save(user);
        System.out.println(userRepository.count());
        return null;

    }

}
