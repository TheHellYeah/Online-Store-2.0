
create table cart_item (
   id integer not null,
    amount integer not null,
    size varchar(255),
    product_id integer,
    user_id integer,
    primary key (id)
);

create table hibernate_sequence (
   next_val bigint
);

insert into hibernate_sequence values(1);
insert into hibernate_sequence values(1);
insert into hibernate_sequence values(1);
insert into hibernate_sequence values(1);
insert into hibernate_sequence values(1);

create table order_products (
   order_id integer not null,
    product_id integer not null
);

create table orders (
   id integer not null,
    address varchar(255),
    contact varchar(255),
    date date,
    order_payment varchar(255),
    order_status varchar(255),
    phone varchar(255),
    total integer not null,
    user_id integer,
    primary key (id)
);

create table product_images (
   product_id integer not null,
    images varchar(255)
);

create table product_sizes (
   product_id integer not null,
    amount integer,
    size varchar(255) not null,
    primary key (product_id, size)
);

create table products (
   id integer not null,
    brand varchar(255),
    category varchar(255),
    description varchar(255),
    material varchar(255),
    name varchar(255),
    price integer not null,
    rating integer not null,
    season varchar(255),
    subcategory varchar(255),
    primary key (id)
);

create table reviews (
   id integer not null,
    date date,
    description varchar(255),
    mark integer not null,
    user_id integer,
    product_id integer,
    primary key (id)
);

create table user_roles (
   user_id integer not null,
    roles varchar(255)
);

create table users (
   id integer not null,
    activation_code varchar(255),
    avatar varchar(255),
    balance integer not null,
    birthday date,
    contact_info varchar(255),
    email varchar(255),
    first_name varchar(255),
    password varchar(255),
    patronymic varchar(255),
    second_name varchar(255),
    username varchar(255),
    verified boolean default false,
    wish_list_access varchar(255),
    primary key (id)
);

create table users_cart (
   user_id integer not null,
    cart_id integer not null
);

create table wishlist (
   user_id integer not null,
    product_id integer not null
);

alter table users_cart
   add constraint users_cart_cart_constraint unique (cart_id);

alter table cart_item
   add constraint cart_item_product_fk
   foreign key (product_id)
   references products (id);

alter table cart_item
   add constraint cart_item_user_fk
   foreign key (user_id)
   references users (id);

alter table order_products
   add constraint order_products_cart_item_fk
   foreign key (product_id)
   references cart_item (id);

alter table order_products
   add constraint order_products_order_fk
   foreign key (order_id)
   references orders (id);

alter table orders
   add constraint orders_user_fk
   foreign key (user_id)
   references users (id);

alter table product_images
   add constraint product_images_product_fk
   foreign key (product_id)
   references products (id);

alter table product_sizes
   add constraint product_sizes_product_fk
   foreign key (product_id)
   references products (id);

alter table reviews
   add constraint reviews_user_fk
   foreign key (user_id)
   references users (id);

alter table reviews
   add constraint reviews_product_fk
   foreign key (product_id)
   references products (id);

alter table user_roles
   add constraint user_roles_user_fk
   foreign key (user_id)
   references users (id);

alter table users_cart
   add constraint users_cart_cart_item_fk
   foreign key (cart_id)
   references cart_item (id);

alter table users_cart
   add constraint users_cart_user_fk
   foreign key (user_id)
   references users (id);

alter table wishlist
   add constraint wishlist_product_fk
   foreign key (product_id)
   references products (id);

alter table wishlist
   add constraint wishlist_user_fk
   foreign key (user_id)
   references users (id);