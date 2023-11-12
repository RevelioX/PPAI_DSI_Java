package dsi.dsi.servicios;

import dsi.dsi.entidades.Encuesta;
import dsi.dsi.repositorios.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncuestaService {

    @Autowired
    EncuestaRepository encuestaRepository;

    public List<Encuesta> findAll(){
        List<Encuesta> encuestas = encuestaRepository.findAll();
        return encuestas;
    }


}
