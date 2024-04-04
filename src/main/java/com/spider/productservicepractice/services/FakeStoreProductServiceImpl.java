package com.spider.productservicepractice.services;

import com.spider.productservicepractice.dtos.FakeStoreCrateProductDto;
import com.spider.productservicepractice.dtos.FakeStoreProductDto;
import com.spider.productservicepractice.models.Category;
import com.spider.productservicepractice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements  ProductService{

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Product getProductByid(Long id) {
        FakeStoreProductDto fakeStoreDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if (fakeStoreDto != null) {
            return convertFakeStoreProductDtoToProduct(fakeStoreDto);
        }
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreDto) {
        Product product = new Product();
        product.setId(fakeStoreDto.getId());
        product.setDescription(fakeStoreDto.getDescription());
        product.setTitle(fakeStoreDto.getTitle());
        product.setPrice(product.getPrice());
        product.setImage(product.getImage());
        Category category = new Category();
        category.setTitle(fakeStoreDto.getTitle());
        product.setCategory(category);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> productList = new ArrayList<>();
        if (products != null) {
            for(FakeStoreProductDto product : products){
                productList.add(convertFakeStoreProductDtoToProduct(product));
            }
        }
        return productList;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCrateProductDto productDto = convertProductToFakeStoreCreateProductDto(product);
        FakeStoreProductDto responseProduct = restTemplate.postForObject("https://fakestoreapi.com/products", productDto, FakeStoreProductDto.class);
        if (responseProduct != null) {
            return convertFakeStoreProductDtoToProduct(responseProduct);
        }
        return null;
    }

    private FakeStoreCrateProductDto convertProductToFakeStoreCreateProductDto(Product product)
    {
        FakeStoreCrateProductDto productDto = new FakeStoreCrateProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setCategory(product.getCategory().getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setImage(product.getImage());

        return productDto;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
