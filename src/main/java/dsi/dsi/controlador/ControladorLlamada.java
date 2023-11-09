package dsi.dsi.controlador;

import dsi.dsi.entidades.Llamada;
import dsi.dsi.repositorios.LlamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;


@Controller
public class ControladorLlamada {

    @Autowired
    private LlamadaRepository llamadaRepository;

    @RequestMapping(value = "/filtrarLlamadas", method = RequestMethod.GET)
    public ModelAndView filtrarPorPeriodo(
            @RequestParam("fechaInicio") String fechaInicioStr,
            @RequestParam("fechaFin") String fechaFinStr) {

        try {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);
            LocalDate fechaFin = LocalDate.parse(fechaFinStr);

            List<Llamada> llamadasFiltradas = llamadaRepository.findByFechaLlamadaBetween(
                    Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant())
            );

            ModelAndView mav = new ModelAndView("llamadasFiltradas");
            mav.addObject("llamadasFiltradas", llamadasFiltradas);
            return mav;
        } catch (DateTimeParseException e) {
            // Manejar la excepción si el formato de fecha proporcionado no es válido
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("mensaje", "Formato de fecha inválido");
            return mav;
        }
    }
}