package com.entrevista.controller;

import com.entrevista.model.ClientRequestBody;
import com.entrevista.model.Product;
import com.entrevista.service.ClientService;
import com.entrevista.model.Client;
import com.entrevista.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Client> getClientList() {
        List<Client> clientList = new ArrayList<>();
        clientList.addAll(clientService.getAllClients());
        return clientList;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveClient(@RequestBody ClientRequestBody clientRequestBody) {
        Client client =  new Client();
        client.setName(clientRequestBody.getClient().getName());

        Product product = new Product();
        product.setCodigo(clientRequestBody.getProduct().getCodigo());
        product.setDescription(clientRequestBody.getProduct().getDescription());

        clientService.saveClient(client);
        productService.saveProduct(product);
    }
}
