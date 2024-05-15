package br.com.fiap.trafego.service;


import br.com.fiap.trafego.dto.RegistroTrafegoCadastroDTO;
import br.com.fiap.trafego.dto.RegistroTrafegoExibicaoDTO;
import br.com.fiap.trafego.model.RegistroTrafego;
import br.com.fiap.trafego.repository.RegistroTrafegoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroTrafegoService {

    @Autowired
    private RegistroTrafegoRepository registroRepository;

    public RegistroTrafegoExibicaoDTO salvar(RegistroTrafegoCadastroDTO registroDTO) {

        RegistroTrafego registro = new RegistroTrafego();
        BeanUtils.copyProperties(registroDTO, registro);

        RegistroTrafego registroSalvo = registroRepository.save(registro);
        return new RegistroTrafegoExibicaoDTO(registroSalvo);
    }

    public RegistroTrafegoExibicaoDTO buscarPorId(Long id){
        Optional<RegistroTrafego> registroOptional = registroRepository.findById(id);

        if(registroOptional.isPresent()){
            return new RegistroTrafegoExibicaoDTO(registroOptional.get());
        } else {
            throw new RuntimeException("Registro não encontrado");
        }
    }

    public Page<RegistroTrafegoExibicaoDTO> listarTodos(Pageable paginacao){
        return registroRepository
                .findAll(paginacao)
                .map(RegistroTrafegoExibicaoDTO::new);
    }

    public RegistroTrafegoExibicaoDTO atualizar(RegistroTrafegoCadastroDTO registroDTO){
        Optional<RegistroTrafego> registroOptional =
                registroRepository.findById(registroDTO.idRegistroTrafego());

        if(registroOptional.isPresent()){
            RegistroTrafego registro = new RegistroTrafego();
            BeanUtils.copyProperties(registroDTO, registro);

            return new RegistroTrafegoExibicaoDTO(registroRepository.save(registro));
        } else {
            throw new RuntimeException("Registro não encontrado");
        }
    }

    public void excluir(Long id){
        Optional<RegistroTrafego> registroOptional = registroRepository.findById(id);

        if(registroOptional.isPresent()){
            registroRepository.delete(registroOptional.get());
        } else {
            throw new RuntimeException("Registro não encontrado");
        }
    }
}
