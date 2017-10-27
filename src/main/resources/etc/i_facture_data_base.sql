-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.2-beta
-- PostgreSQL version: 9.5
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: db_ifacture | type: DATABASE --
-- -- DROP DATABASE IF EXISTS db_ifacture;
-- CREATE DATABASE db_ifacture
-- ;
-- -- ddl-end --
-- 

-- object: ifacture | type: SCHEMA --
-- DROP SCHEMA IF EXISTS ifacture CASCADE;
CREATE SCHEMA ifacture;
-- ddl-end --
ALTER SCHEMA ifacture OWNER TO postgres;
-- ddl-end --

-- object: ifacture_cp | type: SCHEMA --
-- DROP SCHEMA IF EXISTS ifacture_cp CASCADE;
CREATE SCHEMA ifacture_cp;
-- ddl-end --
ALTER SCHEMA ifacture_cp OWNER TO postgres;
-- ddl-end --

-- object: ifacture_cp1 | type: SCHEMA --
-- DROP SCHEMA IF EXISTS ifacture_cp1 CASCADE;
CREATE SCHEMA ifacture_cp1;
-- ddl-end --
ALTER SCHEMA ifacture_cp1 OWNER TO postgres;
-- ddl-end --

SET search_path TO pg_catalog,public,ifacture,ifacture_cp,ifacture_cp1;
-- ddl-end --

-- object: ifacture.t_client | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_client CASCADE;
CREATE TABLE ifacture.t_client(
	id serial NOT NULL,
	reference integer NOT NULL,
	nom_entreprise character varying(60),
	siret character varying(20),
	num_tva character varying(20),
	titre character varying(60),
	prenom character varying(30),
	nom_f character varying(30),
	email character varying(30),
	tele_fixe character varying(20),
	tele_port character varying(20),
	adresse character varying(60),
	code_postale integer NOT NULL,
	complemement_adresse character varying(40),
	ville character varying(20),
	pays character varying(20),
	langue_facture character varying(20),
	delai_paiement int2,
	tva float,
	is_particulier boolean,
	id_compte_t_compte integer,
	CONSTRAINT c_client PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_client OWNER TO postgres;
-- ddl-end --

-- object: ifacture.t_entreprise | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS ifacture.t_entreprise CASCADE;
CREATE SEQUENCE ifacture.t_entreprise
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE ifacture.t_entreprise OWNER TO postgres;
-- ddl-end --

-- object: ifacture.t_pays | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_pays CASCADE;
CREATE TABLE ifacture.t_pays(
	id character varying(10) NOT NULL,
	label character varying(50),
	CONSTRAINT c_pays PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_pays OWNER TO postgres;
-- ddl-end --

-- object: ifacture.t_devise | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_devise CASCADE;
CREATE TABLE ifacture.t_devise(
	id character varying(10) NOT NULL,
	label character varying(50),
	CONSTRAINT c_devise PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_devise OWNER TO postgres;
-- ddl-end --

-- object: ifacture.t_produit | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_produit CASCADE;
CREATE TABLE ifacture.t_produit(
	id serial NOT NULL,
	nom character varying(60) NOT NULL,
	description character varying(300),
	unite character varying(10) NOT NULL,
	tarif character varying(5),
	prix float,
	tva float,
	CONSTRAINT c_produit PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_produit OWNER TO postgres;
-- ddl-end --

-- object: ifacture.t_unite | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_unite CASCADE;
CREATE TABLE ifacture.t_unite(
	id character varying(20) NOT NULL,
	label character varying(15) NOT NULL,
	CONSTRAINT c_unite PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_unite OWNER TO postgres;
-- ddl-end --

-- object: ifacture.t_compte | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_compte CASCADE;
CREATE TABLE ifacture.t_compte(
	id serial NOT NULL,
	nom_entreprise character varying(40),
	email_contact character varying(35),
	siret character varying(25),
	num_tva character varying(25),
	statut_juridique character varying(20),
	rcs character varying(15),
	tva_type character varying(15),
	tva_default float,
	pays character varying(20),
	adresse character varying(60),
	complemement_adresse character varying(40),
	code_postale integer NOT NULL,
	ville character varying(20),
	site character varying(30),
	prenom_interlocteur character varying(30),
	nom_interlocteur character varying(30),
	email character varying(30),
	tele_port character varying(20),
	tele_fixe character varying(20),
	logo character varying(40),
	id_paiement_t_paiement integer,
	CONSTRAINT c_compte PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_compte OWNER TO postgres;
-- ddl-end --

-- object: ifacture.t_utilisateur | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_utilisateur CASCADE;
CREATE TABLE ifacture.t_utilisateur(
	id serial NOT NULL,
	identifiant character varying(40) NOT NULL,
	password character varying(40) NOT NULL,
	id_compte_t_compte integer,
	CONSTRAINT c_utilisateur PRIMARY KEY (id),
	CONSTRAINT c_ideniutilisateur UNIQUE (identifiant)

);
-- ddl-end --
ALTER TABLE ifacture.t_utilisateur OWNER TO postgres;
-- ddl-end --

-- object: ifacture.t_paiement | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_paiement CASCADE;
CREATE TABLE ifacture.t_paiement(
	id_paiement serial NOT NULL,
	label character varying(60),
	paypal character varying(60),
	banque character varying(80),
	code_wift character varying(60),
	iban character varying(30),
	CONSTRAINT c_paiement PRIMARY KEY (id_paiement)

);
-- ddl-end --
ALTER TABLE ifacture.t_paiement OWNER TO postgres;
-- ddl-end --

-- object: t_paiement_fk | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_compte DROP CONSTRAINT IF EXISTS t_paiement_fk CASCADE;
ALTER TABLE ifacture.t_compte ADD CONSTRAINT t_paiement_fk FOREIGN KEY (id_paiement_t_paiement)
REFERENCES ifacture.t_paiement (id_paiement) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: t_compte_uq | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_compte DROP CONSTRAINT IF EXISTS t_compte_uq CASCADE;
ALTER TABLE ifacture.t_compte ADD CONSTRAINT t_compte_uq UNIQUE (id_paiement_t_paiement);
-- ddl-end --

-- object: ifacture.t_commercial | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_commercial CASCADE;
CREATE TABLE ifacture.t_commercial(
	id serial NOT NULL,
	nom_entreprise character varying(40),
	adresse character varying(60),
	complemement_adresse character varying(40),
	code_postale integer NOT NULL,
	ville character varying(20),
	site character varying(30),
	prenom_commercial character varying(30),
	nom_commercial character varying(30),
	email character varying(30),
	tele_port character varying(20),
	tele_fixe character varying(20),
	logo character varying(40),
	is_active boolean DEFAULT false,
	id_compte_t_compte integer,
	CONSTRAINT c_commercial PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_commercial OWNER TO postgres;
-- ddl-end --

-- object: t_compte_fk | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_client DROP CONSTRAINT IF EXISTS t_compte_fk CASCADE;
ALTER TABLE ifacture.t_client ADD CONSTRAINT t_compte_fk FOREIGN KEY (id_compte_t_compte)
REFERENCES ifacture.t_compte (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: t_compte_fk | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_utilisateur DROP CONSTRAINT IF EXISTS t_compte_fk CASCADE;
ALTER TABLE ifacture.t_utilisateur ADD CONSTRAINT t_compte_fk FOREIGN KEY (id_compte_t_compte)
REFERENCES ifacture.t_compte (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: t_utilisateur_uq | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_utilisateur DROP CONSTRAINT IF EXISTS t_utilisateur_uq CASCADE;
ALTER TABLE ifacture.t_utilisateur ADD CONSTRAINT t_utilisateur_uq UNIQUE (id_compte_t_compte);
-- ddl-end --

-- object: t_compte_fk | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_commercial DROP CONSTRAINT IF EXISTS t_compte_fk CASCADE;
ALTER TABLE ifacture.t_commercial ADD CONSTRAINT t_compte_fk FOREIGN KEY (id_compte_t_compte)
REFERENCES ifacture.t_compte (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: ifacture.t_facture | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_facture CASCADE;
CREATE TABLE ifacture.t_facture(
	id serial NOT NULL,
	date_facturation date NOT NULL,
	delai_paiement integer,
	type_facture character varying(100),
	devis character varying(100),
	langue character varying(20) DEFAULT francais,
	"avecRemise" boolean DEFAULT false,
	remise integer DEFAULT 0,
	en_tete character varying(60) DEFAULT FACTURE,
	note character varying(300),
	status character varying(20),
	"isDevis" boolean DEFAULT false,
	id_commercial_t_commercial integer,
	id_t_client integer,
	id_compte_t_compte integer,
	CONSTRAINT c_facture PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_facture OWNER TO postgres;
-- ddl-end --

-- object: t_compte_fk | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_facture DROP CONSTRAINT IF EXISTS t_compte_fk CASCADE;
ALTER TABLE ifacture.t_facture ADD CONSTRAINT t_compte_fk FOREIGN KEY (id_compte_t_compte)
REFERENCES ifacture.t_compte (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: t_commercial_fk | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_facture DROP CONSTRAINT IF EXISTS t_commercial_fk CASCADE;
ALTER TABLE ifacture.t_facture ADD CONSTRAINT t_commercial_fk FOREIGN KEY (id_commercial_t_commercial)
REFERENCES ifacture.t_commercial (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: t_facture_uq | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_facture DROP CONSTRAINT IF EXISTS t_facture_uq CASCADE;
ALTER TABLE ifacture.t_facture ADD CONSTRAINT t_facture_uq UNIQUE (id_commercial_t_commercial);
-- ddl-end --

-- object: t_client_fk | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_facture DROP CONSTRAINT IF EXISTS t_client_fk CASCADE;
ALTER TABLE ifacture.t_facture ADD CONSTRAINT t_client_fk FOREIGN KEY (id_t_client)
REFERENCES ifacture.t_client (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: t_facture_uq1 | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_facture DROP CONSTRAINT IF EXISTS t_facture_uq1 CASCADE;
ALTER TABLE ifacture.t_facture ADD CONSTRAINT t_facture_uq1 UNIQUE (id_t_client);
-- ddl-end --

-- object: ifacture.t_produit_facture | type: TABLE --
-- DROP TABLE IF EXISTS ifacture.t_produit_facture CASCADE;
CREATE TABLE ifacture.t_produit_facture(
	id serial NOT NULL,
	description character varying(300),
	date date,
	quantite float DEFAULT 1,
	unite character varying(10) NOT NULL,
	tarif character varying(5),
	prix float,
	tva float,
	id_facture_t_facture integer,
	CONSTRAINT c_produit_facture PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE ifacture.t_produit_facture OWNER TO postgres;
-- ddl-end --

-- object: t_facture_fk | type: CONSTRAINT --
-- ALTER TABLE ifacture.t_produit_facture DROP CONSTRAINT IF EXISTS t_facture_fk CASCADE;
ALTER TABLE ifacture.t_produit_facture ADD CONSTRAINT t_facture_fk FOREIGN KEY (id_facture_t_facture)
REFERENCES ifacture.t_facture (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --
