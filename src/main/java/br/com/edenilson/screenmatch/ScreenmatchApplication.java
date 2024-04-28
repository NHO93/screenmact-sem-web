package br.com.edenilson.screenmatch;

import br.com.edenilson.screenmatch.model.DadosSerie;
import br.com.edenilson.screenmatch.services.ConsumoApi;
import br.com.edenilson.screenmatch.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados
				("http://www.omdbapi.com/?t=gilmore+girls&apikey=48a89dd4");
		//System.out.println(json);
		//json = consumoApi.obterDados ("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
