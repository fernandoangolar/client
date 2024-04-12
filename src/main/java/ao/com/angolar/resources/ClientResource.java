package ao.com.angolar.resources;

import ao.com.angolar.dto.ClientDTO;
import ao.com.angolar.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                   @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                   @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                   @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<ClientDTO> clientDTOS = clientService.findAllPaged(pageRequest);

        return ResponseEntity.ok()
                .body(clientDTOS);
    }

    @GetMapping( value = "/{id_client}")
    public ResponseEntity<ClientDTO> findById(@PathVariable long id_client) {

        ClientDTO clientDTO = clientService.findById(id_client);

        return ResponseEntity.ok()
                .body(clientDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO clientDTO) {

        clientDTO = clientService.insert(clientDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientDTO);
    }

    @PutMapping(value = "/{id_client}")
    public ResponseEntity<ClientDTO> update(@PathVariable long id_client, @RequestBody ClientDTO clientDTO) {

        clientDTO = clientService.update(id_client, clientDTO);

        return ResponseEntity.ok()
                .body(clientDTO);
    }
}
