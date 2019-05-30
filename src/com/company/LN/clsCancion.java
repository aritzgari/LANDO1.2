package com.company.LN;
import com.company.Excepciones.clsPropiedadNonExistantException;
import com.company.Comun.itfPropertyV2;
/**
 * Clase para guardar datos de Música en nuestra Base de Datos
 * <p>
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsCancion extends clsArticulo implements itfPropertyV2 {

    /*atributos de la clase musica*/
    private int Libreria_Multimedia_idLibreria_Multimedia;
    private int idGenero;
    private int idAlbum;
    private int idCantante; //esto igual si hay varios hay jaleo
    private String Enlace_a_youtube;

    private int Cantidad_musicos; //hay que replantear esto hermano




    public clsCancion(int _libreria_Multimedia_idLibreria_Multimedia, String _titulo, String _titulo_original, int _anno_de_publicacion, int _idGenero, int _idAlbum, int _idCantante, String _tipo_DoA, double _precio, boolean _en_propiedad, boolean _en_busqueda, String _formato, String _Enlace_a_YT) {
        Libreria_Multimedia_idLibreria_Multimedia=_libreria_Multimedia_idLibreria_Multimedia;
        setTitulo(_titulo);
        setTitulo_original(_titulo_original);
        setAnno_de_publicacion(_anno_de_publicacion);
        setTipo_DoA(_tipo_DoA);
        setPrecio(_precio);
        setEn_propiedad(_en_propiedad);
        setEn_busqueda(_en_busqueda);
        setFormato(_formato);
        Enlace_a_youtube=_Enlace_a_YT;
        idGenero= _idGenero;
        idAlbum= _idAlbum;
        idCantante=_idCantante;

    }

    @Override
    public String toString() {
        return getTitulo();
    }

    @Override
    public Object getObjectProperty(String propiedad) {
        Object propResultado = new Object();
        switch (propiedad) {
            case "Libreria_Multimedia_idLibreria_Multimedia":
                propResultado = Libreria_Multimedia_idLibreria_Multimedia ;
                break;
            case "Titulo":
                propResultado = getTitulo();
                break;
            case "Titulo_original":
                propResultado = getTitulo_original();
                break;
            case "Tipo_DoA":
                propResultado = getTipo_DoA();
                break;
            case "Formato":
                propResultado = getFormato();
                break;
            case "Genero":
                propResultado = getGenero();
                break;
            case "Premios":
                propResultado = getPremios();
                break;
            case "Año":
                propResultado = getAnno_de_publicacion();
                break;
            case "Clase":
                propResultado = 12;
                break;
            case "Precio":
                propResultado = getPrecio();
                break;
            case "En_propiedad":
                propResultado = getEn_propiedad();
                break;
            case "En_busqueda":
                propResultado = getEn_busqueda();
                break;
            case "Enlace_a_YT":
                propResultado = Enlace_a_youtube;
                break;
            case "Género_Canción_idGénero_Canción":
                propResultado = idGenero;
                break;
            case "Album_idAlbum":
                propResultado = idAlbum;
                break;
            case "Album_Cantante_idCantante":
                propResultado = idCantante;
                break;
            default:
                System.out.println("Propiedad no encontrada.");
                break;
        }
        return propResultado;
    }


}
