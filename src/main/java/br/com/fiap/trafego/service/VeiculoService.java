package br.com.fiap.trafego.service;

import br.com.fiap.trafego.dto.VeiculoCadastroDTO;
import br.com.fiap.trafego.dto.VeiculoExibicaoDTO;
import br.com.fiap.trafego.model.Veiculo;
import br.com.fiap.trafego.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoExibicaoDTO salvarVeiculo(VeiculoCadastroDTO veiculoDTO) {

        Veiculo veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoDTO, veiculo);

        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
        return new VeiculoExibicaoDTO(veiculoSalvo);
    }

    public VeiculoExibicaoDTO buscarPorId(Long id){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if(veiculoOptional.isPresent()){
            return new VeiculoExibicaoDTO(veiculoOptional.get());
        } else {
            throw new RuntimeException("Veículo não encontrado");
        }
    }

    public Page<VeiculoExibicaoDTO> listarTodos(Pageable paginacao){
        return veiculoRepository
                .findAll(paginacao)
                .map(VeiculoExibicaoDTO::new);
    }

    public VeiculoExibicaoDTO buscarPorPlaca(String placa){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findByPlaca(placa);

        if(veiculoOptional.isPresent()){
            return new VeiculoExibicaoDTO(veiculoOptional.get());
        } else {
            throw new RuntimeException("Veiculo não encontrado");
        }
    }

    public List<VeiculoExibicaoDTO> buscarPorAno(Integer ano){
        return veiculoRepository
                .findByAnoFabricacao(ano)
                .stream()
                .map(VeiculoExibicaoDTO::new)
                .toList();
    }

    public List<VeiculoExibicaoDTO> listarVeiculosPorAno(Integer anoMinimo, Integer anoMaximo){
        return veiculoRepository
                .listarVeiculosPorAno(anoMinimo, anoMaximo)
                .stream()
                .map(VeiculoExibicaoDTO::new)
                .toList();
    }

    public VeiculoExibicaoDTO atualizar(VeiculoCadastroDTO veiculoDTO){
        Optional<Veiculo> veiculoOptional =
                veiculoRepository.findById(veiculoDTO.idVeiculo());

        if(veiculoOptional.isPresent()){
            Veiculo veiculo = new Veiculo();
            BeanUtils.copyProperties(veiculoDTO, veiculo);

            return new VeiculoExibicaoDTO(veiculoRepository.save(veiculo));
        } else {
            throw new RuntimeException("Veículo não encontrado");
        }
    }

    public void excluir(Long id){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if(veiculoOptional.isPresent()){
            veiculoRepository.delete(veiculoOptional.get());
        } else {
            throw new RuntimeException("Veículo não encontrado");
        }
    }
}
