PGDMP  6                    }            proyecto_cafeteria    17.3    17.3 %    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16387    proyecto_cafeteria    DATABASE     x   CREATE DATABASE proyecto_cafeteria WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'es-ES';
 "   DROP DATABASE proyecto_cafeteria;
                     postgres    false            �            1259    16431 	   categoria    TABLE     �   CREATE TABLE public.categoria (
    id_categoria numeric NOT NULL,
    nombre_categoria text NOT NULL,
    descripcion_categoria text NOT NULL
);
    DROP TABLE public.categoria;
       public         heap r       postgres    false            �            1259    16391    cliente    TABLE     L  CREATE TABLE public.cliente (
    cedula_cliente numeric(12,0) NOT NULL,
    nombre_cliente text NOT NULL,
    apellido_cliente text NOT NULL,
    telefono_cliente numeric NOT NULL,
    email_cliente text NOT NULL,
    direccion_cliente text NOT NULL,
    fecha_nacimiento_cliente date NOT NULL,
    genero_cliente text NOT NULL
);
    DROP TABLE public.cliente;
       public         heap r       postgres    false            �            1259    16445    detalle_venta    TABLE     �   CREATE TABLE public.detalle_venta (
    id_detalle numeric NOT NULL,
    id_venta numeric NOT NULL,
    id_producto numeric NOT NULL,
    cantidad numeric NOT NULL,
    valor numeric NOT NULL
);
 !   DROP TABLE public.detalle_venta;
       public         heap r       postgres    false            �            1259    16398    empleado    TABLE       CREATE TABLE public.empleado (
    cedula_empleado numeric(12,0) NOT NULL,
    nombre_empleado text NOT NULL,
    apellido_empleado text NOT NULL,
    telefono_empleado numeric NOT NULL,
    email_empleado text NOT NULL,
    direccion_empleado text NOT NULL,
    fecha_nacimiento_empleado date NOT NULL,
    fecha_ingreso_empleado date NOT NULL,
    genero_empleado text NOT NULL
);
    DROP TABLE public.empleado;
       public         heap r       postgres    false            �            1259    16509    ingrediente    TABLE     �   CREATE TABLE public.ingrediente (
    id_ingrediente numeric[] NOT NULL,
    id_nutriente numeric NOT NULL,
    nombre_ingrediente text NOT NULL,
    descripcion_ingrediente text NOT NULL
);
    DROP TABLE public.ingrediente;
       public         heap r       postgres    false            �            1259    16417 	   nutriente    TABLE     i   CREATE TABLE public.nutriente (
    id_nutriente numeric NOT NULL,
    nombre_nutriente text NOT NULL
);
    DROP TABLE public.nutriente;
       public         heap r       postgres    false            �            1259    16497    producto    TABLE       CREATE TABLE public.producto (
    id_producto numeric NOT NULL,
    id_categoria numeric NOT NULL,
    nombre_producto text NOT NULL,
    id_ingrediente numeric[] NOT NULL,
    descripcion_producto text NOT NULL,
    precio_producto double precision NOT NULL
);
    DROP TABLE public.producto;
       public         heap r       postgres    false            �            1259    16405    usuario    TABLE     �   CREATE TABLE public.usuario (
    nombre_usuario text NOT NULL,
    email_usuario text NOT NULL,
    "contraseña_usuario" text NOT NULL,
    rol_usuario text NOT NULL
);
    DROP TABLE public.usuario;
       public         heap r       postgres    false            �            1259    16438    venta    TABLE     �   CREATE TABLE public.venta (
    id_venta numeric NOT NULL,
    cedula_cliente numeric(12,0) NOT NULL,
    cedula_empleado numeric(12,0) NOT NULL,
    fecha_venta date NOT NULL
);
    DROP TABLE public.venta;
       public         heap r       postgres    false            �          0    16431 	   categoria 
   TABLE DATA           Z   COPY public.categoria (id_categoria, nombre_categoria, descripcion_categoria) FROM stdin;
    public               postgres    false    221   "0       �          0    16391    cliente 
   TABLE DATA           �   COPY public.cliente (cedula_cliente, nombre_cliente, apellido_cliente, telefono_cliente, email_cliente, direccion_cliente, fecha_nacimiento_cliente, genero_cliente) FROM stdin;
    public               postgres    false    217   ?0       �          0    16445    detalle_venta 
   TABLE DATA           [   COPY public.detalle_venta (id_detalle, id_venta, id_producto, cantidad, valor) FROM stdin;
    public               postgres    false    223   \0       �          0    16398    empleado 
   TABLE DATA           �   COPY public.empleado (cedula_empleado, nombre_empleado, apellido_empleado, telefono_empleado, email_empleado, direccion_empleado, fecha_nacimiento_empleado, fecha_ingreso_empleado, genero_empleado) FROM stdin;
    public               postgres    false    218   y0       �          0    16509    ingrediente 
   TABLE DATA           p   COPY public.ingrediente (id_ingrediente, id_nutriente, nombre_ingrediente, descripcion_ingrediente) FROM stdin;
    public               postgres    false    225   �0       �          0    16417 	   nutriente 
   TABLE DATA           C   COPY public.nutriente (id_nutriente, nombre_nutriente) FROM stdin;
    public               postgres    false    220   �0       �          0    16497    producto 
   TABLE DATA           �   COPY public.producto (id_producto, id_categoria, nombre_producto, id_ingrediente, descripcion_producto, precio_producto) FROM stdin;
    public               postgres    false    224   �0       �          0    16405    usuario 
   TABLE DATA           d   COPY public.usuario (nombre_usuario, email_usuario, "contraseña_usuario", rol_usuario) FROM stdin;
    public               postgres    false    219   �0       �          0    16438    venta 
   TABLE DATA           W   COPY public.venta (id_venta, cedula_cliente, cedula_empleado, fecha_venta) FROM stdin;
    public               postgres    false    222   
1       G           2606    16437    categoria categoria_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria);
 B   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_pkey;
       public                 postgres    false    221            A           2606    16397    cliente cliente_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cedula_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public                 postgres    false    217            K           2606    16451     detalle_venta detalle_venta_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT detalle_venta_pkey PRIMARY KEY (id_detalle);
 J   ALTER TABLE ONLY public.detalle_venta DROP CONSTRAINT detalle_venta_pkey;
       public                 postgres    false    223            C           2606    16404    empleado empleado_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (cedula_empleado);
 @   ALTER TABLE ONLY public.empleado DROP CONSTRAINT empleado_pkey;
       public                 postgres    false    218            O           2606    16515    ingrediente ingrediente_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.ingrediente
    ADD CONSTRAINT ingrediente_pkey PRIMARY KEY (id_ingrediente);
 F   ALTER TABLE ONLY public.ingrediente DROP CONSTRAINT ingrediente_pkey;
       public                 postgres    false    225            E           2606    16423    nutriente nutriente_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.nutriente
    ADD CONSTRAINT nutriente_pkey PRIMARY KEY (id_nutriente);
 B   ALTER TABLE ONLY public.nutriente DROP CONSTRAINT nutriente_pkey;
       public                 postgres    false    220            M           2606    16503    producto producto_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id_producto);
 @   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_pkey;
       public                 postgres    false    224            I           2606    16444    venta venta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.venta
    ADD CONSTRAINT venta_pkey PRIMARY KEY (id_venta);
 :   ALTER TABLE ONLY public.venta DROP CONSTRAINT venta_pkey;
       public                 postgres    false    222            R           2606    16521 ,   detalle_venta detalle_venta_id_producto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT detalle_venta_id_producto_fkey FOREIGN KEY (id_producto) REFERENCES public.producto(id_producto) NOT VALID;
 V   ALTER TABLE ONLY public.detalle_venta DROP CONSTRAINT detalle_venta_id_producto_fkey;
       public               postgres    false    4685    223    224            V           2606    16526 )   ingrediente ingrediente_id_nutriente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ingrediente
    ADD CONSTRAINT ingrediente_id_nutriente_fkey FOREIGN KEY (id_nutriente) REFERENCES public.nutriente(id_nutriente) NOT VALID;
 S   ALTER TABLE ONLY public.ingrediente DROP CONSTRAINT ingrediente_id_nutriente_fkey;
       public               postgres    false    225    220    4677            T           2606    16504 #   producto producto_id_categoria_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_id_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES public.categoria(id_categoria) NOT VALID;
 M   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_id_categoria_fkey;
       public               postgres    false    221    224    4679            U           2606    16516 %   producto producto_id_ingrediente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_id_ingrediente_fkey FOREIGN KEY (id_ingrediente) REFERENCES public.ingrediente(id_ingrediente) NOT VALID;
 O   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_id_ingrediente_fkey;
       public               postgres    false    4687    224    225            S           2606    16472    detalle_venta venta    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT venta FOREIGN KEY (id_venta) REFERENCES public.venta(id_venta) NOT VALID;
 =   ALTER TABLE ONLY public.detalle_venta DROP CONSTRAINT venta;
       public               postgres    false    223    4681    222            P           2606    16452    venta venta_cedula_cliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venta
    ADD CONSTRAINT venta_cedula_cliente_fkey FOREIGN KEY (cedula_cliente) REFERENCES public.cliente(cedula_cliente) NOT VALID;
 I   ALTER TABLE ONLY public.venta DROP CONSTRAINT venta_cedula_cliente_fkey;
       public               postgres    false    217    222    4673            Q           2606    16457     venta venta_cedula_empleado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venta
    ADD CONSTRAINT venta_cedula_empleado_fkey FOREIGN KEY (cedula_empleado) REFERENCES public.empleado(cedula_empleado) NOT VALID;
 J   ALTER TABLE ONLY public.venta DROP CONSTRAINT venta_cedula_empleado_fkey;
       public               postgres    false    4675    218    222            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     