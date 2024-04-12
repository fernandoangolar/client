package ao.com.angolar.services;

import ao.com.angolar.dto.ClientDTO;
import ao.com.angolar.entities.Client;
import ao.com.angolar.repositories.ClientRepository;
import ao.com.angolar.services.excrption.ResourceEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {

        Page<Client> clients = clientRepository.findAll(pageRequest);

        return clients.map(
                client -> new ClientDTO(client)
        );
    }

    @Transactional
    public ClientDTO findById(long id_client) {

        Optional<Client> obgClient = clientRepository.findById(id_client);
        Client client = obgClient
                .orElseThrow(() -> new ResourceEntityNotFoundException(String.format("Client com o id %d não foi encontrado", id_client)));

        return new ClientDTO(client);
    }

    public ClientDTO insert(ClientDTO clientDTO) {

        Client client = new Client();
        copyClientTOClientDTO(clientDTO, client);
        client = clientRepository.save(client);

        return new ClientDTO(client);

    }

    @Transactional
    public ClientDTO update(long id_client, ClientDTO clientDTO) {

        try {
            Client client = clientRepository.getReferenceById(id_client);
            copyClientTOClientDTO(clientDTO, client);
            client = clientRepository.save(client);

            return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw  new ResourceEntityNotFoundException(String.format("Client com o id %d não foi encontrado", id_client));
        }
    }


    private Client copyClientTOClientDTO(ClientDTO clientDTO, Client client) {
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBithDate(clientDTO.getBithDate());
        client.setChildren(clientDTO.getChildren());

        return client;
    }
}
