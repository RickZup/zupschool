package com.catalisa.zupschool.testController;

import com.catalisa.zupschool.controller.AlunosController;
import com.catalisa.zupschool.model.AlunoModel;
import com.catalisa.zupschool.service.AlunosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(AlunosController.class)
public class AlunosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private AlunosService alunosService;

    //Testes:

    @Test
    public void testBuscarTodos() throws Exception {

        // Simular uma lista de alunos simulados para o retorno do serviço mock
        List<AlunoModel> alunosSimulados = new ArrayList<>();
        alunosSimulados.add(new AlunoModel(1L, "Alice", 20, "alice@example.com"));
        alunosSimulados.add(new AlunoModel(2L, "Bob", 25, "bob@example.com"));

        // Configurar o comportamento do serviço mock (alunosService)
        when(alunosService.buscarTodos()).thenReturn(alunosSimulados);

        mockMvc.perform(get("/alunos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(2))) // Verifica se existem 2 alunos na resposta
                .andExpect(jsonPath("$[0].nome", is("Alice")))
                .andExpect(jsonPath("$[0].email", is("alice@example.com")))
                .andExpect(jsonPath("$[1].nome", is("Bob")))
                .andExpect(jsonPath("$[1].email", is("bob@example.com")));
    }

    @Test
    public void testCadastrarAluno() throws Exception {

        // Prepararando detalhes do novo aluno
        AlunoModel novoAluno = new AlunoModel();
        novoAluno.setNome("Ricardo");
        novoAluno.setIdade(28);
        novoAluno.setEmail("ricardo@example.com");

        // Configurarando o serviço p/simular cadastro
        when(alunosService.cadastrar(any(AlunoModel.class))).thenReturn(novoAluno);

        // Simular uma requisição POST com detalhes do novo aluno no corpo
        mockMvc.perform(post("/alunos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novoAluno)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome", is("Ricardo")))
                .andExpect(jsonPath("$.idade", is(28)))
                .andExpect(jsonPath("$.email", is("ricardo@example.com")));
    }

    @Test
    public void testDeletarAluno() throws Exception {
        Long idDoAluno = 1L;

        mockMvc.perform(delete("/alunos/{id}", idDoAluno))
                .andExpect(status().isOk());

        verify(alunosService).deletar(idDoAluno);
    }

}
