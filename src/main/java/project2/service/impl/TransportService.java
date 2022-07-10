package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Transport;
import project2.repository.ITransportRepository;
import project2.service.ITransportService;

import java.util.List;

@Service
public class TransportService implements ITransportService {
    @Autowired
    private ITransportRepository iTransportRepository;

    @Override
    public List<Transport> getAll() {
        return iTransportRepository.getAll();
    }
}
