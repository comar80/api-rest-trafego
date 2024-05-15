package br.com.fiap.trafego.service;

import br.com.fiap.trafego.dto.MotoristaCadastroDTO;
import br.com.fiap.trafego.dto.MotoristaExibicaoDTO;
import br.com.fiap.trafego.model.Motorista;
import br.com.fiap.trafego.repository.MotoristaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public MotoristaExibicaoDTO salvarMotorista(MotoristaCadastroDTO motoristaDTO) {

        Motorista motorista = new Motorista();
        BeanUtils.copyProperties(motoristaDTO, motorista);

        Motorista motoristaSalvo = motoristaRepository.save(motorista);
        return new MotoristaExibicaoDTO(motoristaSalvo);
    }

    public MotoristaExibicaoDTO buscarPorId(Long id){
        Optional<Motorista> motoristaOptional = motoristaRepository.findById(id);

        if(motoristaOptional.isPresent()){
            return new MotoristaExibicaoDTO(motoristaOptional.get());
        } else {
            throw new RuntimeException("Motorista não encontrado");
        }
    }

    public Page<MotoristaExibicaoDTO> listarTodos(Pageable paginacao){
        return motoristaRepository
                .findAll(paginacao)
                .map(MotoristaExibicaoDTO::new);
    }

    public MotoristaExibicaoDTO buscarPorNome(String nome){
        Optional<Motorista> motoristaOptional = motoristaRepository.findByNome(nome);

        if(motoristaOptional.isPresent()){
            return new MotoristaExibicaoDTO(motoristaOptional.get());
        } else {
            throw new RuntimeException("Motorista não encontrado");
        }
    }

    public MotoristaExibicaoDTO buscarPorCpf(String cpf){
        Optional<Motorista> motoristaOptional = motoristaRepository.findByCpf(cpf);

        if(motoristaOptional.isPresent()){
            return new MotoristaExibicaoDTO(motoristaOptional.get());
        } else {
            throw new RuntimeException("Motorista não encontrado");
        }
    }

    public MotoristaExibicaoDTO atualizar(MotoristaCadastroDTO motoristaDTO){
        Optional<Motorista> motoristaOptional =
                motoristaRepository.findById(motoristaDTO.idMotorista());

        if(motoristaOptional.isPresent()){
            Motorista motorista = new Motorista();
            BeanUtils.copyProperties(motoristaDTO, motorista);

            return new MotoristaExibicaoDTO(motoristaRepository.save(motorista));
        } else {
            throw new RuntimeException("Motorista não encontrado");
        }
    }

    public void excluir(Long id){
        Optional<Motorista> motoristaOptional = motoristaRepository.findById(id);

        if(motoristaOptional.isPresent()){
            motoristaRepository.delete(motoristaOptional.get());
        } else {
            throw new RuntimeException("Motorista não encontrado");
        }
    }
}
