import pool from '../database.js'

export const DTO = async(usuario)=>{
    // res.json(newUsuario);
    await pool.query('INSERT INTO users (userNombre, userPassword, userDoc)'+ ' ' +
        'VALUES("'+usuario.userNombre+'", "'+usuario.userApellido+'", "'+usuario.userDocumento+'")');
        return {message: 'Usuario creado exitosamente', data:usuario};
}