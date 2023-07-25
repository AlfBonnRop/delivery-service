export interface Envio {
    id:number;
    alto:number;
    ancho:number;
    profundo:number;
    peso:number;
    calle_recoleccion:string;
    num_exterior_recoleccion:number;
    num_interior_recoleccion:number;
    codigo_postal_recoleccion:string;
    delegacion_recoleccion:string;
    calle_entrega:string;
    num_exterior_entrega:number;
    num_interior_entrega:number;
    codigo_postal_entrega:string;
    delegacion_entrega:string;
    fecha:string;
    costo:number;
    nombre_entrega:string;
    id_usuario:number;
    id_repartidor:number;
    entregado:number;

}

// {
//     "id": 5,
//     "alto": 20,
//     "ancho": 30,
//     "profundo": 0,
//     "peso": 2,
//     "calle_recoleccion": "Morelos",
//     "num_exterior_recoleccion": 53,
//     "num_interior_recoleccion": 0,
//     "codigo_postal_recoleccion": 4100,
//     "delegacion_recoleccion": "Coyoacan",
//     "calle_entrega": "Farolito",
//     "num_exterior_entrega": 1018,
//     "num_interior_entrega": 0,
//     "codigo_postal_entrega": 13020,
//     "delegacion_entrega": "Tlahuac",
//     "fecha": "1992-12-11T06:00:00.000+00:00",
//     "costo": 12.2,
//     "nombre_entrega": "Ricardo Perez",
//     "id_usuario": 5,
//     "id_repartidor": 0,
//     "entregado": 0
// }