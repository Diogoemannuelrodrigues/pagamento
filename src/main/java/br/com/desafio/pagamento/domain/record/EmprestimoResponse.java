package br.com.desafio.pagamento.domain.record;

import br.com.desafio.pagamento.domain.Emprestimo;
import br.com.desafio.pagamento.domain.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmprestimoResponse(
                                 Integer id,
                                 Integer numeroParcelas,
                                 BigDecimal valorEmprestimo,
                                 StatusPagamento statusPagamento,
                                 BigDecimal valorParcela,
                                 LocalDate dataCriacao) {

    public static EmprestimoResponse fromEntity(Emprestimo emprestimo) {
        return new EmprestimoResponse(
                emprestimo.getId(),
                emprestimo.getNumeroParcelas(),
                emprestimo.getValorEmprestimo(),
                emprestimo.getStatusPagamento(),
                emprestimo.getValorDaParcela(),
                emprestimo.getDataCriacao()
        );
    }
}
