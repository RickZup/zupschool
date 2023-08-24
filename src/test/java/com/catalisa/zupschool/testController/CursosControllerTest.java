package com.catalisa.zupschool.testController;

import com.catalisa.zupschool.controller.CursosController;
import com.catalisa.zupschool.model.CursoModel;
import com.catalisa.zupschool.service.CursosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CursosController.class)
public class CursosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CursosService cursosService;

    //Testes:

    @Test
    public void testListarCursos() throws Exception {

        List<CursoModel> cursosSimulados = new ArrayList<>();
        cursosSimulados.add(new CursoModel(1L, "Curso A", 40));
        cursosSimulados.add(new CursoModel(2L, "Curso B", 30));

        when(cursosService.buscarTodos()).thenReturn(cursosSimulados);

        mockMvc.perform(get("/cursos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(2))) // Verifica se existem 2 cursos na resposta
                .andExpect(jsonPath("$[0].nome", is("Curso A")))
                .andExpect(jsonPath("$[0].cargaHoraria", is(40)))
                .andExpect(jsonPath("$[1].nome", is("Curso B")))
                .andExpect(jsonPath("$[1].cargaHoraria", is(30)));
    }

    @Test
    public void testCadastrarCurso() throws Exception {
        CursoModel novoCurso = new CursoModel(1L, "Curso X", 50);

        when(cursosService.cadastrar(Mockito.any())).thenReturn(novoCurso);


        mockMvc.perform(post("/cursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novoCurso)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome", is("Curso X")))
                .andExpect(jsonPath("$.cargaHoraria", is(50)));
    }

    @Test
    public void testDeletarCurso() throws Exception {
        Long cursoId = 1L;

        mockMvc.perform(delete("/cursos/{id}", cursoId))
                .andExpect(status().isOk());

        verify(cursosService, times(1)).deletar(cursoId);
    }

}
