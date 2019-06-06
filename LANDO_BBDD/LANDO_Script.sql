-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema LANDO
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema LANDO
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LANDO` DEFAULT CHARACTER SET utf8 ;
USE `LANDO` ;

-- -----------------------------------------------------
-- Table `LANDO`.`Libreria_Multimedia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Libreria_Multimedia` (
  `idLibreria_Multimedia` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Descripcion` VARCHAR(150) NULL,
  PRIMARY KEY (`idLibreria_Multimedia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Películas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Películas` (
  `Título` VARCHAR(128) NOT NULL,
  `Título_Original` VARCHAR(128) NOT NULL,
  `Año` INT NOT NULL,
  `Duración` INT NOT NULL,
  `Puntuación` INT NOT NULL,
  `Calporedad` INT NOT NULL,
  `Tipo_DoA` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NULL,
  `En_propiedad` TINYINT NOT NULL,
  `En_busqueda` TINYINT NOT NULL,
  `Formato` VARCHAR(60) NOT NULL,
  `Saga` VARCHAR(100) NULL,
  `Orden_en_Saga` DOUBLE NULL,
  `Sinopsis` VARCHAR(666) NULL,
  `Enlace_al_Trailer` VARCHAR(255) NULL,
  `Libreria_Multimedia_idLibreria_Multimedia` INT NOT NULL,
  PRIMARY KEY (`Título`, `Libreria_Multimedia_idLibreria_Multimedia`),
  INDEX `fk_Películas_Libreria_Multimedia1_idx` (`Libreria_Multimedia_idLibreria_Multimedia` ASC) VISIBLE,
  CONSTRAINT `fk_Películas_Libreria_Multimedia1`
    FOREIGN KEY (`Libreria_Multimedia_idLibreria_Multimedia`)
    REFERENCES `LANDO`.`Libreria_Multimedia` (`idLibreria_Multimedia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Premios_Película`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Premios_Película` (
  `idPremios` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Categoria` VARCHAR(45) NOT NULL,
  `Año` INT NOT NULL,
  `Películas_Título` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`idPremios`, `Películas_Título`),
  INDEX `fk_Premios_Película_Películas1_idx` (`Películas_Título` ASC) VISIBLE,
  CONSTRAINT `fk_Premios_Película_Películas1`
    FOREIGN KEY (`Películas_Título`)
    REFERENCES `LANDO`.`Películas` (`Título`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Actores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Actores` (
  `idActores` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idActores`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Género_Película`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Género_Película` (
  `idGénero` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGénero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Director` (
  `idDirector` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDirector`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Género_Canción`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Género_Canción` (
  `idGénero_Canción` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGénero_Canción`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Cantante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Cantante` (
  `idCantante` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCantante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Album` (
  `idAlbum` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Cantante_idCantante` INT NOT NULL,
  PRIMARY KEY (`idAlbum`, `Cantante_idCantante`),
  INDEX `fk_Album_Cantante1_idx` (`Cantante_idCantante` ASC) VISIBLE,
  CONSTRAINT `fk_Album_Cantante1`
    FOREIGN KEY (`Cantante_idCantante`)
    REFERENCES `LANDO`.`Cantante` (`idCantante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Canciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Canciones` (
  `idCanciones` INT NOT NULL AUTO_INCREMENT,
  `Título` VARCHAR(128) NOT NULL,
  `Título_Original` VARCHAR(128) NOT NULL,
  `Año` INT NOT NULL,
  `Tipo_DoA` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NULL,
  `En_propiedad` TINYINT NOT NULL,
  `En_busqueda` TINYINT NOT NULL,
  `Formato` VARCHAR(60) NOT NULL,
  `Enlace_a_YT` VARCHAR(145) NULL,
  `Género_Canción_idGénero_Canción` INT NOT NULL,
  `Album_idAlbum` INT NOT NULL,
  `Album_Cantante_idCantante` INT NOT NULL,
  `Libreria_Multimedia_idLibreria_Multimedia` INT NOT NULL,
  PRIMARY KEY (`idCanciones`, `Género_Canción_idGénero_Canción`, `Album_idAlbum`, `Album_Cantante_idCantante`, `Libreria_Multimedia_idLibreria_Multimedia`),
  INDEX `fk_Canciones_Género_Canción1_idx` (`Género_Canción_idGénero_Canción` ASC) VISIBLE,
  INDEX `fk_Canciones_Album1_idx` (`Album_idAlbum` ASC, `Album_Cantante_idCantante` ASC) VISIBLE,
  INDEX `fk_Canciones_Libreria_Multimedia1_idx` (`Libreria_Multimedia_idLibreria_Multimedia` ASC) VISIBLE,
  CONSTRAINT `fk_Canciones_Género_Canción1`
    FOREIGN KEY (`Género_Canción_idGénero_Canción`)
    REFERENCES `LANDO`.`Género_Canción` (`idGénero_Canción`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Canciones_Album1`
    FOREIGN KEY (`Album_idAlbum` , `Album_Cantante_idCantante`)
    REFERENCES `LANDO`.`Album` (`idAlbum` , `Cantante_idCantante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Canciones_Libreria_Multimedia1`
    FOREIGN KEY (`Libreria_Multimedia_idLibreria_Multimedia`)
    REFERENCES `LANDO`.`Libreria_Multimedia` (`idLibreria_Multimedia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Premios_Canción`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Premios_Canción` (
  `idPremios` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Categoria` VARCHAR(45) NOT NULL,
  `Año` INT NOT NULL,
  `Canciones_idCanciones` INT NOT NULL,
  `Canciones_Género_Canción_idGénero_Canción` INT NOT NULL,
  `Canciones_Album_idAlbum` INT NOT NULL,
  `Canciones_Album_Cantante_idCantante` INT NOT NULL,
  `Canciones_Libreria_Multimedia_idLibreria_Multimedia` INT NOT NULL,
  PRIMARY KEY (`idPremios`, `Canciones_idCanciones`, `Canciones_Género_Canción_idGénero_Canción`, `Canciones_Album_idAlbum`, `Canciones_Album_Cantante_idCantante`, `Canciones_Libreria_Multimedia_idLibreria_Multimedia`),
  INDEX `fk_Premios_Canción_Canciones1_idx` (`Canciones_idCanciones` ASC, `Canciones_Género_Canción_idGénero_Canción` ASC, `Canciones_Album_idAlbum` ASC, `Canciones_Album_Cantante_idCantante` ASC, `Canciones_Libreria_Multimedia_idLibreria_Multimedia` ASC) VISIBLE,
  CONSTRAINT `fk_Premios_Canción_Canciones1`
    FOREIGN KEY (`Canciones_idCanciones` , `Canciones_Género_Canción_idGénero_Canción` , `Canciones_Album_idAlbum` , `Canciones_Album_Cantante_idCantante` , `Canciones_Libreria_Multimedia_idLibreria_Multimedia`)
    REFERENCES `LANDO`.`Canciones` (`idCanciones` , `Género_Canción_idGénero_Canción` , `Album_idAlbum` , `Album_Cantante_idCantante` , `Libreria_Multimedia_idLibreria_Multimedia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Género_Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Género_Libro` (
  `idGénero_Libro` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGénero_Libro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Autor` (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Editorial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Editorial` (
  `idEditorial` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEditorial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Libros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Libros` (
  `ISBN` VARCHAR(45) NOT NULL,
  `Título` VARCHAR(128) NOT NULL,
  `Título_Original` VARCHAR(128) NOT NULL,
  `Año` INT NOT NULL,
  `Tipo_DoA` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NULL,
  `En_propiedad` TINYINT NOT NULL,
  `En_busqueda` TINYINT NOT NULL,
  `Formato` VARCHAR(60) NOT NULL,
  `Paginas` INT NULL,
  `Resumen` VARCHAR(280) NULL,
  `Serie_SoN` TINYINT NULL,
  `Nombre_serie` VARCHAR(45) NULL,
  `Orden_serie` DOUBLE NULL,
  `Género_Libro_idGénero_Libro` INT NOT NULL,
  `Autor_idAutor` INT NOT NULL,
  `Libreria_Multimedia_idLibreria_Multimedia` INT NOT NULL,
  `Editorial_idEditorial` INT NOT NULL,
  PRIMARY KEY (`ISBN`, `Género_Libro_idGénero_Libro`, `Autor_idAutor`, `Libreria_Multimedia_idLibreria_Multimedia`, `Editorial_idEditorial`),
  INDEX `fk_Libros_Género_Libro1_idx` (`Género_Libro_idGénero_Libro` ASC) VISIBLE,
  INDEX `fk_Libros_Autor1_idx` (`Autor_idAutor` ASC) VISIBLE,
  INDEX `fk_Libros_Libreria_Multimedia1_idx` (`Libreria_Multimedia_idLibreria_Multimedia` ASC) VISIBLE,
  INDEX `fk_Libros_Editorial1_idx` (`Editorial_idEditorial` ASC) VISIBLE,
  CONSTRAINT `fk_Libros_Género_Libro1`
    FOREIGN KEY (`Género_Libro_idGénero_Libro`)
    REFERENCES `LANDO`.`Género_Libro` (`idGénero_Libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libros_Autor1`
    FOREIGN KEY (`Autor_idAutor`)
    REFERENCES `LANDO`.`Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libros_Libreria_Multimedia1`
    FOREIGN KEY (`Libreria_Multimedia_idLibreria_Multimedia`)
    REFERENCES `LANDO`.`Libreria_Multimedia` (`idLibreria_Multimedia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libros_Editorial1`
    FOREIGN KEY (`Editorial_idEditorial`)
    REFERENCES `LANDO`.`Editorial` (`idEditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Premios_Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Premios_Libro` (
  `idPremios` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Categoria` VARCHAR(45) NOT NULL,
  `Año` INT NOT NULL,
  `Libros_ISBN` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPremios`, `Libros_ISBN`),
  INDEX `fk_Premios_Libro_Libros1_idx` (`Libros_ISBN` ASC) VISIBLE,
  CONSTRAINT `fk_Premios_Libro_Libros1`
    FOREIGN KEY (`Libros_ISBN`)
    REFERENCES `LANDO`.`Libros` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Películas_has_Actores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Películas_has_Actores` (
  `Películas_Título` VARCHAR(128) NOT NULL,
  `Actores_idActores` INT NOT NULL,
  PRIMARY KEY (`Películas_Título`, `Actores_idActores`),
  INDEX `fk_Películas_has_Actores_Actores1_idx` (`Actores_idActores` ASC) VISIBLE,
  INDEX `fk_Películas_has_Actores_Películas_idx` (`Películas_Título` ASC) VISIBLE,
  CONSTRAINT `fk_Películas_has_Actores_Películas`
    FOREIGN KEY (`Películas_Título`)
    REFERENCES `LANDO`.`Películas` (`Título`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Películas_has_Actores_Actores1`
    FOREIGN KEY (`Actores_idActores`)
    REFERENCES `LANDO`.`Actores` (`idActores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Películas_has_Género_Película`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Películas_has_Género_Película` (
  `Películas_Título` VARCHAR(128) NOT NULL,
  `Género_Película_idGénero` INT NOT NULL,
  PRIMARY KEY (`Películas_Título`, `Género_Película_idGénero`),
  INDEX `fk_Películas_has_Género_Película_Género_Película1_idx` (`Género_Película_idGénero` ASC) VISIBLE,
  INDEX `fk_Películas_has_Género_Película_Películas1_idx` (`Películas_Título` ASC) VISIBLE,
  CONSTRAINT `fk_Películas_has_Género_Película_Películas1`
    FOREIGN KEY (`Películas_Título`)
    REFERENCES `LANDO`.`Películas` (`Título`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Películas_has_Género_Película_Género_Película1`
    FOREIGN KEY (`Género_Película_idGénero`)
    REFERENCES `LANDO`.`Género_Película` (`idGénero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Películas_has_Director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Películas_has_Director` (
  `Películas_Título` VARCHAR(128) NOT NULL,
  `Director_idDirector` INT NOT NULL,
  PRIMARY KEY (`Películas_Título`, `Director_idDirector`),
  INDEX `fk_Películas_has_Director_Director1_idx` (`Director_idDirector` ASC) VISIBLE,
  INDEX `fk_Películas_has_Director_Películas1_idx` (`Películas_Título` ASC) VISIBLE,
  CONSTRAINT `fk_Películas_has_Director_Películas1`
    FOREIGN KEY (`Películas_Título`)
    REFERENCES `LANDO`.`Películas` (`Título`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Películas_has_Director_Director1`
    FOREIGN KEY (`Director_idDirector`)
    REFERENCES `LANDO`.`Director` (`idDirector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LANDO`.`Canciones_has_Cantante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LANDO`.`Canciones_has_Cantante` (
  `Canciones_idCanciones` INT NOT NULL,
  `Cantante_idCantante` INT NOT NULL,
  PRIMARY KEY (`Canciones_idCanciones`, `Cantante_idCantante`),
  INDEX `fk_Canciones_has_Cantante_Cantante1_idx` (`Cantante_idCantante` ASC) VISIBLE,
  INDEX `fk_Canciones_has_Cantante_Canciones1_idx` (`Canciones_idCanciones` ASC) VISIBLE,
  CONSTRAINT `fk_Canciones_has_Cantante_Canciones1`
    FOREIGN KEY (`Canciones_idCanciones`)
    REFERENCES `LANDO`.`Canciones` (`idCanciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Canciones_has_Cantante_Cantante1`
    FOREIGN KEY (`Cantante_idCantante`)
    REFERENCES `LANDO`.`Cantante` (`idCantante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
