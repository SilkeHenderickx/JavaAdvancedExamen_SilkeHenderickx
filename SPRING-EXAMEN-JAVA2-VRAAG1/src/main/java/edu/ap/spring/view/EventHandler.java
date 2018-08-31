package edu.ap.spring.view;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.model.OscarWildeQuoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.List;

@Component
public class EventHandler {

    private UI ui;
    private OscarWildeQuoter oscarWildeQuoter;

    @Autowired
    public void setUi(UI ui) {
        this.ui = ui;
    }

    @Autowired
    public void setOscarWildeQuoter(OscarWildeQuoter oscarWildeQuoter) {
        this.oscarWildeQuoter = oscarWildeQuoter;
    }

    public void whenAddQuotesButtonClicked(ActionEvent actionEvent){
        try {
            oscarWildeQuoter.addQuotes();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void whenGetAllClicked(ActionEvent actionEvent){

        List<Quote> list = oscarWildeQuoter.getQuotes();
        String s = "";


        for (Quote q: list
             ) {
            s += q.getQuote();
        }
        ui.getAllQuotesText.setText(s);

    }

    public void whenGetSearchClicked(ActionEvent actionEvent){

        String search = ui.searchQuotesSearchTerm.getText();

        List<Quote> list = oscarWildeQuoter.getQuotesBySearchTerm(search);

        String s = "";
        for (Quote q: list
                ) {
            s += q.getQuote();
        }
        ui.searchQuotesResult.setText(s);
    }

}
