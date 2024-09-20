package br.com.desafio.pagamento.controller;

import br.com.desafio.pagamento.domain.record.EmprestimoResponse;
import br.com.desafio.pagamento.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pagamento")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping("/pagar/{id}")
    public ResponseEntity<EmprestimoResponse> pagar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.emprestimoService.realizarPagamentoEmprestimo(id));
    }
}
