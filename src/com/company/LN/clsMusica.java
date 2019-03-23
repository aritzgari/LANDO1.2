package com.company.LN;

/**
 * Clase para guardar datos de Musica en nuestra Base de Datos
 *
 * @author RubenD AritzG
 */

public class clsMusica extends clsArticulo {

    /*atributos de la clase musica*/
    int Cantidad_musicos;
    String Musico1;
    String Musico2;
    String Musico3;
    String Musico4;
    String Musico5;
    String Album;
    String Enlace_a_youtube;
    boolean Videoclip;

    public clsMusica(int _Cantidad_musicos, String _Musico1, String _Musico2, String _Musico3, String _Musico4, String _Musico5,String _Album, String _Enlace_a_youtube, boolean _Videoclip) {
        //Constructor
        Cantidad_musicos = _Cantidad_musicos;
        Musico1 = _Musico1;
        Musico2 = _Musico2;
        Musico3 = _Musico3;
        Musico4 = _Musico4;
        Musico5 = _Musico5;
        Album = _Album;
        Enlace_a_youtube = _Enlace_a_youtube;
        Videoclip = _Videoclip;


    }
}
