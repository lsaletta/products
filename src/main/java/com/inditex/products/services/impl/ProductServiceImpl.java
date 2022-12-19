package com.inditex.products.services.impl;

import com.inditex.products.domain.entity.ProductEntity;
import com.inditex.products.domain.entity.SizeEntity;
import com.inditex.products.domain.repository.ProductRepository;
import com.inditex.products.domain.repository.SizeRepository;
import com.inditex.products.domain.repository.StockRepository;
import com.inditex.products.exception.InditexException;
import com.inditex.products.model.Product;
import com.inditex.products.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

@Log4j2
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    public static final Predicate<SizeEntity> backSoonPredicate = SizeEntity::getBackSoon;
    private final static Predicate<SizeEntity> specialPredidate = SizeEntity::getSpecial;
    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;
    private final StockRepository stockRepository;


    @Override
    public List<Product> availableProducts() {
        try {
            return StreamSupport.stream(
                            productRepository.findAll().spliterator(), false)
                    .filter(this::applyAssertions)
                    .distinct()
                    .map(i -> Product.builder().id(i.getId()).sequence(i.getSequence()).build())
                    .sorted(Comparator.comparing(Product::getSequence))
                    .toList();
        } catch (Exception e) {
            log.error("Exception: ", e);
            throw new InditexException("Error obtaining products", e);
        }
    }

    private boolean applyAssertions(ProductEntity product) {
        List<SizeEntity> byProductId = sizeRepository.findByProductId(product.getId());
        return byProductId
                .stream()
                .filter(backSoonPredicate.or(this::validateStock).and(this::checkSpecial))
                .findAny().isPresent();
    }

    private boolean validateStock(SizeEntity size) {
        return stockRepository.findById(size.getId())
                .stream()
                .anyMatch(stock -> stock.getQuantity() > 0);
    }

    private boolean checkSpecial(SizeEntity size) {
        if (sizeRepository.existsBySpecialAndProductId(true, size.getProductId())) {
            return sizeRepository.findByProductId(size.getProductId())
                    .stream()
                    .filter(specialPredidate.negate().and(backSoonPredicate.or(this::validateStock))).findAny().isPresent();
        }

        return true;
    }

}
