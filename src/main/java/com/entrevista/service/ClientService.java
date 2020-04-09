package com.entrevista.service;

import com.entrevista.model.Client;
import com.entrevista.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private LogService logService;

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void saveClient(Client client) {
        try {
            clientRepository.save(client);
            logService.saveLog("Cliente [" + client.getName() + "] registrado." );
        } catch(Exception ex) {
            System.out.println("Erro ao salvar cliente: " + ex);
            logService.saveLog("Erro ao registrar cliente [" + client.getName() + "] " +  ex.getMessage() );
        }
    }
}
