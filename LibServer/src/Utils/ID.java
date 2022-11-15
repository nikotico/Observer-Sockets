package Utils;

import java.io.Serializable;



public enum ID implements Serializable{
    CONEXIONDENEGADA,
    INICIARCONEXION,
    BITACORA,
    SETNAME,
    CHAT,
    ADMIN,
    DENEGARACCION, //muestra mensaje de error
    FOLLOW,
    LIKES,
    DISLIKES,
    SUBASTA,
    SUBASTAR,
    SETSUBASTA,
    MESSAGE,//Mensaje X para mandar a la consola
    TEST,
    CERRADA,
    VENDIDA,
    CANCELADA,
    OFERTA,
    RECIOFERTA,
    RESPOFERTA,
    START;//inicar partida   ;
}
