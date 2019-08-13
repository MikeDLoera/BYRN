
package Controlador;

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
    private ListadoPropiedades view;
    private ArrayList<String> stringUrls = new ArrayList<>();
    private ListaLigadaDobleCircular<ImageIcon> carousel;
    
    public static String HARDCODED_URLS;

    public CarouselController(String urls, ListadoPropiedades lp) {
        HARDCODED_URLS = urls;
        this.view=lp;
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
        setImage(carousel.getSiguiente());
    }
    
    private void prev() {
        setImage(carousel.getAnterior());
    }
    
    private void downloadImages() {
        convertTextToURLs();
        imageUrlsToLinkedList();
        next();
    }
    
    private void imageUrlsToLinkedList() {
        int length = stringUrls.size();
        carousel = Utils.urlsArrayToLinkedList(stringUrls.toArray(new String[length]));
    }
    
    private void setImage(ImageIcon image) {
        //view.panImage.setText(null);
        view.panImage.setIcon(image);
    }
    
    private void convertTextToURLs() {
        String wholeText = HARDCODED_URLS;
        stringUrls.clear();
        stringUrls.addAll(Arrays.asList(wholeText.split(",")));
    }

    public ListaLigadaDobleCircular<ImageIcon> getCarousel() {
        return carousel;
    }

  
}
