package com.company.LN;

import com.company.Excepciones.clsPropiedadNonExistantException;
import com.company.Comun.itfPropertyV2;

/**
 * Clase para guardar datos de Peliculas en nuestra Base de Datos
 *<p>
 * @author Ruben Domínguez
 * Aritz Garitano
 */

public class clsPelicula extends clsArticulo implements itfPropertyV2 {

    /*atributos de la clase pelicula*/
    private int Libreria_Multimedia_idLibreria_Multimedia;
    //private String Titulo;
    //  private String Titulo_original;
    //  private int Anno_de_publicacion;
    private int Duracion;
    private int Calificacion;
    private int Calporedad;
    //  private String Tipo_DoA;
   // private double Precio;
    //   private boolean En_propiedad;
    //  private boolean En_busqueda;
    //  private String Formato;
    private String Saga;
    private double Orden;
    private String Sinopsis;
    private String Enlace_a_trailer;

    private String annodepublicacion = String.valueOf(getAnno_de_publicacion());


    //Constructor
    public clsPelicula(int _libreria_Multimedia_idLibreria_Multimedia, String _titulo, String _titulo_original, int _anno_de_publicacion, int _duracion, int _calificacion, int _calporedad, String _tipo_DoA, double _precio, boolean _en_propiedad, boolean _en_busqueda, String _formato, String _saga, Double _orden, String _sinopsis, String _enlace_a_trailer) {
        //Variables "Heredadas":

        //Variables de la clase:
        Libreria_Multimedia_idLibreria_Multimedia = _libreria_Multimedia_idLibreria_Multimedia;
        //Titulo = _titulo;
        setTitulo(_titulo);
        //  Titulo_original = _titulo_original;
        setTitulo_original(_titulo_original);
        //  Anno_de_publicacion = _anno_de_publicacion;
        setAnno_de_publicacion(_anno_de_publicacion);
        Duracion = _duracion;
        Calificacion = _calificacion;
        Calporedad = _calporedad;
        //  Tipo_DoA = _tipo_DoA;
        setTipo_DoA(_tipo_DoA);
        //   Precio = _precio;
        setPrecio(_precio);
        //  En_propiedad = _en_propiedad;
        setEn_propiedad(_en_propiedad);
        //  En_busqueda = _en_busqueda;
        setEn_busqueda(_en_busqueda);
        // Formato = _formato;
        setFormato(_formato);
        Saga = _saga;
        Orden = _orden;
        Sinopsis = _sinopsis;
        Enlace_a_trailer = _enlace_a_trailer;
    }


    @Override
    public Object getObjectProperty(String propiedad) throws clsPropiedadNonExistantException {
        Object propResultado = "";
        switch (propiedad) {
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
            case "Enlace_a_trailer":
                propResultado = Enlace_a_trailer;
                break;
            case "Sinopsis":
                propResultado = Sinopsis;
                break;
            case "Saga":
                propResultado = Saga;
                break;
            case "Duracion":
                propResultado = Duracion;
                break;
            case "Calporedad":
                propResultado = Calporedad;
                break;
            case "Calificacion":
                propResultado = Calificacion;
                break;
            case "Libreria_Multimedia_idLibreria_Multimedia":
                propResultado = Libreria_Multimedia_idLibreria_Multimedia;
                break;
            case "Anno_de_publicacion":
                propResultado = getAnno_de_publicacion();
                break;
            case "Clase":
                propResultado = 2;
                break;
            case "Precio":
                propResultado = getPrecio();
                break;
            case "Orden":
                propResultado = Orden;
                break;
            case "En_propiedad":
                propResultado = getEn_propiedad();
                break;
            case "En_busqueda":
                propResultado = getEn_busqueda();
                break;
            default:
                throw new clsPropiedadNonExistantException();
        }
        return propResultado;
    }




   @Override
    public String toString() {
        return getTitulo();
    }
    @Override
    public int hashCode()
    {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTitulo() == null) ? 0 : getTitulo().hashCode());
        result = prime * result
                + ((annodepublicacion == null) ? 0 : annodepublicacion.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass())
            return false;

        clsPelicula other = (clsPelicula) obj;
        if (getTitulo() == null)
        {
            if (other.getTitulo() != null)
                return false;
        }
        else if (!getTitulo().equals(other.getTitulo()))
            return false;

        if (annodepublicacion == null)
        {
            if (other.annodepublicacion != null)
                return false;
        }
        else if (!annodepublicacion.equals(other.annodepublicacion))
            return false;

        return true;
    }}
