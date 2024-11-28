import pool from '../../database.js'

export class DTOCalfRec {
    static insert = async (data) => {
        // return data;
        await pool.query('INSERT INTO calificacionrecetas (calificacion, recUserID)'+ ' ' +
            'VALUES (?,?)', [data.calificacion, data.recUserID]);
            return {message: 'calificacion de receta creada exitosamente', data: data};
    }
}