package dsi.dsi.entidades;

import dsi.dsi.servicios.LlamadaService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Test {

    public static void test(){
        LlamadaService llamadaService = new LlamadaService();
        List<Llamada> llamadas = llamadaService.findAll();
        System.out.println(llamadas);
    }


}
