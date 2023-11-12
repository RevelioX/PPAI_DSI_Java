package dsi.dsi.controlador;

import dsi.dsi.entidades.Encuesta;
import dsi.dsi.servicios.EncuestaService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EncuestaController {


    private final EncuestaService encuestaService;

    public EncuestaController(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public List<Encuesta> traerEncuestas(){
        return encuestaService.findAll();
    }
}