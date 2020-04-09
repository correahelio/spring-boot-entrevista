package com.entrevista.service;

import com.entrevista.model.Client;
import com.entrevista.model.Product;
import com.entrevista.repository.ClientRepository;
import com.entrevista.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{

    @Autowired
    private LogService logService;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        try {
            productRepository.save(product);
            logService.saveLog("Produto [" + product.getDescription() + "] registrado." );
        } catch(Exception ex) {
            System.out.println("Erro ao salvar produto: " + ex);
            logService.saveLog("Erro ao registrar produto [" + product.getDescription() + "] " +  ex.getMessage() );
        }

    }
}
