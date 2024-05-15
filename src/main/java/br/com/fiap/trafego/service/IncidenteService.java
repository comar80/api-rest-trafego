package br.com.fiap.trafego.service;


import br.com.fiap.trafego.dto.IncidenteCadastroDTO;
import br.com.fiap.trafego.dto.IncidenteExibicaoDTO;
import br.com.fiap.trafego.model.Incidente;
import br.com.fiap.trafego.repository.IncidenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncidenteService {

    @Autowired
    private IncidenteRepository incidenteRepository;

    public IncidenteExibicaoDTO salvar(IncidenteCadastroDTO incidenteDTO) {

        Incidente incidente = new Incidente();
        BeanUtils.copyProperties(incidenteDTO, incidente);

        Incidente incidenteSalvo = incidenteRepository.save(incidente);
        return new IncidenteExibicaoDTO(incidenteSalvo);
    }

    public IncidenteExibicaoDTO buscarPorId(Long id){
        Optional<Incidente> incidenteOptional = incidenteRepository.findById(id);

        if(incidenteOptional.isPresent()){
            return new IncidenteExibicaoDTO(incidenteOptional.get());
        } else {
            throw new RuntimeException("Incidente não encontrado");
        }
    }

    public Page<IncidenteExibicaoDTO> listarTodos(Pageable paginacao){
        return incidenteRepository
                .findAll(paginacao)
                .map(IncidenteExibicaoDTO::new);
    }

    public IncidenteExibicaoDTO atualizar(IncidenteCadastroDTO incidenteDTO){
        Optional<Incidente> incidenteOptional =
                incidenteRepository.findById(incidenteDTO.idIncidente());

        if(incidenteOptional.isPresent()){
            Incidente incidente = new Incidente();
            BeanUtils.copyProperties(incidenteDTO, incidente);

            return new IncidenteExibicaoDTO(incidenteRepository.save(incidente));
        } else {
            throw new RuntimeException("Incidente não encontrado");
        }
    }

    public void excluir(Long id){
        Optional<Incidente> incidenteOptional = incidenteRepository.findById(id);

        if(incidenteOptional.isPresent()){
            incidenteRepository.delete(incidenteOptional.get());
        } else {
            throw new RuntimeException("Incidente não encontrado");
        }
    }
}
