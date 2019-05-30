package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;


/**
 * Clase para guardar datos de premios de peliculas en nuestra Base de Datos
 * <p>
 *
 * @author Ruben Dom�nguez
 * Aritz Garitano
 */
public class clsPremios_Cancion extends clsPremios implements itfPropertyV2 {
    private int Canciones_idCanciones;
    private int Canciones_G�nero_Canci�n_idG�nero_Canci�n;
    private int Canciones_Album_idAlbum;
    private int Canciones_Album_Cantante_idCantante;
    private int Canciones_Libreria_Multimedia_idLibreria_Multimedia;

    public clsPremios_Cancion (int _idPremios, String _Nombre, String _Categoria, int _A�o, int _Canciones_idCanciones, int _Canciones_G�nero_Canci�n_idG�nero_Canci�n, int _Canciones_Album_idAlbum, int _Canciones_Album_Cantante_idCantante, int _Canciones_Libreria_Multimedia_idLibreria_Multimedia){
        setIdPremios(_idPremios);
        setNombre(_Nombre);
        setCategoria(_Categoria);
        setA�o(_A�o);
        Canciones_idCanciones = _Canciones_idCanciones;
        Canciones_G�nero_Canci�n_idG�nero_Canci�n = _Canciones_G�nero_Canci�n_idG�nero_Canci�n;
        Canciones_Album_idAlbum = _Canciones_Album_idAlbum;
        Canciones_Album_Cantante_idCantante = _Canciones_Album_Cantante_idCantante;
        Canciones_Libreria_Multimedia_idLibreria_Multimedia = _Canciones_Libreria_Multimedia_idLibreria_Multimedia;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    @Override
    public Object getObjectProperty(String propiedad) {

        Object retorno = new Object();

        switch (propiedad) {
            case "idPremios":
                retorno =  getIdPremios();
                break;
            case "Nombre":
                retorno =  getNombre();
                break;
            case "Categoria":
                retorno =  getCategoria();
                break;
            case "A�o":
                retorno =  getA�o();
                break;
            case "Canciones_idCanciones":
                retorno = Canciones_idCanciones;
                break;
            case "Canciones_G�nero_Canci�n_idG�nero_Canci�n":
                retorno = Canciones_G�nero_Canci�n_idG�nero_Canci�n;
                break;
            case "Canciones_Album_idAlbum":
                retorno = Canciones_Album_idAlbum;
                break;
            case "Canciones_Album_Cantante_idCantante":
                retorno = Canciones_Album_Cantante_idCantante;
                break;
            case "Canciones_Libreria_Multimedia_idLibreria_Multimedia":
                retorno = Canciones_Libreria_Multimedia_idLibreria_Multimedia;
                break;
            case "Clase":
                retorno = 14;
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return retorno;
    }

}
