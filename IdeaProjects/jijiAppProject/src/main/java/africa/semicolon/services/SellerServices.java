package africa.semicolon.services;

import africa.semicolon.dtos.requests.PostProductRequest;
import africa.semicolon.dtos.requests.RegisterSellerRequest;
import africa.semicolon.dtos.responses.PostProductResponse;
import africa.semicolon.dtos.responses.RegisterSellerResponse;

public interface SellerServices {
    PostProductResponse postProduct(PostProductRequest postProductRequest);

    RegisterSellerResponse registerSeller(RegisterSellerRequest request);
}
