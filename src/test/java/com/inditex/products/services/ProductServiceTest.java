package com.inditex.products.services;


import com.inditex.products.common.BaseTest;
import com.inditex.products.domain.entity.ProductEntity;
import com.inditex.products.domain.entity.SizeEntity;
import com.inditex.products.domain.entity.StockEntity;
import com.inditex.products.domain.repository.ProductRepository;
import com.inditex.products.domain.repository.SizeRepository;
import com.inditex.products.domain.repository.StockRepository;
import com.inditex.products.exception.InditexException;
import com.inditex.products.model.Product;
import com.inditex.products.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest extends BaseTest {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private SizeRepository sizeRepository;

    @Mock
    private StockRepository stockRepository;

    private List<ProductEntity> productEntities;
    private List<SizeEntity> sizeEntities;
    private List<StockEntity> stockEntities;

    @BeforeEach
    public void init() {
        productService = new ProductServiceImpl(productRepository, sizeRepository, stockRepository);
    }

    @Test
    void givenRepositoryOutputEmptyProducts_whenAvailableProducts_thenReturnEmpty() {

        List<Product> products = productService.availableProducts();

        Assertions.assertEquals(0, products.size());

        verify(productRepository, times(1)).findAll();
    }

    @Test
    void givenRepositoryOutputDataSetTest1_whenAvailableProducts_thenReturnProduct1() throws IOException {

        productEntities = getFileFromListResources("jsons/products_test1.json", ProductEntity.class);
        sizeEntities = getFileFromListResources("jsons/sizes_test1.json", SizeEntity.class);
        stockEntities = getFileFromListResources("jsons/stocks_test1.json", StockEntity.class);

        Mockito.when(productRepository.findAll()).thenReturn(productEntities);
        Mockito.when(sizeRepository.findByProductId(anyInt())).thenReturn(sizeEntities);
        Mockito.when(stockRepository.findById(anyInt())).thenReturn(stockEntities.stream().findFirst());
        List<Product> products = productService.availableProducts();

        Assertions.assertNotNull(products);
        Assertions.assertEquals(products.get(0).getId(), productEntities.get(0).getId());

        verify(productRepository, times(1)).findAll();
        verify(sizeRepository, times(1)).findByProductId(anyInt());
        verify(stockRepository, times(1)).findById(anyInt());
    }

    @Test
    void givenRepositoryOutputDataSetTest2_whenAvailableProducts_thenReturnProduct2() throws IOException {

        productEntities = getFileFromListResources("jsons/products_test2.json", ProductEntity.class);
        sizeEntities = getFileFromListResources("jsons/sizes_test2.json", SizeEntity.class);
        stockEntities = getFileFromListResources("jsons/stocks_test2.json", StockEntity.class);

        Mockito.when(productRepository.findAll()).thenReturn(productEntities);
        Mockito.when(sizeRepository.findByProductId(anyInt())).thenReturn(sizeEntities);
        Mockito.when(sizeRepository.existsBySpecialAndProductId(anyBoolean(), anyInt())).thenReturn(true);

        List<Product> products = productService.availableProducts();
        Assertions.assertNotNull(products);
        Assertions.assertEquals(products.get(0).getId(), products.get(0).getId());

    }

    @Test
    void givenRepositoryOutputEmptyProducts_whenAvailableProducts_thenThrowException() {

        Mockito.when(productRepository.findAll()).thenThrow(new RuntimeException());

        InditexException exception = Assertions.assertThrows(InditexException.class, () -> productService.availableProducts());

        Assertions.assertEquals(exception.getErrorDescription(), "Error obtaining products");
        verify(productRepository, times(1)).findAll();
    }


}
