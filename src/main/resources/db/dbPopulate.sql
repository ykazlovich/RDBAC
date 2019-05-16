DELETE FROM public.order;
DELETE FROM public.item;
DELETE FROM public.client;

ALTER SEQUENCE item_id RESTART WITH 1;
ALTER SEQUENCE order_id RESTART WITH 1;
ALTER SEQUENCE client_id RESTART WITH 1;

INSERT INTO public.item("iname", "serialno") VALUES('WD10EARX', 'WX12018319423');
INSERT INTO public.item("iname", "serialno") VALUES('ST500DM001', 'SV39KDHE3');
INSERT INTO public.item("iname", "serialno") VALUES('MK3259GSXP', 'TV2KDMWU');

INSERT INTO public.client("name", "phone") VALUES('Ivanov Viktor','+375291111111');
INSERT INTO public.client("name", "phone") VALUES('Vales Dmitry','+375297777777');
INSERT INTO public.client("name", "phone") VALUES('Koval Alexander','+375295555555');

insert into public.order(description, client_id, item_id) VALUES ('Not work', 1, 1);
insert into public.order(description, client_id, item_id) VALUES ('Not detect in BIOS', 2, 2);
insert into public.order(description, client_id, item_id) VALUES ('Partition not recognized', 3, 3);
