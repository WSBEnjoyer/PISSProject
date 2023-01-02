CREATE TABLE product (
                         id uuid NOT NULL,
                         name varchar,
                         price varchar,
                         quantity int,
                         description varchar,
                         picture_url varchar,
                         location varchar,
                         CONSTRAINT product_pkey PRIMARY KEY (id)
);