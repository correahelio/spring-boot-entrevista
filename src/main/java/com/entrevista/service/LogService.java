package com.entrevista.service;

import com.entrevista.model.Log;
import com.entrevista.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void saveLog(String texto) {
        Log log =  new Log(texto);

        try {
            logRepository.save(log);
        } catch(Exception ex) {
            System.out.println("Erro ao salvar log: " + ex);
        }
    }
}
