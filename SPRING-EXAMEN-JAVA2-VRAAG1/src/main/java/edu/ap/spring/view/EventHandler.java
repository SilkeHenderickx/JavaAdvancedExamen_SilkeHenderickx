package edu.ap.spring.view;

import edu.ap.spring.model.OscarWildeQuoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
}
