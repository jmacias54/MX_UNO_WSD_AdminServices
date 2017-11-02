-- MySQL Script generated by MySQL Workbench
-- Mon Oct 30 19:39:57 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema devapdbutv1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `devapdbutv1` ;

-- -----------------------------------------------------
-- Schema devapdbutv1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `devapdbutv1` DEFAULT CHARACTER SET utf8 ;
USE `devapdbutv1` ;

-- -----------------------------------------------------
-- Table `UNO_C_SECCION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_C_SECCION` ;

CREATE TABLE IF NOT EXISTS `UNO_C_SECCION` (
  `FC_ID_SECCION` VARCHAR(30) NOT NULL,
  `FC_DESCRIPCION` VARCHAR(100) NULL,
  `FC_FRIENDLY_URL` VARCHAR(50) NULL,
  `FI_ESTATUS` INT(11) NULL,
  PRIMARY KEY (`FC_ID_SECCION`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_C_CATEGORIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_C_CATEGORIA` ;

CREATE TABLE IF NOT EXISTS `UNO_C_CATEGORIA` (
  `FC_ID_CATEGORIA` VARCHAR(40) NOT NULL,
  `FC_ID_SECCION` VARCHAR(30) NULL,
  `FC_DESCRIPCION` VARCHAR(100) NULL,
  `FC_FRIENDLY_URL` VARCHAR(50) NULL,
  `FI_ESTATUS` INT(11) NULL,
  `FI_REGISTRIS` INT(11) NULL,
  `FC_RUTA_DFP` VARCHAR(150) NULL,
  PRIMARY KEY (`FC_ID_CATEGORIA`),
  INDEX `FC_ID_SECCION_FK_idx` (`FC_ID_SECCION` ASC),
  CONSTRAINT `FC_ID_SECCION_FK`
    FOREIGN KEY (`FC_ID_SECCION`)
    REFERENCES `UNO_C_SECCION` (`FC_ID_SECCION`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_C_TIPO_NOTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_C_TIPO_NOTA` ;

CREATE TABLE IF NOT EXISTS `UNO_C_TIPO_NOTA` (
  `FC_ID_TIPO_NOTA` VARCHAR(20) NOT NULL,
  `FC_DESCRIPCION` VARCHAR(100) NULL,
  `FI_ESTATUS` INT(11) NULL COMMENT '		',
  PRIMARY KEY (`FC_ID_TIPO_NOTA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_C_ESTATUS_NOTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_C_ESTATUS_NOTA` ;

CREATE TABLE IF NOT EXISTS `UNO_C_ESTATUS_NOTA` (
  `FC_ID_ESTATUS` VARCHAR(10) NOT NULL,
  `FC_DESCRIPCION` VARCHAR(45) NULL,
  `FI_ESTATUS` INT NULL,
  PRIMARY KEY (`FC_ID_ESTATUS`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_C_USUARIOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_C_USUARIOS` ;

CREATE TABLE IF NOT EXISTS `UNO_C_USUARIOS` (
  `FC_ID_USUARIO` VARCHAR(100) NOT NULL,
  `FC_NOMBRE` VARCHAR(300) NULL,
  `FD_FECHA_REGISTRO` TIMESTAMP NULL,
  `FI_ESTATUS` INT(11) NULL,
  PRIMARY KEY (`FC_ID_USUARIO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_C_TAGS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_C_TAGS` ;

CREATE TABLE IF NOT EXISTS `UNO_C_TAGS` (
  `FC_ID_TAG` VARCHAR(15) NOT NULL,
  `FC_DESCRIPCION` VARCHAR(45) NULL,
  `FI_ESTATUS` INT NULL,
  PRIMARY KEY (`FC_ID_TAG`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_C_MAGAZINE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_C_MAGAZINE` ;

CREATE TABLE IF NOT EXISTS `UNO_C_MAGAZINE` (
  `FC_ID_MAGAZINE` INT NOT NULL,
  `FC_DESCRIPCION` VARCHAR(45) NULL,
  `FI_REGISTRIS` INT NULL,
  `FI_ESTATUS` INT NULL,
  PRIMARY KEY (`FC_ID_MAGAZINE`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_N_NOTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_N_NOTA` ;

CREATE TABLE IF NOT EXISTS `UNO_N_NOTA` (
  `FC_ID_CONTENIDO` VARCHAR(50) NOT NULL,
  `FC_ID_CATEGORIA` VARCHAR(40) NULL,
  `FC_FRIENDLY_URL` VARCHAR(100) NULL,
  `FC_TITULO` VARCHAR(200) NULL,
  `FC_DESCRIPCION` VARCHAR(1000) NULL,
  `FC_ESCRIBIO` VARCHAR(100) NULL,
  `FC_LUGAR` VARCHAR(100) NULL,
  `FC_FUENTE` VARCHAR(100) NULL,
  `FC_ID_TIPO_NOTA` VARCHAR(20) NULL,
  `FC_IMAGEN` VARCHAR(200) NULL,
  `FC_VIDEO_YOUTUBE` VARCHAR(200) NULL,
  `FC_CONTENT_ID_OOYALA` VARCHAR(200) NULL,
  `FC_PLAYER_ID_OOYALA` VARCHAR(200) NULL,
  `FC_PCODE_OOYALA` VARCHAR(200) NULL,
  `FC_SOURCE_OOYALA` VARCHAR(45) NULL,
  `FC_ALTERNATIVE_TEXT_OOYALA` VARCHAR(45) NULL,
  `FC_DURATION_OOYALA` VARCHAR(45) NULL,
  `FC_FILE_SIZE_OOYALA` VARCHAR(45) NULL,
  `CL_GALERIA` LONGTEXT NULL,
  `CL_RTF_CONTENIDO` LONGTEXT NULL,
  `FD_FECHA_PUBLICACION` TIMESTAMP NULL,
  `FD_FECHA_MODIFICACION` TIMESTAMP NULL,
  `FC_KEYWORDS` VARCHAR(45) NULL,
  `FI_BAN_INFINITO_HOME` INT(11) NULL,
  `FI_BAN_MSN` INT(11) NULL,
  `FI_BAN_OTROS` INT(11) NULL,
  `FC_ID_USUARIO` VARCHAR(100) NULL,
  `FC_ID_ESTATUS` VARCHAR(10) NULL,
  PRIMARY KEY (`FC_ID_CONTENIDO`),
  INDEX `FC_ID_TIPO_NOTA_FK_idx` (`FC_ID_TIPO_NOTA` ASC),
  INDEX `FC_ID_USUARIO_FK_idx` (`FC_ID_USUARIO` ASC),
  INDEX `FC_ID_CATEGORIA_FK_idx` (`FC_ID_CATEGORIA` ASC),
  INDEX `FC_ID_ESTATUS_FK_idx` (`FC_ID_ESTATUS` ASC),
  CONSTRAINT `N_FC_ID_TIPO_NOTA_FK`
    FOREIGN KEY (`FC_ID_TIPO_NOTA`)
    REFERENCES `UNO_C_TIPO_NOTA` (`FC_ID_TIPO_NOTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `N_FC_ID_USUARIO_FK`
    FOREIGN KEY (`FC_ID_USUARIO`)
    REFERENCES `UNO_C_USUARIOS` (`FC_ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `N_FC_ID_CATEGORIA_FK`
    FOREIGN KEY (`FC_ID_CATEGORIA`)
    REFERENCES `UNO_C_CATEGORIA` (`FC_ID_CATEGORIA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `N_FC_ID_ESTATUS_FK`
    FOREIGN KEY (`FC_ID_ESTATUS`)
    REFERENCES `UNO_C_ESTATUS_NOTA` (`FC_ID_ESTATUS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_H_NOTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_H_NOTA` ;

CREATE TABLE IF NOT EXISTS `UNO_H_NOTA` (
  `FC_ID_CONTENIDO` VARCHAR(50) NOT NULL,
  `FC_ID_CATEGORIA` VARCHAR(40) NULL,
  `FC_FRIENDLY_URL` VARCHAR(100) NULL,
  `FC_TITULO` VARCHAR(200) NULL,
  `FC_DESCRIPCION` VARCHAR(1000) NULL,
  `FC_ESCRIBIO` VARCHAR(100) NULL,
  `FC_LUGAR` VARCHAR(100) NULL,
  `FC_FUENTE` VARCHAR(100) NULL,
  `FC_ID_TIPO_NOTA` VARCHAR(20) NULL,
  `FC_IMAGEN` VARCHAR(200) NULL,
  `FC_VIDEO_YOUTUBE` VARCHAR(200) NULL,
  `FC_CONTENT_ID_OOYALA` VARCHAR(200) NULL,
  `FC_PLAYER_ID_OOYALA` VARCHAR(200) NULL,
  `FC_PCODE_OOYALA` VARCHAR(200) NULL,
  `FC_SOURCE_OOYALA` VARCHAR(45) NULL,
  `FC_ALTERNATIVE_TEXT_OOYALA` VARCHAR(45) NULL,
  `FC_DURATION_OOYALA` VARCHAR(45) NULL,
  `FC_FILE_SIZE_OOYALA` VARCHAR(45) NULL,
  `CL_GALERIA` LONGTEXT NULL,
  `CL_RTF_CONTENIDO` LONGTEXT NULL,
  `FD_FECHA_PUBLICACION` TIMESTAMP NULL,
  `FD_FECHA_MODIFICACION` TIMESTAMP NULL,
  `FC_KEYWORDS` VARCHAR(45) NULL,
  `FI_BAN_INFINITO_HOME` INT(11) NULL,
  `FI_BAN_MSN` INT(11) NULL,
  `FI_BAN_OTROS` INT(11) NULL,
  `FC_ID_USUARIO` VARCHAR(100) NULL,
  `FC_ID_ESTATUS` VARCHAR(10) NULL,
  PRIMARY KEY (`FC_ID_CONTENIDO`),
  INDEX `FC_ID_USUARIO_FK_idx` (`FC_ID_USUARIO` ASC),
  INDEX `FC_ID_CATEGORIA_FK_idx` (`FC_ID_CATEGORIA` ASC),
  INDEX `FC_ID_ESTATUS_FK_idx` (`FC_ID_ESTATUS` ASC),
  INDEX `FC_ID_TIPO_NOTA_FK_idx` (`FC_ID_TIPO_NOTA` ASC),
  CONSTRAINT `H_FC_ID_USUARIO_FK`
    FOREIGN KEY (`FC_ID_USUARIO`)
    REFERENCES `UNO_C_USUARIOS` (`FC_ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `H_FC_ID_CATEGORIA_FK`
    FOREIGN KEY (`FC_ID_CATEGORIA`)
    REFERENCES `UNO_C_CATEGORIA` (`FC_ID_CATEGORIA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `H_FC_ID_ESTATUS_FK`
    FOREIGN KEY (`FC_ID_ESTATUS`)
    REFERENCES `UNO_C_ESTATUS_NOTA` (`FC_ID_ESTATUS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `H_FC_ID_TIPO_NOTA_FK`
    FOREIGN KEY (`FC_ID_TIPO_NOTA`)
    REFERENCES `UNO_C_TIPO_NOTA` (`FC_ID_TIPO_NOTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_V_NOTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_V_NOTA` ;

CREATE TABLE IF NOT EXISTS `UNO_V_NOTA` (
  `FC_ID_CONTENIDO` VARCHAR(50) NOT NULL,
  `FC_ID_CATEGORIA` VARCHAR(30) NULL,
  `FC_FRIENDLY_URL` VARCHAR(45) NULL,
  `FC_TITULO` VARCHAR(200) NULL,
  `FC_DESCRIPCION` VARCHAR(1000) NULL,
  `FC_ESCRIBIO` VARCHAR(100) NULL,
  `FC_LUGAR` VARCHAR(100) NULL,
  `FC_FUENTE` VARCHAR(100) NULL,
  `FC_ID_TIPO_NOTA` VARCHAR(20) NULL,
  `FC_IMAGEN` VARCHAR(200) NULL,
  `FC_VIDEO_YOUTUBE` VARCHAR(200) NULL,
  `FC_CONTENT_ID_OOYALA` VARCHAR(200) NULL,
  `FC_PLAYER_ID_OOYALA` VARCHAR(200) NULL,
  `FC_PCODE_OOYALA` VARCHAR(200) NULL,
  `FC_SOURCE_OOYALA` VARCHAR(45) NULL,
  `FC_ALTERNATIVE_TEXT_OOYALA` VARCHAR(45) NULL,
  `FC_DURATION_OOYALA` VARCHAR(45) NULL,
  `FC_FILE_SIZE_OOYALA` VARCHAR(45) NULL,
  `CL_GALERIA` LONGTEXT NULL,
  `CL_RTF_CONTENIDO` LONGTEXT NULL,
  `FD_FECHA_PUBLICACION` TIMESTAMP NULL,
  `FD_FECHA_MODIFICACION` TIMESTAMP NULL,
  `FC_KEYWORDS` VARCHAR(45) NULL,
  `FI_BAN_INFINITO_HOME` INT(11) NULL,
  `FI_BAN_MSN` INT(11) NULL,
  `FI_BAN_OTROS` INT(11) NULL,
  `FC_ID_USUARIO` VARCHAR(100) NULL,
  `FC_ID_ESTATUS` VARCHAR(10) NULL,
  PRIMARY KEY (`FC_ID_CONTENIDO`),
  INDEX `FC_ID_TIPO_NOTA_FK_idx` (`FC_ID_TIPO_NOTA` ASC),
  INDEX `FC_ID_USUARIO_FK_idx` (`FC_ID_USUARIO` ASC),
  INDEX `FC_ID_CATEGORIA_FK_idx` (`FC_ID_CATEGORIA` ASC),
  INDEX `FC_ID_ESTATUS_FK_idx` (`FC_ID_ESTATUS` ASC),
  CONSTRAINT `V_FC_ID_TIPO_NOTA_FK`
    FOREIGN KEY (`FC_ID_TIPO_NOTA`)
    REFERENCES `UNO_C_TIPO_NOTA` (`FC_ID_TIPO_NOTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `V_FC_ID_USUARIO_FK`
    FOREIGN KEY (`FC_ID_USUARIO`)
    REFERENCES `UNO_C_USUARIOS` (`FC_ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `V_FC_ID_CATEGORIA_FK`
    FOREIGN KEY (`FC_ID_CATEGORIA`)
    REFERENCES `UNO_C_CATEGORIA` (`FC_ID_CATEGORIA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `V_FC_ID_ESTATUS_FK`
    FOREIGN KEY (`FC_ID_ESTATUS`)
    REFERENCES `UNO_C_ESTATUS_NOTA` (`FC_ID_ESTATUS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_I_NOTA_TAGS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_I_NOTA_TAGS` ;

CREATE TABLE IF NOT EXISTS `UNO_I_NOTA_TAGS` (
  `FC_ID_CONTENIDO` VARCHAR(50) NOT NULL,
  `FC_ID_TAG` VARCHAR(15) NOT NULL,
  INDEX `FC_ID_TAG_FK_idx` (`FC_ID_TAG` ASC),
  PRIMARY KEY (`FC_ID_CONTENIDO`, `FC_ID_TAG`),
  CONSTRAINT `I_MAGAZINE_FC_ID_TAG_FK`
    FOREIGN KEY (`FC_ID_TAG`)
    REFERENCES `UNO_C_TAGS` (`FC_ID_TAG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `I_MAGAZINE_FC_ID_CONTENIDO_FK`
    FOREIGN KEY (`FC_ID_CONTENIDO`)
    REFERENCES `UNO_N_NOTA` (`FC_ID_CONTENIDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_I_H_NOTA_TAGS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_I_H_NOTA_TAGS` ;

CREATE TABLE IF NOT EXISTS `UNO_I_H_NOTA_TAGS` (
  `FC_ID_CONTENIDO` VARCHAR(50) NOT NULL,
  `FC_ID_TAG` VARCHAR(45) NOT NULL,
  INDEX `FC_ID_TAG_FK_idx` (`FC_ID_TAG` ASC),
  PRIMARY KEY (`FC_ID_CONTENIDO`, `FC_ID_TAG`),
  CONSTRAINT `I_H_FC_ID_TAG_FK`
    FOREIGN KEY (`FC_ID_TAG`)
    REFERENCES `UNO_C_TAGS` (`FC_ID_TAG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `I_H_FC_ID_CONTENIDO_FK`
    FOREIGN KEY (`FC_ID_CONTENIDO`)
    REFERENCES `UNO_H_NOTA` (`FC_ID_CONTENIDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNO_I_MAGAZINE_NOTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UNO_I_MAGAZINE_NOTA` ;

CREATE TABLE IF NOT EXISTS `UNO_I_MAGAZINE_NOTA` (
  `FC_ID_MAGAZINE` INT NOT NULL,
  `FC_ID_CONTENIDO` VARCHAR(50) NOT NULL,
  INDEX `FC_ID_CONTENIDO_FK_idx` (`FC_ID_CONTENIDO` ASC),
  PRIMARY KEY (`FC_ID_MAGAZINE`, `FC_ID_CONTENIDO`),
  CONSTRAINT `I_FC_ID_MAGAZINE_FK`
    FOREIGN KEY (`FC_ID_MAGAZINE`)
    REFERENCES `UNO_C_MAGAZINE` (`FC_ID_MAGAZINE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `I_FC_ID_CONTENIDO_FK`
    FOREIGN KEY (`FC_ID_CONTENIDO`)
    REFERENCES `UNO_N_NOTA` (`FC_ID_CONTENIDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
