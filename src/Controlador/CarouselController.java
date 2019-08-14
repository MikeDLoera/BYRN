
package Controlador;

import byrn.Utils;
import Vista.ListadoPropiedades;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author ilichh1
 */
public class CarouselController{
    private final ListadoPropiedades view;
    private final ArrayList<String> stringUrls = new ArrayList<>();
    ControladorListadoPropiedades c;
    
    public static String HARDCODED_URLS;

    public CarouselController(String urls, ListadoPropiedades lp, ControladorListadoPropiedades c){
        HARDCODED_URLS = urls;
        this.c = c;
        this.view=lp;
        onInit();
        downloadImages();
    }
    
    private void onInit() {
        view.btnAnterior.addActionListener((ActionEvent e) -> {
            prev();
        });
        view.btnSiguente.addActionListener((ActionEvent e) -> {
            next();
        });
    }
    
    private void next() {
        setImage((ImageIcon) c.getLista().getSiguiente());
    }
    
    private void prev() {
        setImage((ImageIcon) c.getLista().getAnterior());
    }
    
    private void downloadImages() {
        convertTextToURLs();
        imageUrlsToLinkedList();
        next();
    }
    
    private void imageUrlsToLinkedList() {
        int length = stringUrls.size();
        c.setLista(Utils.urlsArrayToLinkedList(stringUrls.toArray(new String[length])));
    }
    
    private void setImage(ImageIcon image) {
        view.txtImage.setText(null);
        view.txtImage.setIcon(image);
    }
    
    private void convertTextToURLs() {
        String wholeText = HARDCODED_URLS;
        stringUrls.clear();
        stringUrls.addAll(Arrays.asList(wholeText.split(",")));
    }

    

  
}
