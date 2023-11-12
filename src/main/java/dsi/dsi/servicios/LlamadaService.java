package dsi.dsi.servicios;


import dsi.dsi.entidades.Encuesta;
import dsi.dsi.entidades.Llamada;
import dsi.dsi.repositorios.EncuestaRepository;
import dsi.dsi.repositorios.LlamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LlamadaService {
    @Autowired
    LlamadaRepository llamadaRepository;

    public List<Llamada> findAll(){
        List<Llamada> llamadas = llamadaRepository.findAll();
        return llamadas;
    }
}