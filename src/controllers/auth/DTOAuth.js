import pool from "../../database.js";

export class DTOauth {
    static register =  async (user)=> {
        try {
            // return user;
            await pool.query('INSERT INTO usuarios (userNombre, userPassword) VALUES (?, ?)', [user.user.userNombre, user.password]);   
            const sirveDioMio = await pool.query('INSERT INTO personas (perName, perLastName, perDoc, userID) VALUES (?, ?, ?, (SELECT u.userID FROM usuarios u WHERE u.userNombre = ?) )', [user.user.perName, user.user.perLastName, user.user.perDoc, user.user.userNombre]);
            return {message: 'Usuario registrado exitosamente.', data: {mail: user.user.userNombre}};     
        } catch (e) {
            return {message: e.message}
        }
    }
}