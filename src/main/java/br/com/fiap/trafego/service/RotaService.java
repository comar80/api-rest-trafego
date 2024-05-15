package br.com.fiap.trafego.service;


import br.com.fiap.trafego.dto.RotaCadastroDTO;
import br.com.fiap.trafego.dto.RotaExibicaoDTO;
import br.com.fiap.trafego.model.Rota;
import br.com.fiap.trafego.repository.RotaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RotaService {

    @Autowired
    private RotaRepository rotaRepository;

    public RotaExibicaoDTO salvar(RotaCadastroDTO rotaDTO) {

        Rota rota = new Rota();
        BeanUtils.copyProperties(rotaDTO, rota);

        Rota rotaSalva = rotaRepository.save(rota);
        return new RotaExibicaoDTO(rotaSalva);
    }

    public RotaExibicaoDTO buscarPorId(Long id){
        Optional<Rota> rotaOptional = rotaRepository.findById(id);

        if(rotaOptional.isPresent()){
            return new RotaExibicaoDTO(rotaOptional.get());
        } else {
            throw new RuntimeException("Rota não encontrada");
        }
    }

    public Page<RotaExibicaoDTO> listarTodos(Pageable paginacao){
        return rotaRepository
                .findAll(paginacao)
                .map(RotaExibicaoDTO::new);
    }

    public RotaExibicaoDTO atualizar(RotaCadastroDTO rotaDTO){
        Optional<Rota> rotaOptional =
                rotaRepository.findById(rotaDTO.idRota());

        if(rotaOptional.isPresent()){
            Rota rota = new Rota();
            BeanUtils.copyProperties(rotaDTO, rota);

            return new RotaExibicaoDTO(rotaRepository.save(rota));
        } else {
            throw new RuntimeException("Rota não encontrada");
        }
    }

    public void excluir(Long id){
        Optional<Rota> rotaOptional = rotaRepository.findById(id);

        if(rotaOptional.isPresent()){
            rotaRepository.delete(rotaOptional.get());
        } else {
            throw new RuntimeException("Rota não encontrada");
        }
    }
}
