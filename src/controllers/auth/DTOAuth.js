import pool from "../../database.js";

export class DTOauth {
    static register =  async (user)=> {
        try {
            await pool.query('INSERT INTO usuarios (userNombre, userPassword, userDoc) VALUES (?, ?, ?)', [user.user.userNombre, user.password]);   
            return {message: 'Usuario registrado exitosamente.', data: {mail: user.user.userNombre, document: user.user.userDoc}};     
        } catch (e) {
            return {message: e.message}
        }
    }
}