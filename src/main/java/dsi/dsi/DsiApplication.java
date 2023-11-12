package dsi.dsi;

import dsi.dsi.entidades.Llamada;
import dsi.dsi.servicios.LlamadaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsiApplication.class, args);

		LlamadaService llamadaService = new LlamadaService();
		List<Llamada> llamadas = llamadaService.findAll();
		System.out.println(llamadas);
	}

}
