package com.entrevista;

import com.entrevista.model.Client;
import com.entrevista.repository.ClientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ClientRepositoryTest {

    @MockBean
    private TestEntityManager entityManager;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    public void insertTest() {
        String name = "Jose da Silva";

        Client client = clientRepository.findByName(name);
        Assert.assertNull(client);

        client = new Client(name);
        entityManager.persist(client);

        client = clientRepository.findByName(name);

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getId());
        Assert.assertEquals(client.getName(), name);
    }
}
