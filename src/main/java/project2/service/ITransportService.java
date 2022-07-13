package project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import project2.model.PaymentMethod;
import project2.model.Transport;

import java.util.List;
import java.util.Optional;

public interface ITransportService {

    List<Transport> getAllTransport();

    Optional<Transport> getTransportById(Long id);

}
