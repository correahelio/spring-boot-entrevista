package com.entrevista;

import com.entrevista.model.Client;
import com.entrevista.repository.ClientRepository;
import com.entrevista.service.ClientService;
import com.entrevista.service.LogService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceTest {

    @MockBean
    private LogService logService;

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @Test
    public void testSaveClient() {
        Client client = new Client();
        client.setName("Jose");

        clientService.saveClient(client);

        List<Client> clients = clientService.getAllClients();
        Assert.assertNotNull(client);

        boolean joseExists = Boolean.FALSE;

        for(Client c : clients) {
            if("Jose".equals(c.getName())) {
                joseExists = Boolean.TRUE;
            }
        }

        Assert.assertTrue(joseExists);
    }
}
