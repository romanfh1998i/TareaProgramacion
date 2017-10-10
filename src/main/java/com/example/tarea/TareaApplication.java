package com.example.tarea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TareaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareaApplication.class, args);
	}
           @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
       
       return args -> {

           
       String url = "https://bing.com";
       
       Document document = Jsoup.connect(url).get();

        String text = document.select("div").first().text();
        System.out.println(text);

        Elements links = document.select("a");
        for (Element link : links) 
        {
            System.out.println( link.attr("href") );       
       }
        };
    }
}
