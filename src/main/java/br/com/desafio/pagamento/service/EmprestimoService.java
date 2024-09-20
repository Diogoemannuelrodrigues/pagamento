package br.com.desafio.pagamento.service;

import br.com.desafio.pagamento.domain.StatusPagamento;
import br.com.desafio.pagamento.domain.record.EmprestimoResponse;
import br.com.desafio.pagamento.exceptions.PagamentoNotFoundException;
import br.com.desafio.pagamento.repository.EmprestimoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    @Transactional
    public EmprestimoResponse realizarPagamentoEmprestimo(Integer id) {

        var emprestimo = this.emprestimoRepository
                .findById(id)
                .orElseThrow(PagamentoNotFoundException::new);

        emprestimo.setStatusPagamento(StatusPagamento.PAGO);

        return EmprestimoResponse.fromEntity(emprestimoRepository.save(emprestimo));

    }
}
