package Controlleur;

import view.FenetrePrincipale;

import java.awt.event.ActionListener;

public final class Controller  implements ActionListener {

    private viewable frame;

    public Controller(FenetrePrincipale frame) {}
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

    }

    public void run() {
        frame.run();
    }
}
