package com.company.LN;

import com.company.Comun.itfPropertyV2;
import com.company.Excepciones.clsPropiedadNonExistantException;


/**
 * Clase para guardar datos de premios de peliculas en nuestra Base de Datos
 * <p>
 *
 * @author Ruben Domínguez
 * Aritz Garitano
 */
public class clsPremios_Cancion extends clsPremios implements itfPropertyV2 {
    private int Canciones_idCanciones;
    private int Canciones_Género_Canción_idGénero_Canción;
    private int Canciones_Album_idAlbum;
    private int Canciones_Album_Cantante_idCantante;
    private int Canciones_Libreria_Multimedia_idLibreria_Multimedia;

    public clsPremios_Cancion (int _idPremios, String _Nombre, String _Categoria, int _Año, int _Canciones_idCanciones, int _Canciones_Género_Canción_idGénero_Canción, int _Canciones_Album_idAlbum, int _Canciones_Album_Cantante_idCantante, int _Canciones_Libreria_Multimedia_idLibreria_Multimedia){
        setIdPremios(_idPremios);
        setNombre(_Nombre);
        setCategoria(_Categoria);
        setAño(_Año);
        Canciones_idCanciones = _Canciones_idCanciones;
        Canciones_Género_Canción_idGénero_Canción = _Canciones_Género_Canción_idGénero_Canción;
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
            case "Año":
                retorno =  getAño();
                break;
            case "Canciones_idCanciones":
                retorno = Canciones_idCanciones;
                break;
            case "Canciones_Género_Canción_idGénero_Canción":
                retorno = Canciones_Género_Canción_idGénero_Canción;
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
