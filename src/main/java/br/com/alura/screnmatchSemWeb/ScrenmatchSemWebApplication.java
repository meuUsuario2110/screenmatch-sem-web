package br.com.alura.screnmatchSemWeb;

import br.com.alura.screnmatchSemWeb.model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoApi;
import service.ConverteDados;

@SpringBootApplication
public class ScrenmatchSemWebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenmatchSemWebApplication.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		// aqui estou instanciando ou seja chamando a class CONSUMOAPI..
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("""
                https://omdbapi.com/?t=gilmore+girls&Season=1&apikey=6585022c""");
		//System.out.println(json);
		//json = consumoApi.obterDados("""
                https://coffe.alexflipnote.dev/randm.json""");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}

