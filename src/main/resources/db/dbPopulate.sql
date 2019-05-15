DELETE ALL FROM public.order;
DELETE ALL FROM public.order;

ALTER SEQUENCE item_id RESTART WITH 1;
ALTER SEQUENCE client_id RESTART WITH 1;
ALTER SEQUENCE order_id RESTART WITH 1;


INSERT INTO public.item(iname, serialno) VALUES ('dd', 'ee');