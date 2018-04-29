/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     1/10/2017 5:13:03 PM                         */
/*==============================================================*/


drop table if exists APOTEKA;

drop table if exists DOKTOR;

drop table if exists FARMACEUT;

drop table if exists FARMACEUTSKA_KOMPANIJA;

drop table if exists ISTORIJA_ZAPOSLENJA;

drop table if exists KOMERCIJALISTA;

drop table if exists LEK;

drop table if exists PACIJENT;

drop table if exists PREPISANI_LEKOVI;

drop table if exists PRODAJA_LEKOVA;

drop table if exists RADNIK;

drop table if exists RECEPT;

drop table if exists UGOVOR;

drop table if exists ZAMENE;

/*==============================================================*/
/* Table: APOTEKA                                               */
/*==============================================================*/
create table APOTEKA
(
   APOTEKA_ID           int not null,
   IME                  varchar(255),
   ADRESA               varchar(255),
   TELEFON              varchar(15),
   primary key (APOTEKA_ID)
);

/*==============================================================*/
/* Table: DOKTOR                                                */
/*==============================================================*/
create table DOKTOR
(
   DOKTOR_ID            int not null,
   IME                  varchar(255),
   PREZIME              varchar(255),
   JMBG                 varchar(13),
   SPECIJALNOST         varchar(255),
   GODINE_ISKUSTVA      int,
   primary key (DOKTOR_ID)
);

/*==============================================================*/
/* Table: FARMACEUT                                             */
/*==============================================================*/
create table FARMACEUT
(
   RADNIK_ID            int not null,
   APOTEKA_ID           int not null,
   IME                  varchar(255),
   PREZIME              varchar(255),
   JMBG                 varchar(13),
   ADRESA               varchar(255),
   TELEFON              varchar(15),
   STRUCNA_SPREMA       varchar(255),
   primary key (RADNIK_ID)
);

/*==============================================================*/
/* Table: FARMACEUTSKA_KOMPANIJA                                */
/*==============================================================*/
create table FARMACEUTSKA_KOMPANIJA
(
   KOMANIJA_ID          char(10) not null,
   IME                  varchar(255),
   TELEFON              varchar(15),
   primary key (KOMANIJA_ID)
);

/*==============================================================*/
/* Table: ISTORIJA_ZAPOSLENJA                                   */
/*==============================================================*/
create table ISTORIJA_ZAPOSLENJA
(
   APOTEKA_ID           int,
   RADNIK_ID            int,
   MESECI               int,
   DANI                 int
);

/*==============================================================*/
/* Table: KOMERCIJALISTA                                        */
/*==============================================================*/
create table KOMERCIJALISTA
(
   RADNIK_ID            int not null,
   APOTEKA_ID           int not null,
   IME                  varchar(255),
   PREZIME              varchar(255),
   JMBG                 varchar(13),
   ADRESA               varchar(255),
   TELEFON              varchar(15),
   primary key (RADNIK_ID)
);

/*==============================================================*/
/* Table: LEK                                                   */
/*==============================================================*/
create table LEK
(
   KOMANIJA_ID          char(10) not null,
   SIFRA                int not null,
   IME                  varchar(255),
   primary key (KOMANIJA_ID, SIFRA)
);

/*==============================================================*/
/* Table: PACIJENT                                              */
/*==============================================================*/
create table PACIJENT
(
   PACIJENT_ID          int not null,
   DOKTOR_ID            int not null,
   IME                  varchar(255),
   PREZIME              varchar(255),
   JMBG                 varchar(13),
   ADRESA               varchar(255),
   DATUM_RODJENJA       date,
   primary key (PACIJENT_ID)
);

/*==============================================================*/
/* Table: PREPISANI_LEKOVI                                      */
/*==============================================================*/
create table PREPISANI_LEKOVI
(
   RECEPT_ID            int not null,
   KOMANIJA_ID          char(10),
   SIFRA                int,
   KOLICINA             int,
   TRAJANJE_TERAPIJE    int
);

/*==============================================================*/
/* Table: PRODAJA_LEKOVA                                        */
/*==============================================================*/
create table PRODAJA_LEKOVA
(
   APOTEKA_ID           int,
   KOMANIJA_ID          char(10),
   SIFRA                int,
   CENA                 float
);

/*==============================================================*/
/* Table: RADNIK                                                */
/*==============================================================*/
create table RADNIK
(
   RADNIK_ID            int not null,
   IME                  varchar(255),
   PREZIME              varchar(255),
   JMBG                 varchar(13),
   ADRESA               varchar(255),
   TELEFON              varchar(15),
   primary key (RADNIK_ID)
);

/*==============================================================*/
/* Table: RECEPT                                                */
/*==============================================================*/
create table RECEPT
(
   RECEPT_ID            int not null,
   PACIJENT_ID          int not null,
   DOKTOR_ID            int not null,
   DATUM                date,
   primary key (RECEPT_ID)
);

/*==============================================================*/
/* Table: UGOVOR                                                */
/*==============================================================*/
create table UGOVOR
(
   UGOVOR_ID            int not null,
   KOMANIJA_ID          char(10) not null,
   RADNIK_ID            int not null,
   DATUM_SKLAPANJA      date,
   DATUM_ISTEKA         date,
   primary key (UGOVOR_ID)
);

/*==============================================================*/
/* Table: ZAMENE                                                */
/*==============================================================*/
create table ZAMENE
(
   LEK_KOMANIJA_ID      char(10),
   SIFRA                int,
   KOMANIJA_ID          char(10),
   LEK_SIFRA            int
);

alter table FARMACEUT add constraint FK_INHERITANCE_1 foreign key (RADNIK_ID)
      references RADNIK (RADNIK_ID) on delete restrict on update restrict;

alter table FARMACEUT add constraint FK_RELATIONSHIP_11 foreign key (APOTEKA_ID)
      references APOTEKA (APOTEKA_ID) on delete restrict on update restrict;

alter table ISTORIJA_ZAPOSLENJA add constraint FK_RELATIONSHIP_13 foreign key (APOTEKA_ID)
      references APOTEKA (APOTEKA_ID) on delete restrict on update restrict;

alter table ISTORIJA_ZAPOSLENJA add constraint FK_RELATIONSHIP_14 foreign key (RADNIK_ID)
      references FARMACEUT (RADNIK_ID) on delete restrict on update restrict;

alter table KOMERCIJALISTA add constraint FK_INHERITANCE_2 foreign key (RADNIK_ID)
      references RADNIK (RADNIK_ID) on delete restrict on update restrict;

alter table KOMERCIJALISTA add constraint FK_RELATIONSHIP_12 foreign key (APOTEKA_ID)
      references APOTEKA (APOTEKA_ID) on delete restrict on update restrict;

alter table LEK add constraint FK_RELATIONSHIP_10 foreign key (KOMANIJA_ID)
      references FARMACEUTSKA_KOMPANIJA (KOMANIJA_ID) on delete restrict on update restrict;

alter table PACIJENT add constraint FK_RELATIONSHIP_1 foreign key (DOKTOR_ID)
      references DOKTOR (DOKTOR_ID) on delete restrict on update restrict;

alter table PREPISANI_LEKOVI add constraint FK_RELATIONSHIP_4 foreign key (RECEPT_ID)
      references RECEPT (RECEPT_ID) on delete restrict on update restrict;

alter table PREPISANI_LEKOVI add constraint FK_RELATIONSHIP_5 foreign key (KOMANIJA_ID, SIFRA)
      references LEK (KOMANIJA_ID, SIFRA) on delete restrict on update restrict;

alter table PRODAJA_LEKOVA add constraint FK_RELATIONSHIP_8 foreign key (KOMANIJA_ID, SIFRA)
      references LEK (KOMANIJA_ID, SIFRA) on delete restrict on update restrict;

alter table PRODAJA_LEKOVA add constraint FK_RELATIONSHIP_9 foreign key (APOTEKA_ID)
      references APOTEKA (APOTEKA_ID) on delete restrict on update restrict;

alter table RECEPT add constraint FK_RELATIONSHIP_2 foreign key (DOKTOR_ID)
      references DOKTOR (DOKTOR_ID) on delete restrict on update restrict;

alter table RECEPT add constraint FK_RELATIONSHIP_3 foreign key (PACIJENT_ID)
      references PACIJENT (PACIJENT_ID) on delete restrict on update restrict;

alter table UGOVOR add constraint FK_RELATIONSHIP_15 foreign key (RADNIK_ID)
      references KOMERCIJALISTA (RADNIK_ID) on delete restrict on update restrict;

alter table UGOVOR add constraint FK_RELATIONSHIP_16 foreign key (KOMANIJA_ID)
      references FARMACEUTSKA_KOMPANIJA (KOMANIJA_ID) on delete restrict on update restrict;

alter table ZAMENE add constraint FK_RELATIONSHIP_6 foreign key (KOMANIJA_ID, LEK_SIFRA)
      references LEK (KOMANIJA_ID, SIFRA) on delete restrict on update restrict;

alter table ZAMENE add constraint FK_RELATIONSHIP_7 foreign key (LEK_KOMANIJA_ID, SIFRA)
      references LEK (KOMANIJA_ID, SIFRA) on delete restrict on update restrict;

