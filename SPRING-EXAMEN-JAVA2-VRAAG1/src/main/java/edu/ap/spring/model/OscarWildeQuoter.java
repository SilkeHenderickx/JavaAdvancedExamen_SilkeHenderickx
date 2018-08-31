package edu.ap.spring.model;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class OscarWildeQuoter {

    private QuoteRepository repository;

    public void setRepository(QuoteRepository repository) {
        this.repository = repository;
    }

    private List<String> readWords(Scanner source) {
        String word = null;
        List<String> words = new ArrayList<>();
        while (source.hasNextLine()) {
            word = source.nextLine();
            words.add(word);
            System.out.println(word);
        }
        return words;
    }

    public void addQuotes() throws FileNotFoundException {

        Scanner s = new Scanner(new File("oscar_wilde.txt"));
        List<String> quotes = readWords(s);

        for (String q : quotes) {
            repository.save(new Quote(q));
        }

    }

    public List<Quote> getQuotes(){
        List<Quote> quotes = new ArrayList<>();
        repository.findAll().forEach(quotes::add);
        return quotes;
    }

    public List<Quote> getQuotesBySearchTerm(String searchTerm){
        List<Quote> quotes = new ArrayList<>();
        repository.findAllByQuoteContaining(searchTerm).forEach(quotes::add);
        return quotes;
    }


}
