--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-05-17 10:41:12

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 196 (class 1259 OID 25107)
-- Name: client_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.client_id OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 25109)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id integer DEFAULT nextval('public.client_id'::regclass) NOT NULL,
    name character varying(70) NOT NULL,
    phone character varying(70)
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 25113)
-- Name: item_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.item_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.item_id OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 25115)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    id integer DEFAULT nextval('public.item_id'::regclass) NOT NULL,
    iname character varying(50) NOT NULL,
    serialno character varying(50) NOT NULL
);


ALTER TABLE public.item OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 25119)
-- Name: order_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_id OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 25121)
-- Name: order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."order" (
    id integer DEFAULT nextval('public.order_id'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    description character varying(125),
    client_id integer,
    item_id integer
);


ALTER TABLE public."order" OWNER TO postgres;

--
-- TOC entry 2833 (class 0 OID 25109)
-- Dependencies: 197
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id, name, phone) FROM stdin;
1	Ivanov Viktor	+375291111111
2	Vales Dmitry	+375297777777
3	Koval Alexander	+375295555555
\.


--
-- TOC entry 2835 (class 0 OID 25115)
-- Dependencies: 199
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item (id, iname, serialno) FROM stdin;
1	WD10EARX	WX12018319423
2	ST500DM001	SV39KDHE3
3	MK3259GSXP	TV2KDMWU
\.


--
-- TOC entry 2837 (class 0 OID 25121)
-- Dependencies: 201
-- Data for Name: order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."order" (id, date, description, client_id, item_id) FROM stdin;
1	2019-05-16 12:22:39.008548	Not work	1	1
2	2019-05-16 12:22:39.016458	Not detect in BIOS	2	2
3	2019-05-16 12:22:39.017685	Partition not recognized	3	3
4	2019-05-16 14:08:19.274996	CWERWERWE	1	1
\.


--
-- TOC entry 2843 (class 0 OID 0)
-- Dependencies: 196
-- Name: client_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_id', 3, true);


--
-- TOC entry 2844 (class 0 OID 0)
-- Dependencies: 198
-- Name: item_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.item_id', 3, true);


--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 200
-- Name: order_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_id', 4, true);


--
-- TOC entry 2702 (class 2606 OID 25127)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- TOC entry 2704 (class 2606 OID 25129)
-- Name: item id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 2708 (class 2606 OID 25131)
-- Name: order order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 1259 OID 25132)
-- Name: fki_client_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_client_fkey ON public."order" USING btree (client_id);


--
-- TOC entry 2706 (class 1259 OID 25133)
-- Name: fki_item_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_item_fkey ON public."order" USING btree (item_id);


--
-- TOC entry 2709 (class 2606 OID 25134)
-- Name: order client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT client_fkey FOREIGN KEY (client_id) REFERENCES public.client(id);


--
-- TOC entry 2710 (class 2606 OID 25139)
-- Name: order item_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT item_fkey FOREIGN KEY (item_id) REFERENCES public.item(id);


-- Completed on 2019-05-17 10:41:15

--
-- PostgreSQL database dump complete
--

