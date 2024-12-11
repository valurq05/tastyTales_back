import pool from '../../database.js'

export class DTOCalfRec {
    static insert = async (data) => {
        // return data;
        await pool.query('INSERT INTO calificacionrecetas (calificacion, recetaID, userID)'+ ' ' +
            'VALUES (?,?,?)', [data.calificacion, data.recetaID, data.userID]);
            return {message: 'calificacion de receta creada exitosamente', data: data};
    }
}